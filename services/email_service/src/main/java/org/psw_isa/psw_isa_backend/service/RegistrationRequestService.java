package org.psw_isa.psw_isa_backend.service;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.naming.factory.SendMailFactory;
import org.psw_isa.psw_isa_backend.dtos.DeclineRegistrationRequestDTO;
import org.psw_isa.psw_isa_backend.dtos.EmailDTO;
import org.psw_isa.psw_isa_backend.dtos.RegistrationDTO;
import org.psw_isa.psw_isa_backend.dtos.RegistrationRequestDTO;
import org.psw_isa.psw_isa_backend.models.Patient;
import org.psw_isa.psw_isa_backend.models.RegistrationRequest;
import org.psw_isa.psw_isa_backend.models.User;
import org.psw_isa.psw_isa_backend.repository.PatientRepository;

import org.psw_isa.psw_isa_backend.repository.RegistrationRequestRepository;
import org.psw_isa.psw_isa_backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class RegistrationRequestService {

	@Autowired
	private RegistrationRequestRepository registrationRequestRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PatientRepository patientRepository;
	
	@Autowired
	private HashService hashService;
	
	@Autowired
	private SendEmailService sendEmailService;
	
	public List<RegistrationRequestDTO> findAllNotApproved(){
		List<RegistrationRequest> registrationRequests = registrationRequestRepository.findAll();
		List<RegistrationRequestDTO> registrationRequestDTOs = new ArrayList();
		
		for (RegistrationRequest registrationRequest : registrationRequests){
			if(!registrationRequest.getApproved()) {
				
				if(!registrationRequest.getRejected())
				registrationRequestDTOs.add(new RegistrationRequestDTO(registrationRequest));
			}
		}
		
		return registrationRequestDTOs;
	}
	
	public List<RegistrationRequest> findAll(){
		return registrationRequestRepository.findAll();
	}
	
	public RegistrationRequest save (RegistrationRequest registrationRequest) {
		return registrationRequestRepository.save(registrationRequest);
	}
	
	public RegistrationRequest newRegistrationRequest(RegistrationDTO registrationDTO) {
		User user = new User(registrationDTO.getFirstname(), registrationDTO.getLastname(), registrationDTO.getMobile_phone(), registrationDTO.getEmail(), registrationDTO.getAddress(), registrationDTO.getBirthday(), registrationDTO.getPassword(), 0);
		
		Patient patient = new Patient(user, registrationDTO.getInsuranceid());
		
		User validator = userRepository.findOneByemail(registrationDTO.getEmail());
		if(validator == null) {
			if(registrationDTO.getPassword().equals(registrationDTO.getPassword2())) {
				userRepository.save(user);
				patientRepository.save(patient);
				
				RegistrationRequest registrationRequest = new RegistrationRequest();
				registrationRequest.setPatient(patient);
				registrationRequest.setApproved(false);
				registrationRequest.setRejected(false);
				registrationRequest.setTime(LocalDateTime.now());
				
				registrationRequestRepository.save(registrationRequest);
				
				
				return registrationRequest;
			} else {
				return null;
			}
		} else {
			return null;
		}
		
	}
	
	public void remove(Long id) {
		registrationRequestRepository.deleteById(id);
	}
	
	public RegistrationRequestDTO findOneByIdDTO(Long id) {
		RegistrationRequestDTO registrationRequestDTO = new RegistrationRequestDTO(registrationRequestRepository.findOneById(id));
		return registrationRequestDTO;
	}
	
	public RegistrationRequest findOneById(Long id) {
		return registrationRequestRepository.findOneById(id);
	}
	
	public Long approve(Long id) {
		RegistrationRequest registrationRequest = registrationRequestRepository.findOneById(id);
		
		registrationRequest.setApproved(true);
		EmailDTO mail=new EmailDTO();
		mail.setTo(registrationRequest.getPatient().getUser().getEmail());
		mail.setSubject("Prihvacen zahtev za registraciju");
		String hesovan="neuspelo";
		try {
		hesovan=hashService.encrypt(registrationRequest.getPatient().getInsuranceID());
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		mail.setMessage("Vas zahtev za registraciju je odobren, molimo vas potvrdite klikom na sledeci link: "
				+ "127.0.0.1:300/frontend/#/activate/"+hesovan);
		
		sendEmailService.sendMail(mail);
		registrationRequestRepository.save(registrationRequest);
		
		return registrationRequest.getId();
	}
	
	public Long decline(DeclineRegistrationRequestDTO declineRegistrationRequestDTO) {
		RegistrationRequest registrationRequest = registrationRequestRepository.findOneById(declineRegistrationRequestDTO.getId());
		
		EmailDTO mail=new EmailDTO();
		mail.setTo(registrationRequest.getPatient().getUser().getEmail());
		mail.setSubject("Odbijen zahtev za registraciju");
		mail.setMessage(declineRegistrationRequestDTO.getComment());
		
		registrationRequest.setRejected(true);
		registrationRequestRepository.save(registrationRequest);
		sendEmailService.sendMail(mail);
		
		return registrationRequest.getId();
	}
	
}

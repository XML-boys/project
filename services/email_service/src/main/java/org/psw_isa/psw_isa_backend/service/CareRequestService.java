package org.psw_isa.psw_isa_backend.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.psw_isa.psw_isa_backend.dtos.CareRequestDTO;
import org.psw_isa.psw_isa_backend.dtos.EmailDTO;
import org.psw_isa.psw_isa_backend.models.Care;
import org.psw_isa.psw_isa_backend.models.CareRequest;
import org.psw_isa.psw_isa_backend.models.ClinicAdministrator;
import org.psw_isa.psw_isa_backend.models.Patient;
import org.psw_isa.psw_isa_backend.models.User;
import org.psw_isa.psw_isa_backend.repository.CareRepository;
import org.psw_isa.psw_isa_backend.repository.CareRequestRepository;
import org.psw_isa.psw_isa_backend.repository.ClinicAdminRepository;
import org.psw_isa.psw_isa_backend.repository.DoctorRepository;
import org.psw_isa.psw_isa_backend.repository.PatientRepository;
import org.psw_isa.psw_isa_backend.repository.UserRepository;
import org.psw_isa.psw_isa_backend.service.CheckRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


@Service
public class CareRequestService {

	@Autowired
	private CareRepository careRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private DoctorRepository doctorRepository;
	
	@Autowired
	private CareRequestRepository careRequestRepository;
	
	@Autowired
	private CheckRoleService checkRoleService;
	
	@Autowired
	private PatientRepository patientRepository;
	
	@Autowired
	SendEmailService sendEmailService;
	
	@Autowired
	ClinicAdminRepository clinicAdminRepository;
	
	
	public List<CareRequest> findAll() {
		return careRequestRepository.findAll();
	}

	public void delete(Long id) {
		careRequestRepository.delete(careRequestRepository.findOneByid(id));
	}

	public int createRequest(CareRequestDTO careRequestDTO) {
		User user = checkRoleService.getUser();
		List<Patient> allPatients = patientRepository.findAll();
		EmailDTO mail=new EmailDTO();
		List<ClinicAdministrator> allAdministrators=clinicAdminRepository.findAll();
		
		if (user == null) 
		{
			return 0;
		}else {
			Patient patient = new Patient();
			
			for(Patient checkPatient : allPatients) {
				if(checkPatient.getUser().getId() == user.getId()) {
					patient = checkPatient;
				}
			}
			
			CareRequest careRequest = new CareRequest();
			careRequest.setApproved(false);
			careRequest.setDoctor(careRequestDTO.getDoctor());
			careRequest.setTime(careRequestDTO.getStartTime());
			careRequest.setPatient(patient);
			
			careRequestRepository.save(careRequest);
			
			
			for(ClinicAdministrator admin : allAdministrators) {
				
				if(admin.getClinic().getId()==careRequestDTO.getDoctor().getClinic().getId()) {
					mail.setTo(admin.getUser().getEmail());
					mail.setSubject("Upit o pregledu");
					mail.setMessage("Pacijent:"+patient.getUser().getFirstname()+" "+ patient.getUser().getLastname()+
							" je poslao upit za pregled kod dr."+careRequestDTO.getDoctor().getUser().getLastname());
					
					sendEmailService.sendMail(mail);
				}
				
			}
			
			
			
			return 1;
		}
	}
	
	
}

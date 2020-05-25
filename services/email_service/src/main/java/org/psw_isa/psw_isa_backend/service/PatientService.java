package org.psw_isa.psw_isa_backend.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.psw_isa.psw_isa_backend.models.Patient;
import org.psw_isa.psw_isa_backend.models.User;
import org.psw_isa.psw_isa_backend.repository.UserRepository;
import org.psw_isa.psw_isa_backend.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.psw_isa.psw_isa_backend.Logger;

@Service
public class PatientService {
	
	@Autowired 
	PatientRepository patientRepository;
	
	@Autowired 
	UserRepository userRepository;
	
	@Autowired
	HashService hashService;

	public List<Patient> findAll(){
		return patientRepository.findAll();
	}
	
	//List<Patient> findAllByfirstnameAndlastnameAllIgnoringCase(String firstname, String lastname){
	//	return patientRepository.findAllByfirstnameAndlastnameAllIgnoringCase(firstname, lastname);
	//}
	
	public Patient findOneByinsuranceID(Long id) {
		return patientRepository.findOneByinsuranceID(id);
	}
	
	public Patient findOneByid(Long id) {
		return patientRepository.findOneByid(id);
	}
	
	public Patient findOneByuser(User user) {
		for (Patient u : patientRepository.findAll()) {
			if (u.getUser().getEmail().equals(user.getEmail())) return u;
		}
		return null;
	}
	
	public Patient save(Patient patient) {
		return patientRepository.save(patient);
	}
	
	
	public void activateAccount(String hash) {
		String insurance="no";
		List<Patient> allPatients=patientRepository.findAll();
		
		try {
		insurance=hashService.decrypt(hash);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		for(Patient patient : allPatients) {
			
			if(patient.getInsuranceID().equals(insurance)) {
				
				patient.setActivated(true);
				patientRepository.save(patient);
				
			}
			
		}
		
		
		
	}
	
	
	public Patient getBySession() {
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes(); 
		HttpSession session = attr.getRequest().getSession(true); 
		
        String email = (String) session.getAttribute("user");
		User user = userRepository.findOneByemail(email);
		Patient patient = findOneByuser(user);
		
		return patient;
	}

}

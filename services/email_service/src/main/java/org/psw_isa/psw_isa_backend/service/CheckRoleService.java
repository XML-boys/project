package org.psw_isa.psw_isa_backend.service;

import javax.servlet.http.HttpSession;

import org.psw_isa.psw_isa_backend.models.ClinicAdministrator;
import org.psw_isa.psw_isa_backend.models.Doctor;
import org.psw_isa.psw_isa_backend.models.Nurse;
import org.psw_isa.psw_isa_backend.models.Patient;
import org.psw_isa.psw_isa_backend.models.User;
import org.psw_isa.psw_isa_backend.repository.ClinicAdminRepository;
import org.psw_isa.psw_isa_backend.repository.DoctorRepository;
import org.psw_isa.psw_isa_backend.repository.NurseRepository;
import org.psw_isa.psw_isa_backend.repository.PatientRepository;
import org.psw_isa.psw_isa_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Service
public class CheckRoleService {
	
	@Autowired
	ClinicAdminRepository clinicAdminRepository;
	
	@Autowired
	DoctorRepository doctorRepository;
	
	@Autowired
	NurseRepository nurseRepository;
	
	@Autowired
	PatientRepository patientRepository;
	
	@Autowired 
	UserRepository userRepository;
	
	
	public String getEmail() 
	{
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes(); 
		HttpSession session = attr.getRequest().getSession(true); 
		
		String loggedEmail = (String) session.getAttribute("user");
		return loggedEmail;
	}

	public User getUser() 
	{
		String loggedEmail = getEmail();

		User loggedUser = userRepository.findOneByemail(loggedEmail);
		return loggedUser;
	}

	public boolean checkIfLogged() {
		return getUser() != null;
	}


	
	
	public boolean checkIfClinicAdministrator() {
		return checkIfLogged() && clinicAdminRepository.findAll().stream().filter(x -> x.getUser().getId() == getUser().getId()).count() > 0;
	}
	
	public boolean checkIfDoctor() {
		return checkIfLogged() && doctorRepository.findAll().stream().filter(x -> x.getUser().getId() == getUser().getId()).count() > 0;
	}
	
	
	public boolean checkIfNurse() {
		return checkIfLogged() && nurseRepository.findAll().stream().filter(x -> x.getUser().getId() == getUser().getId()).count() > 0;
	}
	
	public boolean checkIfPatient() {
		return checkIfLogged() && patientRepository.findAll().stream().filter(x -> x.getUser().getId() == getUser().getId()).count() > 0;
	}
	
	public boolean checkIfPatient(String email) {
		
		return patientRepository.findAll().stream().filter(x -> x.getUser().getEmail() == email).count() > 0;
		
	}
	
	
}

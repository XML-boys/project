package org.psw_isa.psw_isa_backend.service;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.psw_isa.psw_isa_backend.dtos.LogInDTO;
import org.psw_isa.psw_isa_backend.models.RegistrationRequest;
import org.psw_isa.psw_isa_backend.models.User;
import org.psw_isa.psw_isa_backend.models.Patient;
import org.psw_isa.psw_isa_backend.repository.RegistrationRequestRepository;
import org.psw_isa.psw_isa_backend.repository.PatientRepository;
import org.psw_isa.psw_isa_backend.repository.UserRepository;
import org.psw_isa.psw_isa_backend.service.CheckRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import org.psw_isa.psw_isa_backend.Logger;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	@Autowired
	RegistrationRequestRepository registrationRequestRepository;

	@Autowired
	CheckRoleService checkRoleService;

	@Autowired
	PatientService patientService;

	public User findOneByemail(String email) {
		return userRepository.findOneByemail(email);
	}

	public User findOneByid(Long id) {
		return userRepository.findOneByid(id);
	}

	public int updateUser(String firstname, String lastname, String address, LocalDate birthday, String mobile_phone,
			String password, Long id) {
		return userRepository.updateUser(firstname, lastname, address, birthday, mobile_phone, password, id);
	}

	public User save(User user) {
		return userRepository.save(user);
	}

	public void logOut() {
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpSession session = attr.getRequest().getSession(true);
		session.invalidate();
	}

	public int login(LogInDTO loginData) {
		User user = userRepository.findOneByemail(loginData.getEmail());
		if (user != null) {
			Long id = user.getId();

			if (loginData.getPassword().equals(user.getPassword())) {

				// check if user is not patient, if not, login immediately
				Patient patient = patientService.findOneByuser(user);
				if (patient == null) {
					Logger.getInstance().debug("Ignoring registration requests because user is not patient");
					// we do noot need to check registration requests
					ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder
							.currentRequestAttributes();
					HttpSession session = attr.getRequest().getSession(true);

					session.setAttribute("user", user.getEmail());
					user.increaseNumberOfLogins();
					save(user);
					return 1;

				}

				List<RegistrationRequest> registrationRequests = registrationRequestRepository.findAll();
				for (RegistrationRequest request : registrationRequests) {
					if (request.getPatient().getUser().getId() == id) {
						if (request.getApproved() == true) {
							if (request.getPatient().isActivated()) {
								ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder
										.currentRequestAttributes();
								HttpSession session = attr.getRequest().getSession(true);

								session.setAttribute("user", user.getEmail());
								user.increaseNumberOfLogins();
								save(user);
								return 1;
							} else {
								Logger.getInstance().debug("Request found but not activated");
								return 0;
							}
						} else {

							Logger.getInstance().debug("Request found but not approved");
							return 0;
						}
					}
				}
				Logger.getInstance().debug("Not found approved request for this user");

			} else {

				Logger.getInstance().debug("Password incorrect");
				return 0;
			}
		} else {
			Logger.getInstance().warning("user with this email is not found");
			return 0;
		}
		return 0;

	}

}

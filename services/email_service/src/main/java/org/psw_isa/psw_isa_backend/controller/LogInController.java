package org.psw_isa.psw_isa_backend.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.psw_isa.psw_isa_backend.dtos.LogInDTO;
import org.psw_isa.psw_isa_backend.models.RegistrationRequest;
import org.psw_isa.psw_isa_backend.models.User;
import org.psw_isa.psw_isa_backend.service.RegistrationRequestService;
import org.psw_isa.psw_isa_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import org.psw_isa.psw_isa_backend.Logger;

@RestController
@RequestMapping(value = "login")
public class LogInController {

	@Autowired
	UserService userService;
	@Autowired
	RegistrationRequestService registrationRequestService;
	
	@PostMapping(consumes = "application/json")
	public ResponseEntity<Long> login(@RequestBody LogInDTO loginData){
		Logger.getInstance().debug("Login called");
		int result = userService.login(loginData);
		if(result == 1) {
			return new ResponseEntity<>(null, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
		}
	}
	
	
	
}

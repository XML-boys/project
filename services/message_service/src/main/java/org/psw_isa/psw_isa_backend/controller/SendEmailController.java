package org.psw_isa.psw_isa_backend.controller;


import org.psw_isa.psw_isa_backend.dtos.EmailDTO;
import org.psw_isa.psw_isa_backend.service.SendEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "email")
public class SendEmailController {

	@Autowired
	SendEmailService sendEmailService;
	
	
	
	
	@Autowired
    public JavaMailSender emailSender;
	
	@PostMapping(consumes = "application/json")
	public ResponseEntity<String> sendMail(@RequestBody EmailDTO emailDTO)
	  {
		      
		        
		sendEmailService.sendMail(emailDTO);
		
		        return new ResponseEntity<>(emailDTO.getTo(),HttpStatus.OK); 
		    }
	
	

}

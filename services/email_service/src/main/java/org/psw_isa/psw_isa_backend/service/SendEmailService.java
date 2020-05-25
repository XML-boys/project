package org.psw_isa.psw_isa_backend.service;

import org.psw_isa.psw_isa_backend.dtos.EmailDTO;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


@Service
public class SendEmailService {

	@Autowired
    public JavaMailSender emailSender;
	
	
	
	
	
	public void sendMail(EmailDTO emailDTO)
	  {
		      
		        SimpleMailMessage message = new SimpleMailMessage(); 
		        message.setTo(emailDTO.getTo()); 
		        message.setSubject(emailDTO.getSubject()); 
		        message.setText(emailDTO.getMessage());
		        emailSender.send(message);
		       
		    }
	
}

package org.psw_isa.psw_isa_backend.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.psw_isa.psw_isa_backend.dtos.DeclineRegistrationRequestDTO;
import org.psw_isa.psw_isa_backend.dtos.RegistrationDTO;
import org.psw_isa.psw_isa_backend.dtos.RegistrationRequestDTO;
import org.psw_isa.psw_isa_backend.models.Patient;
import org.psw_isa.psw_isa_backend.models.RegistrationRequest;
import org.psw_isa.psw_isa_backend.models.User;
import org.psw_isa.psw_isa_backend.repository.RegistrationRequestRepository;
import org.psw_isa.psw_isa_backend.service.PatientService;
import org.psw_isa.psw_isa_backend.service.RegistrationRequestService;
import org.psw_isa.psw_isa_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "registrationRequests")
public class RegistrationRequestController {

	
	@Autowired
	private RegistrationRequestService registrationRequestService;
	
	
	@GetMapping(value = "/all")
	public ResponseEntity<List<RegistrationRequestDTO>> findAllNotApproved (){
		
		return new ResponseEntity<>(registrationRequestService.findAllNotApproved(), HttpStatus.OK);
	}
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<RegistrationRequestDTO> findOneById(@PathVariable("id") Long id){
		
		return new ResponseEntity<>(registrationRequestService.findOneByIdDTO(id), HttpStatus.OK);
	}
	
	@PostMapping(consumes = "application/json")
	public ResponseEntity<RegistrationRequest> save(@RequestBody RegistrationDTO registrationDTO){
		
		if(registrationRequestService.newRegistrationRequest(registrationDTO) == null) {
			return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
		} else {
			return new ResponseEntity<>(registrationRequestService.newRegistrationRequest(registrationDTO), HttpStatus.OK);
		}
	}
	
	
	@PutMapping(value = "/approve/{id}")
	public ResponseEntity<Long> approve(@PathVariable("id") Long id){		
	
		
		Long retID = registrationRequestService.approve(id);
		
		return new ResponseEntity<>(retID, HttpStatus.OK);
	}
	
	
	@PutMapping(value = "/decline",consumes = "application/json" )
	public ResponseEntity<Long> decline(@RequestBody DeclineRegistrationRequestDTO declineRegistrationRequestDTO){		
		
		
		Long retID = registrationRequestService.decline(declineRegistrationRequestDTO);
		
		
		return new ResponseEntity<>(retID, HttpStatus.OK);
	}
	
	
}

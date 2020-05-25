package org.psw_isa.psw_isa_backend.controller;

import javax.websocket.server.PathParam;

import org.psw_isa.psw_isa_backend.dtos.CareRequestDTO;
import org.psw_isa.psw_isa_backend.service.CareRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "careRequest")
public class CareRequestController {
	
	@Autowired
	private CareRequestService careRequestService;
	
	
	@PostMapping(consumes = "application/json")
	public ResponseEntity<Long> createCareRequest(@RequestBody CareRequestDTO careRequestDTO){
		int i = careRequestService.createRequest(careRequestDTO);
		
		if(i == 0) {
			return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
		} else {
			return new ResponseEntity<>(null, HttpStatus.OK);
		}
		
	}

}

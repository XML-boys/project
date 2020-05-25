package org.psw_isa.psw_isa_backend.controller;


import java.util.List;


import org.psw_isa.psw_isa_backend.models.OperationRequest;
import org.psw_isa.psw_isa_backend.service.OperationRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.psw_isa.psw_isa_backend.dtos.OperationRequestDTO;

@RestController
@RequestMapping(value = "operationRequest")
public class OperationRequestController {

	@Autowired
	OperationRequestService operationRequestService;
	
	
	@GetMapping(value="")
	public ResponseEntity<List<OperationRequest>> findAll(){
		return new ResponseEntity<>(operationRequestService.findAll(), HttpStatus.OK);
	}

	@PostMapping(value="")
	public ResponseEntity<OperationRequest> save(@RequestBody OperationRequestDTO dto) {
		return new ResponseEntity<>(operationRequestService.save(dto), HttpStatus.OK);
	}

	
	@GetMapping(value="/forClinic")
	public ResponseEntity<List<OperationRequest>> findAllForClinic(){
		
		return new ResponseEntity<>(operationRequestService.operationRequestForClinic(), HttpStatus.OK);
	}
	
	
	@GetMapping(value="/delete/{id}")
	public ResponseEntity<String> deleteOperationRequest(@PathVariable("id") Long id){
		
		operationRequestService.deleteOneById(id);
		
		return new ResponseEntity<>("OK", HttpStatus.OK);

	}
}

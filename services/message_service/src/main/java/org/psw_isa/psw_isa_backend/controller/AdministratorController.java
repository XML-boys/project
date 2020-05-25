package org.psw_isa.psw_isa_backend.controller;

import java.util.List;


import org.psw_isa.psw_isa_backend.models.Administrator;
import org.psw_isa.psw_isa_backend.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "administrator")
public class AdministratorController {

	
	@Autowired
	AdministratorService administratorService;

	
	@GetMapping(value="/{id}")
	public ResponseEntity<Administrator> read(@PathVariable("id") Long id){
		
		Administrator administrator = administratorService.findOneByid(id);
		return new ResponseEntity<>(administrator,HttpStatus.OK);
	}
	
	@GetMapping(value = "/all")
	public ResponseEntity<List<Administrator>> getAdministrators(){
		List<Administrator>administrators = administratorService.findAll();
		
		return new ResponseEntity<>(administrators, HttpStatus.OK);
		
	}
	
}

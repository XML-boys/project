package org.psw_isa.psw_isa_backend.controller;

import org.psw_isa.psw_isa_backend.service.VacationService;

import java.util.List;

import org.psw_isa.psw_isa_backend.models.Vacation;

//import org.psw_isa.psw_isa_backend.dtos.VacationDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(value = "vacation")
public class VacationController {
	
	@Autowired 
	VacationService vacationService;
		
	
	@GetMapping(value="/")
	public ResponseEntity<List<Vacation>> findAll(){
		return new ResponseEntity<>(vacationService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping(value="/vacationUser/{date}")
	public ResponseEntity<Long> getVacationDoctor(@PathVariable("date") String date){
		
		
		
		return new ResponseEntity<Long>(vacationService.findVacation(date),HttpStatus.OK);
	}
	
	
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Vacation> findOneByid(@PathVariable("id") Long id){
		return new ResponseEntity<>(vacationService.findOneByid(id), HttpStatus.OK);
	}
	
	@PostMapping(consumes = "application/json")
	public ResponseEntity<Long> save(@RequestBody Vacation dto){
		Long id = vacationService.save(dto);
		return new ResponseEntity<>(id,HttpStatus.OK);
	}
	
	
	@PostMapping(value="/{id}", consumes = "application/json")
	public ResponseEntity<Long> update(@PathVariable("id") Long id, @RequestBody Vacation dto){
		
		return new ResponseEntity<>(vacationService.update(id, dto),HttpStatus.OK);
	}
}

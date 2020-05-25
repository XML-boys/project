package org.psw_isa.psw_isa_backend.controller;

import org.psw_isa.psw_isa_backend.service.VacationTypeService;

import java.util.List;

import org.psw_isa.psw_isa_backend.models.VacationType;

//import org.psw_isa.psw_isa_backend.dtos.VacationTypeDTO;

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
@RequestMapping(value = "vacationType")
public class VacationTypeController {
	
	@Autowired 
	VacationTypeService vacationTypeService;
		
	
	@GetMapping(value="/")
	public ResponseEntity<List<VacationType>> findAll(){
		return new ResponseEntity<>(vacationTypeService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<VacationType> findOneByid(@PathVariable("id") Long id){
		return new ResponseEntity<>(vacationTypeService.findOneByid(id), HttpStatus.OK);
	}
	
	/*@PostMapping(consumes = "application/json")
	public ResponseEntity<Long> save(@RequestBody VacationTypeDTO dto){
		
		VacationType vacationType = vacationTypeService.save(dto);
		return new ResponseEntity<>(vacationType.getId(),HttpStatus.OK);
	}
	
	
	@PostMapping(value="/{id}", consumes = "application/json")
	public ResponseEntity<Long> update(@RequestBody VacationTypeDTO dto){
		
		VacationType data = vacationTypeService.save(dto);
		return new ResponseEntity<>(data.getId(),HttpStatus.OK);
	}*/
}

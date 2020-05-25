package org.psw_isa.psw_isa_backend.controller;

import java.util.List;

import org.psw_isa.psw_isa_backend.models.CareType;
import org.psw_isa.psw_isa_backend.service.CareTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "careType")
public class CareTypeController {
	
	@Autowired 
	CareTypeService careTypeService;
	
	
	@GetMapping(value="")
	public ResponseEntity<List<CareType>> findAllUnassignedAndUpcoming(){
		return new ResponseEntity<>(careTypeService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<CareType> findOneByid(@PathVariable("id") Long id){
		return new ResponseEntity<CareType>(careTypeService.findOneByid(id), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<CareType> create(@RequestBody CareType careType) 
	{
		return new ResponseEntity<CareType>(careTypeService.save(careType), HttpStatus.OK);
		
	}
	@PostMapping(value = "/{id}")
	public ResponseEntity<CareType> update(@PathVariable Long id, @RequestBody CareType careType) 
	{
		careType.setId(id);
		return new ResponseEntity<CareType>(careTypeService.update(careType), HttpStatus.OK);
		
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Long> delete(@PathVariable Long id) 
	{
		return new ResponseEntity<Long>(careTypeService.delete(id), HttpStatus.OK);
		
	}


}

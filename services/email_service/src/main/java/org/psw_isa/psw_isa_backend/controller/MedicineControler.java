package org.psw_isa.psw_isa_backend.controller;


import java.util.List;

import org.psw_isa.psw_isa_backend.models.Medicine;
import org.psw_isa.psw_isa_backend.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "medicine")

public class MedicineControler {
	
	@Autowired
	private MedicineService medicineService;
	
	
	@PostMapping(consumes = "application/json")
	public ResponseEntity<Long> save(@RequestBody Medicine medicine){
		
		
		medicineService.save(medicine);
		
		return new ResponseEntity<>(medicine.getId(),HttpStatus.OK);
	}
	
	@GetMapping(value="")
	public ResponseEntity<List<Medicine>> list(){
		
		return new ResponseEntity<>(medicineService.findAll(),HttpStatus.OK);
	}
}

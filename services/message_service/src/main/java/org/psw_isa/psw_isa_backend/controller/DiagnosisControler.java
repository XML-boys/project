package org.psw_isa.psw_isa_backend.controller;

import java.util.List;

import org.psw_isa.psw_isa_backend.models.Clinic;
import org.psw_isa.psw_isa_backend.models.Diagnosis;
import org.psw_isa.psw_isa_backend.service.DiagnosisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "diagnosis")
public class DiagnosisControler {
	
	@Autowired
	private DiagnosisService diagnosisService;
	
	
	@PostMapping(consumes = "application/json")
	public ResponseEntity<Long> save(@RequestBody Diagnosis diagnosis){
		
		
		diagnosisService.save(diagnosis);
		
		return new ResponseEntity<>(diagnosis.getId(),HttpStatus.OK);
	}
	
	
	@GetMapping(value="")
	public ResponseEntity<List<Diagnosis>> list(){
		
		return new ResponseEntity<>(diagnosisService.findAll(),HttpStatus.OK);
	}
	
	@PostMapping(value="/updateDiagnosis" ,consumes = "application/json")
	public ResponseEntity<Long> updateDiagnosis(@RequestBody Diagnosis diagnosis){
		
		
		diagnosisService.save(diagnosis);
		
		return new ResponseEntity<>(diagnosis.getId(),HttpStatus.OK);
	}
}

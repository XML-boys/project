package org.psw_isa.psw_isa_backend.controller;

import org.psw_isa.psw_isa_backend.service.DoctorService;
import org.psw_isa.psw_isa_backend.service.CheckRoleService;
import org.psw_isa.psw_isa_backend.service.ClinicAdminService;
import org.psw_isa.psw_isa_backend.service.ClinicService;
import org.psw_isa.psw_isa_backend.models.Patient;

import java.util.ArrayList;
import java.util.List;

import org.psw_isa.psw_isa_backend.dtos.CareRequestDTO;
import org.psw_isa.psw_isa_backend.models.ClinicAdministrator;
import org.psw_isa.psw_isa_backend.models.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "doctor")
public class DoctorController {
	
	@Autowired 
	DoctorService doctorService;

	@Autowired
	ClinicService clinicService;
	
	@Autowired
	CheckRoleService checkRoleService;
	
	@Autowired
	ClinicAdminService clinicAdminService;
	
	@GetMapping(value="/")
	public ResponseEntity<List<Doctor>> findAll(){
		return new ResponseEntity<>(doctorService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping(value="/forClinic")
	public ResponseEntity<List<Doctor>> findAllInClinic(){
		
		return new ResponseEntity<>(doctorService.doctorForClinic(), HttpStatus.OK);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Doctor> findOneByid(@PathVariable("id") Long id){
		return new ResponseEntity<>(doctorService.findOneByid(id), HttpStatus.OK);
	}
	

	@GetMapping(value="/patients")
	public ResponseEntity<List<Patient>> findPatients(){
		return new ResponseEntity<>(clinicService.findPatientsForClinic(doctorService.getClinic()), HttpStatus.OK);
	}
	/*
	@PostMapping(value="/filter", consumes = "application/json")
	public ResponseEntity<List<Doctor>> FreeDoctorsFromClinic(@RequestBody ClinicFilterDTO clinicFilterDTO){
		return new ResponseEntity<>(doctorService.findFreeDoctors(clinicFilterDTO), HttpStatus.OK);
	}
	*/
	
  @GetMapping(value="/getFreeDoctorsForClinic/{clinicID}/{careTypeID}/{date}") 
  	public ResponseEntity<List<Doctor>>listFreeDoctorsForClinic(@PathVariable("clinicID") Long clinicID, @PathVariable("careTypeID") Long careTypeID, @PathVariable("date") String date){
	  List<Doctor> res = doctorService.listFreeDoctorsForClinic(clinicID, careTypeID, date);
	  return new ResponseEntity<>(res, HttpStatus.OK);
	  }
  
  
  @GetMapping(value="/getAvailableCaresForDoctor/{careTypeID}/{doctorID}/{date}") 
	public ResponseEntity<List<CareRequestDTO>>listAvailableCaresForDoctor(@PathVariable("careTypeID") Long careTypeID, @PathVariable("doctorID") Long doctorID, @PathVariable("date") String date){

	  return new ResponseEntity<>(doctorService.listAvailableCaresForDoctor(careTypeID, doctorID, date), HttpStatus.OK);
	  }
}

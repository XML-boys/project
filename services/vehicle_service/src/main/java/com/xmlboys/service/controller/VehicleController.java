package com.xmlboyz.service.controller;

import com.xmlboyz.service.service.VehicleService;

import java.util.List;

import com.xmlboyz.service.models.Vehicle;

import com.xmlboyz.service.dtos.VehicleDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;


@RestController
@CrossOrigin
@RequestMapping(value = "vehicles")
public class VehicleController {
	
	@Autowired 
	VehicleService vehicleService;
		
	
	@GetMapping(value="/")
	public ResponseEntity<List<Vehicle>> findAll(){
		return new ResponseEntity<>(vehicleService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Vehicle> findOneByid(@PathVariable("id") Long id){
		return new ResponseEntity<>(vehicleService.findOneByid(id), HttpStatus.OK);
	}
	
	@PostMapping(consumes = "application/json")
	public ResponseEntity<Long> save(@RequestBody Vehicle dto){
		
		Vehicle vehicle = vehicleService.save(dto);
		return new ResponseEntity<>(vehicle.getId(),HttpStatus.OK);
	}
	
	
	@PostMapping(value="/{id}", consumes = "application/json")
	public ResponseEntity<Long> update(@RequestBody Vehicle dto){
		
		Vehicle data = vehicleService.save(dto);
		return new ResponseEntity<>(data.getId(),HttpStatus.OK);
	}
}

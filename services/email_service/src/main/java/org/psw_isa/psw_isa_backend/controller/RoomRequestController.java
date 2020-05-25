package org.psw_isa.psw_isa_backend.controller;

import org.psw_isa.psw_isa_backend.service.RoomRequestService;

import java.util.List;

import org.psw_isa.psw_isa_backend.models.RoomRequest;

//import org.psw_isa.psw_isa_backend.dtos.RoomRequestDTO;

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
@RequestMapping(value = "roomRequest")
public class RoomRequestController {
	
	@Autowired 
	RoomRequestService roomRequestService;
		
	
	@GetMapping(value="/")
	public ResponseEntity<List<RoomRequest>> findAll(){
		return new ResponseEntity<>(roomRequestService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<RoomRequest> findOneByid(@PathVariable("id") Long id){
		return new ResponseEntity<>(roomRequestService.findOneByid(id), HttpStatus.OK);
	}
	
	/*@PostMapping(consumes = "application/json")
	public ResponseEntity<Long> save(@RequestBody RoomRequestDTO dto){
		
		RoomRequest roomRequest = roomRequestService.save(dto);
		return new ResponseEntity<>(roomRequest.getId(),HttpStatus.OK);
	}
	
	
	@PostMapping(value="/{id}", consumes = "application/json")
	public ResponseEntity<Long> update(@RequestBody RoomRequestDTO dto){
		
		RoomRequest data = roomRequestService.save(dto);
		return new ResponseEntity<>(data.getId(),HttpStatus.OK);
	}*/
}

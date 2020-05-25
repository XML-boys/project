package org.psw_isa.psw_isa_backend.controller;

import org.psw_isa.psw_isa_backend.service.RoomService;

import java.util.List;

import org.psw_isa.psw_isa_backend.models.Room;

import org.psw_isa.psw_isa_backend.dtos.RoomDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import java.time.LocalDateTime;


@RestController
@RequestMapping(value = "room")
public class RoomController {
	
	@Autowired 
	RoomService roomService;

	@GetMapping(value="/")
	public ResponseEntity<List<Room>> findAll(){
		return new ResponseEntity<>(roomService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Room> findOneByid(@PathVariable("id") Long id){
		return new ResponseEntity<>(roomService.findOneByid(id), HttpStatus.OK);
	}
	
	@PostMapping(consumes = "application/json")
	public ResponseEntity<Long> save(@RequestBody RoomDTO dto){
		
		Room room = roomService.save(dto);
		return new ResponseEntity<>(room.getId(),HttpStatus.OK);
	}
	
	
	@PostMapping(value="/{id}", consumes = "application/json")
	public ResponseEntity<Long> update(@RequestBody RoomDTO dto){
		
		Room data = roomService.update(dto);
		return new ResponseEntity<>(data.getId(),HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Long> delete(@PathVariable("id") Long id) 
	{
		return new ResponseEntity<>(roomService.delete(id), HttpStatus.OK);
	}

	@GetMapping(value="/{id}/next")
	public ResponseEntity<LocalDateTime> findNextTimeForRoom(@PathVariable("id") Long roomId) {
		return new ResponseEntity<>(roomService.findNextTimeForRoom(roomId), HttpStatus.OK);
	}

}

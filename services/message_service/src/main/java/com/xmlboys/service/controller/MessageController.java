package com.xmlboys.service.controller;

import com.xmlboys.service.service.MessageService;

import java.util.List;

import com.xmlboys.service.models.Message;

import com.xmlboys.service.dtos.MessageDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
@RequestMapping(value = "message")
public class MessageController {
	
	@Autowired 
	MessageService messageService;
		
	
	@GetMapping(value="/")
	public ResponseEntity<List<Message>> findAll(){
		return new ResponseEntity<>(messageService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Message> findOneByid(@PathVariable("id") Long id){
		return new ResponseEntity<>(messageService.findOneByid(id), HttpStatus.OK);
	}
	
	@PostMapping(consumes = "application/json")
	public ResponseEntity<Long> save(@RequestBody MessageDTO dto){
		
		Message message = messageService.save(dto);
		return new ResponseEntity<>(message.getId(),HttpStatus.OK);
	}
	
	
	@PostMapping(value="/{id}", consumes = "application/json")
	public ResponseEntity<Long> update(@RequestBody MessageDTO dto){
		
		Message data = messageService.save(dto);
		return new ResponseEntity<>(data.getId(),HttpStatus.OK);
	}
}
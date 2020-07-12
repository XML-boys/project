package com.xmlboys.service.controller;

import com.xmlboys.service.service.ConversationService;

import java.util.List;

import com.xmlboys.service.models.Conversation;

import com.xmlboys.service.dtos.ConversationDTO;

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


@RestController
@CrossOrigin
@RequestMapping(value = "conversation")
public class ConversationController {
	
	@Autowired 
	ConversationService conversationService;
		
	
	@GetMapping(value="/")
	public ResponseEntity<List<Conversation>> findAll(){
		return new ResponseEntity<>(conversationService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Conversation> findOneByid(@PathVariable("id") Long id){
		return new ResponseEntity<>(conversationService.findOneByid(id), HttpStatus.OK);
	}
	
	@PostMapping(consumes = "application/json")
	public ResponseEntity<Long> save(@RequestBody ConversationDTO dto){
		
		Conversation conversation = conversationService.save(dto);
		return new ResponseEntity<>(conversation.getId(),HttpStatus.OK);
	}
	
	
	@PostMapping(value="/{id}", consumes = "application/json")
	public ResponseEntity<Long> update(@RequestBody ConversationDTO dto){
		
		Conversation data = conversationService.save(dto);
		return new ResponseEntity<>(data.getId(),HttpStatus.OK);
	}
}
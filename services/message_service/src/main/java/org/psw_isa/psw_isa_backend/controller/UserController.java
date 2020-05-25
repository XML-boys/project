package org.psw_isa.psw_isa_backend.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.psw_isa.psw_isa_backend.models.User;
import org.psw_isa.psw_isa_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "users")
public class UserController {

	
	@Autowired
	private UserService userService;
	
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findOneById(@PathVariable("id") Long id){
		
		User user = userService.findOneByid(id);
		
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	@PostMapping(value = "/logOut")
	public ResponseEntity<Long> logOut(){
		userService.logOut();
		return new ResponseEntity<>(null, HttpStatus.OK);
	}
	
	
}

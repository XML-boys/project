package org.psw_isa.psw_isa_backend.controller;


import org.psw_isa.psw_isa_backend.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "service")
public class ServiceController {

	@Autowired
	private SystemService systemService;
	
	@PostMapping(value="/scheduleOperation")
	public ResponseEntity<String> schedule()
	{
		      
		systemService.systemSchedule();    
		
		        return new ResponseEntity<>("OK",HttpStatus.OK); 
	}
	@PostMapping(value="/scheduleCare")
	public ResponseEntity<String> scheduleCare()
	{
		      
		systemService.systemCareSchedule();    
		
		        return new ResponseEntity<>("OK",HttpStatus.OK); 
	}
	
}

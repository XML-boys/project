package com.xmlboys.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class BackendApplication extends SpringBootServletInitializer {
	
	@Override
   	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        	return application.sources(BackendApplication.class);
    	}

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

}

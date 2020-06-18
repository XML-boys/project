package com.xmlboys.controller;

import com.xmlboys.dto.UserValidateDTO;
import com.xmlboys.service.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@CrossOrigin
@RequestMapping(value = "/adminUser")
public class UserController {


    @GetMapping
    public ResponseEntity<?> getUsers(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        String requestTokenHeader = httpServletRequest.getHeader("Authorization");
        String jwt = requestTokenHeader.substring(7);
        RestService restService = new RestService(new RestTemplateBuilder());
        UserValidateDTO userValidateDTO = restService.getUserValidate(jwt);

        if(!userValidateDTO.getRole().equals("ADMIN")){
            return  new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        return  new ResponseEntity<>(restService.getUsers(jwt), HttpStatus.OK);

    }
}

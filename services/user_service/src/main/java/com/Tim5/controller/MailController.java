package com.Tim5.controller;

import com.Tim5.config.JwtTokenUtil;
import com.Tim5.model.Client;
import com.Tim5.model.User;
import com.Tim5.service.ClientService;
import com.Tim5.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin
@RequestMapping(value = "/mail")
public class MailController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> getClient(@PathVariable("id") Long id, HttpServletRequest request){

        User user = userService.findUserById(id);
        if(user == null)
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        return ResponseEntity.ok(user);
    }
}

package com.Tim5.controller;

import com.Tim5.dto.UserDTO;
import com.Tim5.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "/reg")
public class RegisterController {

    @Autowired
    private UserService userDetailsService;


    @RequestMapping( method = RequestMethod.POST)
    public ResponseEntity<?> saveUser(@RequestBody UserDTO user) throws Exception {
        user.setApproved(false);
        return ResponseEntity.ok(userDetailsService.save(user));
    }
}

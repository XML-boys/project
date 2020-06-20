package com.Tim5.controller;

import com.Tim5.model.User;
import com.Tim5.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping()
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") Long id){
        User user = userService.findUserById(id);
        if(user != null)
            return ResponseEntity.ok(user);
        return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping(value = "/{id}")
    public HttpStatus updateUser(@PathVariable("id") Long id, @RequestBody User user){
        User u = userService.findUserById(id);
        if(u != null){}
        return HttpStatus.OK;
    }

    // ------- Pitati asistenta--------------------------------

    @PutMapping(value = "/{id}/approved/true")
    public HttpStatus updateUser(@PathVariable("id") Long id){
        User u = userService.findUserById(id);
        if(u != null){
            u.setApproved(true);
            userService.save(u);
            return HttpStatus.OK;
        }
        return HttpStatus.NOT_MODIFIED;
    }

    // --------------------------------------------------------

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id){
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}

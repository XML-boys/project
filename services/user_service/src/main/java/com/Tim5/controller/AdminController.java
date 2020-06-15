package com.Tim5.controller;

import com.Tim5.dto.LongBoolDTO;
import com.Tim5.dto.UserLoginDTO;
import com.Tim5.model.Client;
import com.Tim5.service.AdminService;
import com.Tim5.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/adminUser")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.PUT)
    public void blockUser(@RequestBody LongBoolDTO longBoolDTO){
        adminService.blockUser(longBoolDTO);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathParam("id") Long id){
        userService.deleteUser(id);
    }

    @RequestMapping( method = RequestMethod.GET)
    public List<Client> getAllClients(){
        return adminService.getAll();
    }

}

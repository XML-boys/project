package com.Tim5.controller;

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

    @RequestMapping(value = "/block/{id}", method = RequestMethod.POST)
    public void blockUser(@PathParam("id") Long id){
        adminService.blockUser(id);
    }

    @RequestMapping(value = "/unblock/{id}", method = RequestMethod.POST)
    public void unblockUser(@PathParam("id") Long id){
        adminService.unblockUser(id);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathParam("id") Long id){
        userService.deleteUser(id);
    }

    @RequestMapping(value = "/getAllClients", method = RequestMethod.GET)
    public List<Client> getAllClients(){
        return adminService.getAll();
    }

}

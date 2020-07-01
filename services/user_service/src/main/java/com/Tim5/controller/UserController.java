package com.Tim5.controller;

import com.Tim5.model.*;
import com.Tim5.service.AdminService;
import com.Tim5.service.AgentService;
import com.Tim5.service.ClientService;
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
    @Autowired
    private ClientService clientService;
    @Autowired
    private AgentService agentService;
    @Autowired
    private AdminService adminService;

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
        User user = userService.findUserById(id);
        if(user.getRole().equals(ROLE.Client)){
            Client client = this.clientService.findByUserId(id);
            this.clientService.delete(client.getId());
        }
        else if(user.getRole().equals(ROLE.Agent)){
            Agent agent = agentService.findByUserId(user.getId());
            this.agentService.delete(agent.getId());
        }
        else if(user.getRole().equals(ROLE.ADMIN)){
            Admin admin = adminService.findByUserId(user.getId());
            this.adminService.delete(admin.getId());
        }
        userService.deleteUser(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = "/{id}/role")
    public HttpStatus updateRole(@PathVariable("id") Long id, @RequestBody String role) {
        User user = userService.findUserById(id);
        if(user.getRole().equals(ROLE.Client)){
            Client client = this.clientService.findByUserId(id);
            this.clientService.delete(client.getId());
        }
        else if(user.getRole().equals(ROLE.Agent)){
            Agent agent = agentService.findByUserId(user.getId());
            this.agentService.delete(agent.getId());
        }
        else if(user.getRole().equals(ROLE.ADMIN)){
            Admin admin = adminService.findByUserId(user.getId());
            this.adminService.delete(admin.getId());
        }

        if(role.equals(ROLE.Client.name())){
            this.clientService.save(new Client(user.getId()));
        }
        else if(role.equals(ROLE.Agent.name())){
            this.agentService.save(new Agent(user.getId()));
        }
        else if(role.equals(ROLE.ADMIN.name())){
            this.adminService.save(new Admin(user.getId()));
        }

        user.setRole(ROLE.valueOf(role));
        userService.save(user);

        return HttpStatus.OK;
    }


    }

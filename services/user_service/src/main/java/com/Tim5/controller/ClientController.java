package com.Tim5.controller;

import com.Tim5.config.JwtTokenUtil;
import com.Tim5.dto.ClienDataDTO;
import com.Tim5.dto.LongBoolDTO;
import com.Tim5.model.Client;
import com.Tim5.model.User;
import com.Tim5.service.ClientService;
import com.Tim5.service.UserService;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/client")
public class ClientController {

    @Autowired
    private ClientService clientService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private UserService userService;


    @RequestMapping(value = "/{id}/blocked/1", method = RequestMethod.PUT)
    public ResponseEntity<?> blockUser(@RequestBody LongBoolDTO longBoolDTO){
        clientService.blockUser(longBoolDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping( method = RequestMethod.GET)
    public ResponseEntity<List<Client>> getAllClients(){
        return ResponseEntity.ok(clientService.getAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Client> getClient(@PathVariable("id") Long id){

        Client client = clientService.findByID(id);
        if(client == null)
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        return ResponseEntity.ok(client);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody Client client){
        if(client != null) {
            Client client1 = clientService.findByID(id);
            client1.setFirstName(client.getFirstName());
            client1.setAdress(client.getAdress());
            client1.setLastName(client.getLastName());
            Client c = clientService.save(client1);
            if(c != null)
                return new ResponseEntity<Client>(c,HttpStatus.OK);
            else
                return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

}

package com.xmlboys.controller;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;

@RestController
@CrossOrigin
@RequestMapping(value = "/adminClient")
public class ClientController {

    @GetMapping
    public void getUsers(HttpServletResponse httpServletResponse){
        httpServletResponse.setHeader("Location", "gateway/adminUser/getAllClients");
        httpServletResponse.setStatus(302);
    }

}

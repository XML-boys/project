package com.xmlboys.controller;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;

@RestController
@CrossOrigin
@RequestMapping(value = "/adminClient")
public class ClientController {



    @PutMapping
    public void updateUser(HttpServletResponse httpServletResponse){
        httpServletResponse.setHeader("Location", "http://localhost:6969/adminUser");
        httpServletResponse.setStatus(302);
    }


}

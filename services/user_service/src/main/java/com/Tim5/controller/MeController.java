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
@RequestMapping(value = "/me")
public class MeController {

    @Autowired
    private ClientService clientService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private UserService userService;


    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<ClienDataDTO> myInfo (HttpServletRequest request){
        String requestTokenHeader = request.getHeader("Authorization");
        String username = null;
        if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
            String jwtToken = requestTokenHeader.substring(7);
            try {
                username = jwtTokenUtil.getUsernameFromToken(jwtToken);
            } catch (IllegalArgumentException e) {
                System.out.println("Unable to get JWT Token");
            } catch (ExpiredJwtException e) {
                System.out.println("JWT Token has expired");
            }
        } else {
            System.out.println("JWT Token does not begin with Bearer String");
        }
        if(username != null) {
            User user = userService.findUserByUsername(username);
            if(user != null ) {
                Client client = clientService.findByUserId(user.getId());
                if(client != null) {
                    ClienDataDTO dto = new ClienDataDTO();
                    dto.setId(client.getId());
                    dto.setUserId(user.getId());
                    dto.setFirstName(client.getFirstName());
                    dto.setLastName(client.getLastName());
                    dto.setAdress(client.getAdress());
                    dto.setEmail(user.getEmail());
                    return new ResponseEntity<>(dto, HttpStatus.OK);
                }
            }
        }

        return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
    }
}

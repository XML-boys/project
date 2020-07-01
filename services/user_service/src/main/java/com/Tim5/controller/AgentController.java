package com.Tim5.controller;

import com.Tim5.config.JwtTokenUtil;
import com.Tim5.dto.AdminDataDTO;
import com.Tim5.dto.AgentDataDTO;
import com.Tim5.dto.AgentRegisterDTO;
import com.Tim5.dto.UserDTO;
import com.Tim5.model.Admin;
import com.Tim5.model.Agent;
import com.Tim5.model.ROLE;
import com.Tim5.model.User;
import com.Tim5.service.AdminService;
import com.Tim5.service.AgentService;
import com.Tim5.service.UserService;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/agent")
public class AgentController {
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private UserService userService;
    @Autowired
    private AgentService agentService;


    @GetMapping()
    public ResponseEntity<List<Agent>> getAll ( ) {
        return ResponseEntity.ok(agentService.findAll());
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<Agent> getAgent (@PathVariable("id") Long id) {
        Agent agent = agentService.findById(id);
        if(agent != null)
            return ResponseEntity.ok(agent);
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/me/user/1", method = RequestMethod.GET)
    public ResponseEntity<AgentDataDTO> myInfo (HttpServletRequest request){
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
                Agent agent = agentService.findByUserId(user.getId());
                if(agent != null && user.getRole() == ROLE.Agent) {
                    AgentDataDTO dataDTO = new AgentDataDTO();
                    dataDTO.setId(agent.getId());
                    dataDTO.setUserId(user.getId());
                    dataDTO.setUsername(user.getUsername());
                    dataDTO.setEmail(user.getEmail());
                    dataDTO.setCompanyIdentifier(agent.getCompanyIdentifier());
                    dataDTO.setAdress(agent.getAdress());
                    dataDTO.setName(agent.getName());
                    return new ResponseEntity<AgentDataDTO>(dataDTO, HttpStatus.OK);
                }
            }
        }

        return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
    }

    @PostMapping(consumes = "application/json")
    public HttpStatus save(@RequestBody AgentRegisterDTO agentRegisterDTO){
        if(agentRegisterDTO != null){
            UserDTO userDTO = new UserDTO();
            userDTO.setUsername(agentRegisterDTO.getUsername());
            userDTO.setEmail(agentRegisterDTO.getEmail());
            userDTO.setPassword(agentRegisterDTO.getPassword());
            userDTO.setApproved(true);
            userDTO.setRole("Agent");
            User user = userService.save(userDTO);

            Agent agent = agentService.findByUserId(user.getId());
            agent.setIme(agentRegisterDTO.getName());
            agent.setCompanyIdentifier(agentRegisterDTO.getCompanyIdentifier());
            agent.setAdress(agentRegisterDTO.getAdress());
            Agent a = agentService.save(agent);
            if(a!= null && user != null){
                return HttpStatus.CREATED;
            }
        }
        return HttpStatus.NOT_IMPLEMENTED;
    }
}

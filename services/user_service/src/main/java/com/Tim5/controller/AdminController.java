package com.Tim5.controller;


import com.Tim5.config.JwtTokenUtil;
import com.Tim5.dto.AdminDataDTO;
import com.Tim5.dto.AdminRegisterDTO;
import com.Tim5.dto.ClienDataDTO;
import com.Tim5.model.Admin;
import com.Tim5.model.Client;
import com.Tim5.model.ROLE;
import com.Tim5.model.User;
import com.Tim5.service.AdminService;
import com.Tim5.service.UserService;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Role;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@RestController
@CrossOrigin
@RequestMapping(value = "/admin")
public class AdminController {
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private UserService userService;
    @Autowired
    private AdminService adminService;



    @PostMapping(consumes = "application/json")
    public HttpStatus save(@RequestBody AdminRegisterDTO dto) {
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setRole(ROLE.ADMIN);
        user.setApproved(true);
        user.setPassword(dto.getPassword());

        User u = this.userService.save(user);

        Admin admin = new Admin();
        admin.setUserId(u.getId());
        admin.setIme(dto.getFirstName());
        admin.setPrezime(dto.getLastName());

        this.adminService.save(admin);

        if(u!= null && admin != null)
            return HttpStatus.OK;
        return HttpStatus.NOT_IMPLEMENTED;
    }

    @RequestMapping(value = "/me/user/1", method = RequestMethod.GET)
    public ResponseEntity<AdminDataDTO> myInfo (HttpServletRequest request){
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
                Admin admin = adminService.findByUserId(user.getId());
                if(admin != null && user.getRole() == ROLE.ADMIN) {
                    AdminDataDTO dataDTO = new AdminDataDTO();
                    dataDTO.setId(admin.getId());
                    dataDTO.setUserId(user.getId());
                    dataDTO.setEmail(user.getEmail());
                    dataDTO.setUsername(user.getUsername());
                    dataDTO.setFirstName(admin.getIme());
                    dataDTO.setLastName(admin.getPrezime());
                    return new ResponseEntity<AdminDataDTO>(dataDTO, HttpStatus.OK);
                }
            }
        }

        return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody Admin admin){
        if(admin != null) {
            Admin admin1 = adminService.findById(id);
            admin1.setIme(admin.getIme());
            admin1.setPrezime(admin.getPrezime());
            Admin a = adminService.save(admin1);
            if(a != null)
                return new ResponseEntity<Admin>(a,HttpStatus.OK);
            else
                return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

}

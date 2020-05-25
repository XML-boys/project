package org.psw_isa.psw_isa_backend.service;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import javax.servlet.http.HttpSession;

import org.psw_isa.psw_isa_backend.models.User;

@RestController
public class MeService {

    @GetMapping("/me")
    public User greeting() {
        // get session 
	ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes(); 
    	HttpSession session = attr.getRequest().getSession(true); 
	return (User) session.getAttribute("user");
    }
}

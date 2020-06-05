package com.Tim5.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import com.Tim5.dao.AgentRepository;
import com.Tim5.dao.ClientRepository;
import com.Tim5.dao.UserDao;
import com.Tim5.dto.UserDTO;
import com.Tim5.model.Agent;
import com.Tim5.model.Client;
import com.Tim5.model.ROLE;
import com.Tim5.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.Tim5.dao.UserDao;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private AgentRepository agentRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>(); // use list if you wish
            grantedAuthorities.add(new SimpleGrantedAuthority(user.getRole().name()));

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                grantedAuthorities);
    }

    public User save(UserDTO user) {
        User newUser = new User();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
        newUser.setRole(user.getRole());

        User savedUser = userDao.save(newUser);
        if(newUser.getRole() == ROLE.Agent){
            Agent agent = new Agent(savedUser.getId());
            agentRepository.save(agent);
        }else if(newUser.getRole() == ROLE.Client)
        {
            Client client = new Client(savedUser.getId());
            clientRepository.save(client);
        }

        return savedUser;
    }
}

package com.service;

import com.model.UserDTO;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestService {

    private final RestTemplate restTemplate;

    public RestService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public UserDTO getUser() {
        String url = "http://localhost:6969/auth";
        return this.restTemplate.getForObject(url, UserDTO.class);
    }

    public Long getId() {
        String url = "http://localhost:6969/auth";
        return this.restTemplate.getForObject(url, Long.class);
    }
}


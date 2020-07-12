package com.service;

import com.model.*;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestService {

    private final RestTemplate restTemplate;

    public RestService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    private HttpHeaders setHeader(String jwt) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer "+jwt);
        return headers;
    }

    public UserValidateDTO getUserValidate(String jwt) {
        String url = "http://localhost:6969/auth";
        HttpEntity request = new HttpEntity(setHeader(jwt));
        ResponseEntity<UserValidateDTO> response = this.restTemplate.exchange(url, HttpMethod.GET, request,
                UserValidateDTO.class);

        return response.getBody();
    }

    public AgentDataDTO getAgent(String jwt) {
        String url = "http://localhost:6969/agent/me/user/1";
        HttpEntity request = new HttpEntity(setHeader(jwt));
        ResponseEntity<AgentDataDTO> response = this.restTemplate.exchange(url, HttpMethod.GET, request,
                AgentDataDTO.class);

        return response.getBody();
    }
}

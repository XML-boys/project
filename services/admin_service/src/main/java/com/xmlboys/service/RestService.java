package com.xmlboys.service;

import com.xmlboys.dto.UserDTO;
import com.xmlboys.dto.UserValidateDTO;
import org.assertj.core.util.Lists;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

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
        String url = "http://gateway:80/auth";
        HttpEntity request = new HttpEntity(setHeader(jwt));
        ResponseEntity<UserValidateDTO> response = this.restTemplate.exchange(url, HttpMethod.GET, request,
                UserValidateDTO.class);

    return response.getBody();
    }

    public List<UserDTO> getUsers(String jwt) {
        String url = "http://gateway:80/auth";
        HttpEntity request = new HttpEntity(setHeader(jwt));
        ResponseEntity<UserDTO[]> response = this.restTemplate.exchange(url, HttpMethod.GET, request,
                UserDTO[].class);

        return Lists.newArrayList(response.getBody());
    }
}

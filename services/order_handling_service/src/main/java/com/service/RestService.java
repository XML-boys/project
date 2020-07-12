package com.service;

import ch.qos.logback.core.net.server.Client;
import com.model.*;
import org.apache.catalina.User;
import org.assertj.core.util.Lists;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
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

    public AgentDataDTO getAgent(String jwt) {
        String url = "http://gateway:80/agent/me/user/1";
        HttpEntity request = new HttpEntity(setHeader(jwt));
        ResponseEntity<AgentDataDTO> response = this.restTemplate.exchange(url, HttpMethod.GET, request,
                AgentDataDTO.class);

        return response.getBody();
    }

    public ClientDataDTO getClient(String jwt) {
        String url = "http://gateway:80/me";
        HttpEntity request = new HttpEntity(setHeader(jwt));
        ResponseEntity<ClientDataDTO> response = this.restTemplate.exchange(url, HttpMethod.GET, request,
                ClientDataDTO.class);

        return response.getBody();
    }

    public UserDTO getClientByUserId(Long id , String jwt) {
        String url = "http://gateway:80/mail/" + id;
        HttpEntity request = new HttpEntity(setHeader(jwt));
        ResponseEntity<UserDTO> response = this.restTemplate.exchange(url, HttpMethod.GET, request,
                UserDTO.class);

        return response.getBody();
    }

    public Long postConversation(String jwt, MessageDataDTO messageDataDTO) {
        String url = "http://gateway:80/conversation";
        HttpEntity<MessageDataDTO> request = new HttpEntity<>(messageDataDTO);
        ResponseEntity<Long> response = this.restTemplate.exchange(url, HttpMethod.POST, request,
                Long.class);

        return response.getBody();
    }

    public List<VehicleDataDTO> getVehicles(String jwt) {
        String url = "http://gateway:80/vehicles/";
        HttpEntity request = new HttpEntity(setHeader(jwt));
        ResponseEntity<VehicleDataDTO[]> response = this.restTemplate.exchange(url, HttpMethod.GET, request,
                VehicleDataDTO[].class);

        return Lists.newArrayList(response.getBody());
    }

    public List<UserDTO> getUsers(String jwt) {
        String url = "http://gateway:80/";
        HttpEntity request = new HttpEntity(setHeader(jwt));
        ResponseEntity<UserDTO[]> response = this.restTemplate.exchange(url, HttpMethod.GET, request,
                UserDTO[].class);

        return Lists.newArrayList(response.getBody());
    }
}

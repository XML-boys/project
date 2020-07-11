package com.controller;

import com.model.*;
import com.service.AdService;
import com.service.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin
@RequestMapping(value = "/agent-app/ad")
public class AdController {

    @Autowired
    private AdService adService;



    @PostMapping(consumes = "application/json")
    public ResponseEntity<Void> saveAd(@RequestBody AdDTO adDTO, HttpServletRequest httpServletRequest)  {
        String requestTokenHeader = httpServletRequest.getHeader("Authorization");
        String jwt = requestTokenHeader.substring(7);
        RestService restService = new RestService(new RestTemplateBuilder());
        UserValidateDTO userValidateDTO = restService.getUserValidate(jwt);
        AgentDataDTO agentDataDTO = restService.getAgent(jwt);
        if(userValidateDTO.getRole().equals("Agent")){
            Ad ad = new Ad();
            ad.setStartTime(adDTO.getStartTime());
            ad.setEndDate(adDTO.getEndDate());
            ad.setIdAgenta(agentDataDTO.getId());
            ad.setLocation(adDTO.getLocation());
            ad.setVehicleId(adDTO.getVehicleId());
            //   ad.setPictures(adDTO.getPictures());
            ad.setCena(adDTO.getCena());
            ad.setDamage(adDTO.isDamage());

            adService.save(ad);

            return new ResponseEntity<>(HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(HttpStatus.OK);
        }

    }

}

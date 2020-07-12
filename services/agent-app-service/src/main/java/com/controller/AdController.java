package com.controller;

import com.model.*;
import com.service.AdService;
import com.service.RestService;
import com.soap.AdClient;
import com.xml.RentACar.wsdl.AdResponse;
import com.xml.RentACar.wsdl.GetAdsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/agent-app/ad")
public class AdController {

    @Autowired
    private AdService adService;
    @Autowired
    private AdClient adClient;



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
            ad.setIdAgenta(agentDataDTO.getUserId());
            ad.setLocation(adDTO.getLocation());
            ad.setVehicleId(adDTO.getVehicleId());
            //   ad.setPictures(adDTO.getPictures());
            ad.setCena(adDTO.getCena());
            ad.setDamage(adDTO.isDamage());

            try {

                AdResponse response = adClient.adResponse(ad);
                ad.setRealId(response.getAdId());

                adService.save(ad);
                return new ResponseEntity<>(HttpStatus.CREATED);
            } catch (Exception e) {
                e.printStackTrace();
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }


        }else{
            return new ResponseEntity<>(HttpStatus.OK);
        }

    }


    @GetMapping(value = "/{idAgenta}")
    public ResponseEntity<List<Ad>> getAll(@PathVariable("idAgenta") Long idAgenta) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            GetAdsResponse adsFromMicroservices =  this.adClient.getAgentAds(idAgenta);

            for(com.xml.RentACar.wsdl.Ad tmp : adsFromMicroservices.getAd()){
                if(this.adService.findByRealId(tmp.getId()) == null) {
                    Ad ad = new Ad();
                    ad.setRealId(tmp.getId());
                    ad.setVehicleId(tmp.getVehicleId());
                    ad.setIdAgenta(tmp.getIdAgenta());
                    ad.setCena(tmp.getCena());
                    ad.setDamage(tmp.isDamage());
                    ad.setLocation(tmp.getLocation());
                    ad.setStartTime(LocalDate.parse(tmp.getStartTime(), formatter));
                    ad.setEndDate(LocalDate.parse(tmp.getStartTime(), formatter));

                    this.adService.save(ad);
                }
            }


            List<Ad> advertisementDtos = this.adService.findAdsByAgentId(idAgenta);


            return new ResponseEntity<>(advertisementDtos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}

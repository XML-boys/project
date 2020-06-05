package com.controller;

import com.model.ADLSDDTO;
import com.model.Ad;
import com.model.AdDTO;
import com.model.AdLocationDTO;
import com.repository.AdRepository;
import com.service.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/ad")
public class AdController {

    @Autowired
    private AdService adService;

    @PostMapping(path = "/saveAd", consumes = "application/json")
    public ResponseEntity<Void> saveOrder(@RequestBody AdDTO adDTO)  {
        Ad ad = new Ad();
        ad.setStartTime(adDTO.getStartTime());
        ad.setEndDate(adDTO.getEndTime());
        ad.setIdAgenta(adDTO.getIdAgenta());
        ad.setLocation(adDTO.getLocation());
        ad.setVehicleId(adDTO.getVehicleId());
        ad.setPictures(adDTO.getPictures());
        ad.setCena(adDTO.getCena());
        ad.setDamage(adDTO.isDamage());

        adService.save(ad);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(path = "/allAds", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AdDTO>> getAds() {
        List<Ad> ads = adService.findAllAds();
        List<AdDTO> adDTOS= new ArrayList<>();
        if(ads != null)
        {
            for(Ad a : ads)
            {
                adDTOS.add(new AdDTO(a));
            }
        }
        return new ResponseEntity<>(adDTOS, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        adService.remove(id);
        return new ResponseEntity<>((HttpStatus.OK));
    }

    @GetMapping(path = "/allLocations",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AdLocationDTO>> getallLocations(){
        List<Ad> ads = adService.findAllAds();
        List<AdLocationDTO> adLocationDTOS= new ArrayList<>();
        if(ads != null)
        {
            for(Ad a : ads)
            {
                adLocationDTOS.add(new AdLocationDTO(a));
            }
        }
        return new ResponseEntity<>(adLocationDTOS, HttpStatus.OK);

    }

    @PostMapping(path = "/allReqAds", consumes = "application/json")
    public ResponseEntity<List<AdDTO>> getAdz(@RequestBody ADLSDDTO adlsddto) {
        List<Ad> ads = adService.findAllAds();
        List<AdDTO> adDTOS = new ArrayList<>();
        if(ads != null){
            for(Ad a : ads){
                if(a.getLocation().equals(adlsddto.getLocation()) && a.getStartTime().isAfter(adlsddto.getStartTime()) && a.getEndDate().isBefore(adlsddto.getEndDate())){
                    adDTOS.add(new AdDTO(a));
                }
            }
        }
        return new ResponseEntity<>(adDTOS, HttpStatus.OK);
    }

    @GetMapping(path = "/allLocations/reqAd/{id}/",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AdDTO> getOneAd(@PathVariable Long id){
        List<Ad> ads = adService.findAllAds();
        AdDTO adDTO = new AdDTO();
        for(Ad a : ads){
            if(a.getId() == id)
                new AdDTO(a);
        }
        return new ResponseEntity<>(adDTO, HttpStatus.OK);
    }



}

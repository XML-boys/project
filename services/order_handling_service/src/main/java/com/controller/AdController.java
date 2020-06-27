package com.controller;

import com.model.Ad;
import com.model.AdDTO;
import com.service.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/ad")
public class AdController {

    @Autowired
    private AdService adService;



    @PostMapping(consumes = "application/json")
    public ResponseEntity<Void> saveAd(@RequestBody AdDTO adDTO)  {
        Ad ad = new Ad();
        ad.setStartTime(adDTO.getStartTime());
        ad.setEndDate(adDTO.getEndDate());
        ad.setIdAgenta(adDTO.getIdAgenta());
        ad.setLocation(adDTO.getLocation());
        ad.setVehicleId(adDTO.getVehicleId());
     //   ad.setPictures(adDTO.getPictures());
        ad.setCena(adDTO.getCena());
        ad.setDamage(adDTO.isDamage());

        adService.save(ad);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<AdDTO>> getAds() {
        List<Ad> ads = adService.findAllAds();
        List<AdDTO> adDTOS= new ArrayList<>();
        if(ads != null)
        {
            for(Ad a : ads)
            {
                adDTOS.add(new AdDTO(a));
                return new ResponseEntity<>(adDTOS, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(adDTOS, HttpStatus.NOT_IMPLEMENTED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteAd(@PathVariable Long id) {
        adService.remove(id);
        return new ResponseEntity<>((HttpStatus.OK));
    }


    @PutMapping(value = "/{id}", consumes = "application/json")
    public ResponseEntity<Void> putAd(@RequestBody AdDTO adDTO, @PathVariable Long id)  {
        List<Ad> ads = adService.findAllAds();
        if(ads != null){
            for(Ad ad : ads)
            {
                if(ad.getId() == id)
                {
                    ad.setStartTime(adDTO.getStartTime());
                    ad.setEndDate(adDTO.getEndDate());
                    ad.setIdAgenta(adDTO.getIdAgenta());
                    ad.setLocation(adDTO.getLocation());
                    ad.setVehicleId(adDTO.getVehicleId());
                    ad.setPictures(adDTO.getPictures());
                    ad.setCena(adDTO.getCena());
                    ad.setDamage(adDTO.isDamage());
                    adService.save(ad);
                }
            }
        }


        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Ad> getAd(@PathVariable Long id) {
        List<Ad> ads = adService.findAllAds();
        if(ads != null)
        {
            for(Ad a : ads)
            {
                if(a.getId() == id){
                    return new ResponseEntity<>(a, HttpStatus.OK);
                }
            }
        }
        return new ResponseEntity<>( HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/{id}/location",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getLocations(@PathVariable Long id){
        List<Ad> ads = adService.findAllAds();
        if(ads != null)
        {
            for(Ad a : ads)
            {
                if(a.getId() == id){
                    return new ResponseEntity<>(a.getLocation(),HttpStatus.NOT_FOUND);
                }
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @PutMapping(value = "/{id}/location",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> putLocations(@RequestBody String location,@PathVariable Long id){
        List<Ad> ads = adService.findAllAds();
        if(ads != null)
        {
            for(Ad a : ads)
            {
                if(a.getId() == id){
                    a.setLocation(location);
                    adService.save(a);
                    return new ResponseEntity<>(HttpStatus.OK);
                }
            }
        }
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @GetMapping(value = "/{idAgenta}/agent", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Ad>> getAdzAgent(@PathVariable("idAgenta") Long idAgenta) {
        List<Ad> ads = adService.findAllAds();
        List<Ad> returnAds = new ArrayList<>();
        if(ads != null) {
            for(Ad ad : ads){
                if(ad.getIdAgenta() == idAgenta){
                    returnAds.add(ad);
                }
            }
            return new ResponseEntity<>(returnAds,HttpStatus.OK);
        } else
        {
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
    }


    /*@PostMapping(path = "/allReqAds", consumes = "application/json")
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
    }*/

    /*@GetMapping(path = "/allLocations/reqAd/{id}/",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AdDTO> getOneAd(@PathVariable Long id){
        List<Ad> ads = adService.findAllAds();
        AdDTO adDTO = new AdDTO();
        for(Ad a : ads){
            if(a.getId() == id)
                new AdDTO(a);
        }
        return new ResponseEntity<>(adDTO, HttpStatus.OK);
    }*/





}

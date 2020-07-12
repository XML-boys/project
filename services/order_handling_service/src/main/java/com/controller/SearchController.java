package com.controller;

import com.model.*;
import com.service.AdService;
import com.service.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/search")
public class SearchController {

    @Autowired
    private AdService adService;

    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<List<Ad>> getReq(@RequestBody AdDTOSearch adDTOSearch) {
        List<Ad> ads = adService.findAllAds();
        List<Ad> returnAds = new ArrayList<>();

        if (ads != null) {
            for (Ad ad : ads) {
                if (ad.getLocation() == adDTOSearch.getLocation() && ad.getStartTime().isAfter(adDTOSearch.getStartTime()) && ad.getEndDate().isBefore(adDTOSearch.getEndDate())) {
                    returnAds.add(ad);
                }
            }
            return new ResponseEntity<>(returnAds, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }

    }
}
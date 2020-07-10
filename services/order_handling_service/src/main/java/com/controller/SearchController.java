package com.controller;

import com.model.Ad;
import com.model.AgentDataDTO;
import com.model.UserValidateDTO;
import com.model.VehicleDataDTO;
import com.service.AdService;
import com.service.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/search")
public class SearchController {

    @Autowired
    private AdService adService;

    @GetMapping(value = "/{location}/{startDate}/{endDate}", produces = "application/json")
    public ResponseEntity<List<Ad>> getReq(@PathVariable("location") String location, @PathVariable("startDate") LocalDate startDate, @PathVariable("endDate") LocalDate endDate) {
        List<Ad> ads = adService.findAllAds();
        List<Ad> returnAds = new ArrayList<>();

        if (ads != null) {
            for (Ad ad : ads) {
                if (ad.getLocation() == location && ad.getStartTime().isAfter(startDate) && ad.getEndDate().isBefore(endDate)) {
                    returnAds.add(ad);
                }
            }
            return new ResponseEntity<>(returnAds, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }

    }
}
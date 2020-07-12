package com.xmlboys.controller;

import com.xmlboys.dto.UserValidateDTO;
import com.xmlboys.model.CodeItem;
import com.xmlboys.model.Discount;
import com.xmlboys.service.DiscountService;
import com.xmlboys.service.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/discount")
public class DiscountController {

    @Autowired
    DiscountService service;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Discount discount, HttpServletRequest httpServletRequest) {
        if (discount != null) {
        String requestTokenHeader = httpServletRequest.getHeader("Authorization");
        String jwt = requestTokenHeader.substring(7);
        RestService restService = new RestService(new RestTemplateBuilder());
        UserValidateDTO userValidateDTO = restService.getUserValidate(jwt);
        discount.setAgentUsername(userValidateDTO.getUsername());

            service.save(discount);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);


    }

    @GetMapping
    public ResponseEntity<List<Discount>> get(HttpServletRequest httpServletRequest) {
        String requestTokenHeader = httpServletRequest.getHeader("Authorization");
        String jwt = requestTokenHeader.substring(7);
        RestService restService = new RestService(new RestTemplateBuilder());
        UserValidateDTO userValidateDTO = restService.getUserValidate(jwt);


        List<Discount> discounts = service.findAll();
        List<Discount> retVal = new ArrayList<>();
        for(Discount d : discounts){
            if (d.getAgentUsername().equals(userValidateDTO.getUsername())) {
                retVal.add(d);
            }
        }
        return new ResponseEntity<>(retVal, HttpStatus.OK);


    }

    @DeleteMapping(value = "/{id}")
    public HttpStatus get(@PathVariable ("id") Long id) {
        service.delete(id);
        return HttpStatus.OK;
    }
}

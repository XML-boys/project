package com.Tim5.controller;

import com.Tim5.dto.SearchVehicleMinDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@CrossOrigin
public class SearchVehicle {



    @RequestMapping(value = "/searchVehicleMin", method = RequestMethod.POST)
    public void minimalSearch(HttpServletResponse httpServletResponse, @RequestBody SearchVehicleMinDTO searchVehicleMinDTO) throws Exception {
        httpServletResponse.setHeader("Location", "");
        httpServletResponse.setStatus(302);

    }
}

package com.soap;


import com.model.Ad;
import com.service.AdService;
import org.assertj.core.util.Lists;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;


import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import javax.transaction.Transactional;
import localhost._6969.order_handling_service_schema.AdRequest;
import localhost._6969.order_handling_service_schema.AdResponse;
import localhost._6969.order_handling_service_schema.GetAdsRequest;
import localhost._6969.order_handling_service_schema.GetAdsResponse;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.io.*;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Endpoint
@Transactional
public class OrderHandlingEndPoint {

    @Autowired
    private AdService adService;

    private static ModelMapper modelMapper = new ModelMapper();

    private static final String NAMESPACE_URI = "http://localhost:6969/order-handling-service-schema";


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "AdRequest")
    @ResponsePayload
    public AdResponse newAdvertisement(@RequestPayload AdRequest adRequest) {
        System.out.println("ULAZI U SOAP KREIRANJE OGLASA");

        AdResponse adResponse = new AdResponse();
        System.out.println("prvi");

        Ad ad = new Ad();


        //ad.setId(adRequest.getId());
        System.out.println("Id reklame:" + adRequest.getId());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");


        ad.setLocation(adRequest.getLocation());
        ad.setCena(adRequest.getCena());
        ad.setDamage(adRequest.isDamage());
        ad.setStartTime(LocalDate.parse(adRequest.getStartTime(), formatter));
        ad.setEndDate(LocalDate.parse(adRequest.getEndDate(), formatter));
        ad.setIdAgenta(adRequest.getIdAgenta());
        ad.setVehicleId(adRequest.getVehicleId());
        ad.setPictures(Lists.newArrayList(adRequest.getPictures()));


        Ad advertisement = adService.save(ad);
        adResponse.setAdId(advertisement.getId());

        return adResponse;
    }


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAdsRequest")
    @ResponsePayload
    public GetAdsResponse getAdvertisements(@RequestPayload GetAdsRequest request) throws ParseException, IOException {
        System.out.println("SOAP - Get Advertisements");

        GetAdsResponse getAdvertisementsResponse = new GetAdsResponse();
        List<Ad> ads = new ArrayList<>();
        try {
            ads = this.adService.findAdsByAgentId(request.getAgentId());
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (Ad ad : ads) {
            localhost._6969.order_handling_service_schema.Ad advertisement = new localhost._6969.order_handling_service_schema.Ad();
            advertisement.setId(ad.getId());
            advertisement.setIdAgenta(ad.getIdAgenta());
            advertisement.setCena(ad.getCena());
            advertisement.setDamage(ad.isDamage());
            advertisement.setLocation(ad.getLocation());
            advertisement.setStartTime(ad.getStartTime().toString());
            advertisement.setEndDate(ad.getEndDate().toString());
            advertisement.setVehicleId(ad.getVehicleId());


            getAdvertisementsResponse.getAd().add(advertisement);
        }

        return getAdvertisementsResponse;

    }


}

package com.soap;

import com.model.Ad;
import com.service.AdService;
import com.xml.RentACar.wsdl.AdRequest;
import com.xml.RentACar.wsdl.AdResponse;
import com.xml.RentACar.wsdl.GetAdsRequest;
import com.xml.RentACar.wsdl.GetAdsResponse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import java.io.IOException;


public class AdClient extends WebServiceGatewaySupport {

    @Autowired
    AdService advertisementService;


    public AdResponse adResponse(Ad ad){

        AdRequest adRequest = new AdRequest();
        adRequest.setId(1L);

        adRequest.setVehicleId(ad.getVehicleId());
        adRequest.setIdAgenta(ad.getIdAgenta());
        adRequest.setCena(ad.getCena());
        adRequest.setDamage(ad.getDamage());
        adRequest.setStartTime(ad.getStartTime().toString());
        adRequest.setEndDate(ad.getEndDate().toString());
        adRequest.setLocation(ad.getLocation());

        System.out.println("Saljem novi ad soap: " + adRequest.getId());

        AdResponse response = (AdResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:6969/ws/order-handling-service-schema", adRequest,
                        new SoapActionCallback("http://localhost:6969/ws/order-handling-service-schema/AdRequest"));

        return response;

    }

    public GetAdsResponse getAgentAds(Long id) throws IOException {

        GetAdsRequest request = new GetAdsRequest();
        request.setAgentId(id);

        GetAdsResponse response = (GetAdsResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:6969/ws/order-handling-service-schema", request,
                        new SoapActionCallback("http://localhost:6969/ws/order-handling-service-schema/AdRequest"));

        return response;
    }
}

package com.soap;
import com.service.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
//import localhost._8085.order_handling_service_schema.AdRequest;
//import localhost._8085.order_handling_service_schema.AdResponse;

import java.text.ParseException;

@Endpoint
public class OrderHandlingEndPoint {
    private static final String NAMESPACE_URI = "http://localhost:6969/order-handling-service-schema";

    @Autowired
    private AdService adService;

   /* @PayloadRoot(namespace = NAMESPACE_URI, localPart = "AdRequest")
    @ResponsePayload
    public AdResponse createAd(@RequestPayload AdRequest request) throws ParseException {}*/
}

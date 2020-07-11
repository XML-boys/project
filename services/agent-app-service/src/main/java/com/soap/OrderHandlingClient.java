package com.soap;

import com.service.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class OrderHandlingClient extends WebServiceGatewaySupport {
    @Autowired
    private AdService adService;
}

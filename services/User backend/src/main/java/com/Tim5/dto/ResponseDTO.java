package com.Tim5.dto;

import java.io.Serializable;

public class ResponseDTO implements Serializable {
    private final String jwttoken;


    public ResponseDTO(String jwttoken) {
        this.jwttoken = jwttoken;
    }

    public String getJwttoken() {
        return jwttoken;
    }
}

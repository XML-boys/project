package com.model;

public class AdLocationDTO {
    private String location;

    public AdLocationDTO(String location) {
        this.location = location;
    }

    public AdLocationDTO(Ad ad) {
        this.location = ad.getLocation();
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}

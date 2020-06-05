package com.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class AdDTO {
    private Long idAgenta;
    private LocalDate startTime;
    private LocalDate endTime;
    private String location;
    private Long vehicleId;
    private ArrayList<String> pictures;
    private String cena;
    private boolean damage;

    public AdDTO() {
    }

    public AdDTO(Long idAgenta, LocalDate startTime, LocalDate endTime, String location, Long vehicleId, ArrayList<String> pictures) {
        this.idAgenta = idAgenta;
        this.startTime = startTime;
        this.endTime = endTime;
        this.location = location;
        this.vehicleId = vehicleId;
        this.pictures = pictures;
    }

    public AdDTO(Ad ad) {
        this.startTime = ad.getStartTime();
        this.endTime = ad.getEndDate();
        this.location = ad.getLocation();
        this.idAgenta = ad.getIdAgenta();
        this.vehicleId = ad.getVehicleId();
        this.pictures = ad.getPictures();
        this.cena = ad.getCena();
        this.damage = ad.isDamage();
    }

    public Long getIdAgenta() {
        return idAgenta;
    }

    public void setIdAgenta(Long idAgenta) {
        this.idAgenta = idAgenta;
    }

    public LocalDate getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDate startTime) {
        this.startTime = startTime;
    }

    public LocalDate getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDate endTime) {
        this.endTime = endTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public ArrayList<String> getPictures() {
        return pictures;
    }

    public void setPictures(ArrayList<String> pictures) {
        this.pictures = pictures;
    }

    public String getCena() {
        return cena;
    }

    public void setCena(String cena) {
        this.cena = cena;
    }

    public boolean isDamage() {
        return damage;
    }

    public void setDamage(boolean damage) {
        this.damage = damage;
    }
}

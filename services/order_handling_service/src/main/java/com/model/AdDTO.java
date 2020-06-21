package com.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Set;

public class AdDTO {
    private Long id;
    private Long idAgenta;
    private LocalDate startTime;
    private LocalDate endDate;
    private String location;
    private Long vehicleId;
    private ArrayList<String> pictures;
    private String cena;
    private Boolean damage;
    private Set<Reservation> ads;
    private Set<Comment> comments;

    public AdDTO() {
    }

    public AdDTO(Long idAgenta, LocalDate startTime, LocalDate endTime, String location, Long vehicleId, ArrayList<String> pictures) {
        this.idAgenta = idAgenta;
        this.startTime = startTime;
        this.endDate = endTime;
        this.location = location;
        this.vehicleId = vehicleId;
        this.pictures = pictures;
    }

    public AdDTO(Long id, Long idAgenta, LocalDate startTime, LocalDate endDate, String location, Long vehicleId, ArrayList<String> pictures, String cena, Boolean damage, Set<Reservation> ads, Set<Comment> comments) {
        this.id = id;
        this.idAgenta = idAgenta;
        this.startTime = startTime;
        this.endDate = endDate;
        this.location = location;
        this.vehicleId = vehicleId;
        this.pictures = pictures;
        this.cena = cena;
        this.damage = damage;
        this.ads = ads;
        this.comments = comments;
    }

    public AdDTO(Ad ad) {
        this.id = ad.getId();
        this.startTime = ad.getStartTime();
        this.endDate = ad.getEndDate();
        this.location = ad.getLocation();
        this.idAgenta = ad.getIdAgenta();
        this.vehicleId = ad.getVehicleId();
        this.pictures = ad.getPictures();
        this.cena = ad.getCena();
        this.damage = ad.isDamage();
        this.ads = ad.getAds();
        this.comments = ad.getComments();
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

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endTime) {
        this.endDate = endTime;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

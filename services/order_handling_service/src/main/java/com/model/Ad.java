package com.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Set;

@Entity
public class Ad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private Long idAgenta;
    @Column
    private LocalDate startTime;
    @Column
    private LocalDate endDate;
    @Column
    private ArrayList<String> pictures;
    @Column
    private Long vehicleId;
    @Column
    private String location;
    @Column
    private String cena;
    @Column
    private Boolean damage;

    @OneToMany(mappedBy = "reklama", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Reservation> ads;

    @OneToMany(mappedBy = "reklamak", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Comment> comments;

    public Ad() {
    }

    public Ad(Long idAgenta, LocalDate startTime, LocalDate endDate, ArrayList<String> pictures, Long vehicleId, String location, String cena, boolean damage, Set<Reservation> ads) {
        this.idAgenta = idAgenta;
        this.startTime = startTime;
        this.endDate = endDate;
        this.pictures = pictures;
        this.vehicleId = vehicleId;
        this.location = location;
        this.cena = cena;
        this.damage = damage;
        this.ads = ads;
    }

    public Ad(Long id, Long idAgenta, LocalDate startTime, LocalDate endDate, ArrayList<String> pictures, Long vehicleId, String location, String cena, Boolean damage, Set<Reservation> ads, Set<Comment> comments) {
        this.id = id;
        this.idAgenta = idAgenta;
        this.startTime = startTime;
        this.endDate = endDate;
        this.pictures = pictures;
        this.vehicleId = vehicleId;
        this.location = location;
        this.cena = cena;
        this.damage = damage;
        this.ads = ads;
        this.comments = comments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public ArrayList<String> getPictures() {
        return pictures;
    }

    public void setPictures(ArrayList<String> pictures) {
        this.pictures = pictures;
    }

    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCena() {
        return cena;
    }

    public void setCena(String cena) {
        this.cena = cena;
    }

    public Boolean isDamage() {
        return damage;
    }

    public void setDamage(Boolean damage) {
        this.damage = damage;
    }

    public Boolean getDamage() {
        return damage;
    }

    public Set<Reservation> getAds() {
        return ads;
    }

    public void setAds(Set<Reservation> ads) {
        this.ads = ads;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }
}

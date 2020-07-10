package com.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Set;

public class AdFullDTO {
    private Long id;
    private Long idAgenta;
    private LocalDate startTime;
    private LocalDate endDate;
    private ArrayList<String> pictures;
    private Long vehicleId;
    private String location;
    private String cena;
    private Boolean damage;
    private Set<Reservation> reservations;
    private Set<Comment> comments;
    private Set<Vote> votes;

    public AdFullDTO() {
    }

    public AdFullDTO(Long id, Long idAgenta, LocalDate startTime, LocalDate endDate, ArrayList<String> pictures, Long vehicleId, String location, String cena, Boolean damage, Set<Reservation> reservations, Set<Comment> comments, Set<Vote> votes) {
        this.id = id;
        this.idAgenta = idAgenta;
        this.startTime = startTime;
        this.endDate = endDate;
        this.pictures = pictures;
        this.vehicleId = vehicleId;
        this.location = location;
        this.cena = cena;
        this.damage = damage;
        this.reservations = reservations;
        this.comments = comments;
        this.votes = votes;
    }

    public AdFullDTO(Ad ad) {
        this.id = ad.getId();
        this.idAgenta = ad.getIdAgenta();
        this.startTime = ad.getStartTime();
        this.endDate = ad.getEndDate();
        this.pictures = ad.getPictures();
        this.vehicleId = ad.getVehicleId();
        this.location = ad.getLocation();
        this.cena = ad.getCena();
        this.damage = ad.getDamage();
        this.reservations = ad.getReservations();
        this.comments = ad.getComments();
        this.votes = ad.getVotes();
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

    public Set<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(Set<Reservation> reservations) {
        this.reservations = reservations;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    public Set<Vote> getVotes() {
        return votes;
    }

    public void setVotes(Set<Vote> votes) {
        this.votes = votes;
    }
}

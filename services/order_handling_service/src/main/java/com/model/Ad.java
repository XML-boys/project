package com.model;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Set;

@Entity
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Ad", namespace = "http://localhost:6969/order-handling-service-schema")
@XmlRootElement(name = "AdClass")
public class Ad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlElement
    private Long id;
    @Column
    @XmlElement
    private Long idAgenta;
    @Column
    @XmlElement
    private LocalDate startTime;
    @Column
    @XmlElement
    private LocalDate endDate;
    @Column
    @XmlElement
    private ArrayList<String> pictures;
    @Column
    @XmlElement
    private Long vehicleId;
    @Column
    @XmlElement
    private String location;
    @Column
    @XmlElement
    private String cena;
    @Column
    @XmlElement
    private Boolean damage;

    @OneToMany(mappedBy = "reklama", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Reservation> reservations;

    @OneToMany(mappedBy = "reklamak", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Comment> comments;

    @OneToMany(mappedBy = "reklamaz", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Vote> votes;

    public Ad() {
    }

    public Ad(Long idAgenta, LocalDate startTime, LocalDate endDate, ArrayList<String> pictures, Long vehicleId, String location, String cena, boolean damage, Set<Reservation> reservations) {
        this.idAgenta = idAgenta;
        this.startTime = startTime;
        this.endDate = endDate;
        this.pictures = pictures;
        this.vehicleId = vehicleId;
        this.location = location;
        this.cena = cena;
        this.damage = damage;
        this.reservations = reservations;
    }

    public Ad(Long id, Long idAgenta, LocalDate startTime, LocalDate endDate, ArrayList<String> pictures, Long vehicleId, String location, String cena, Boolean damage, Set<Reservation> reservations, Set<Comment> comments) {
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

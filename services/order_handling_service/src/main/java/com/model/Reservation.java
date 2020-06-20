package com.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
//@Table(name = "Reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private Long userId;
    @Column
    private LocalDate startTime;
    @Column
    private LocalDate endTime;
    @Column
    private String state;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    //@JoinColumn(name = "reklama")
    private Ad reklama;

    public Reservation() {
    }

    public Reservation(Long userId, LocalDate startTime, LocalDate endTime, String state, Ad reklama) {
        this.userId = userId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.state = state;
        this.reklama = reklama;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Ad getReklama() {
        return reklama;
    }

    public void setReklama(Ad reklama) {
        this.reklama = reklama;
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}

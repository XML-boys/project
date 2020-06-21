package com.model;

import java.time.LocalDate;

public class ReservationDTO {
    private Long userId;
    private LocalDate startTime;
    private LocalDate endTime;
    private Ad reklama;


    public ReservationDTO(Long userId, LocalDate startTime, LocalDate endTime) {
        this.userId = userId;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public ReservationDTO(Reservation reservation) {
        this.userId = reservation.getUserId();
        this.startTime = reservation.getStartTime();
        this.endTime = reservation.getEndTime();
        this.reklama = reservation.getReklama();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public Ad getReklama() {
        return reklama;
    }

    public void setReklama(Ad reklama) {
        this.reklama = reklama;
    }
}

package com.model;

import java.time.LocalDate;

public class ReservationDTO {
    private Long userId;
    //private Ad ad;
    private LocalDate startTime;
    private LocalDate endTime;


    public ReservationDTO(Long userId, LocalDate startTime, LocalDate endTime) {
        this.userId = userId;
        //this.ad = ad;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public ReservationDTO(Reservation reservation) {
        this.userId = reservation.getUserId();
      //  this.ad = reservation.getReklama();
        this.startTime = reservation.getStartTime();
        this.endTime = reservation.getEndTime();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /*public Ad getAd() {
        return ad;
    }

    public void setAd(Ad ad) {
        this.ad = ad;
    }*/

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
}

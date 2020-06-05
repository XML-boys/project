package com.model;

import java.time.LocalDate;

public class ADLSDDTO {
    private LocalDate startTime;
    private LocalDate endDate;
    private String location;

    public ADLSDDTO() {
    }

    public ADLSDDTO(LocalDate startTime, LocalDate endDate, String location) {
        this.startTime = startTime;
        this.endDate = endDate;
        this.location = location;
    }

    public ADLSDDTO(Ad ad) {
        this.startTime = ad.getStartTime();
        this.endDate = ad.getEndDate();
        this.location = ad.getLocation();
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}

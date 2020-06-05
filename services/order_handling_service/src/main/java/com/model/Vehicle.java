package com.model;

import org.hibernate.annotations.Table;

import javax.persistence.*;


public class Vehicle {

    private Long vehicleId;

   /* @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "vehiclesIds")
    private Long vehicleId;*/
}

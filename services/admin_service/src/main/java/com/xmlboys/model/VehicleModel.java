package com.xmlboys.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
public class VehicleModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private ArrayList<String> gear;
    @Column
    private ArrayList<String> oil;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private CodeItem vendor;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getGear() {
        return gear;
    }

    public void setGear(ArrayList<String> gear) {
        this.gear = gear;
    }

    public ArrayList<String> getOil() {
        return oil;
    }

    public void setOil(ArrayList<String> oil) {
        this.oil = oil;
    }

    public CodeItem getVendor() {
        return vendor;
    }

    public void setVendor(CodeItem vendor) {
        this.vendor = vendor;
    }
}

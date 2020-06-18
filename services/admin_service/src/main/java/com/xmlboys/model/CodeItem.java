package com.xmlboys.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class CodeItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String vendor;
    @OneToMany(mappedBy = "vendor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<VehicleModel> models;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public List<VehicleModel> getModels() {
        return models;
    }

    public void setModels(List<VehicleModel> models) {
        this.models = models;
    }
}

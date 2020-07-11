package com.model;

public class VehicleDataDTO {
    private Long id;
    private String vendor;
    private Long agentId;
    private String model;
    private String oilType;
    private String gearType;
    private String vehicleClass;
    private Integer distanceKM;
    private Integer kidSeats;

    public VehicleDataDTO() {
    }

    public VehicleDataDTO(Long id, String vendor, Long agentId, String model, String oilType, String gearType, String vehicleClass, Integer distanceKM, Integer kidSeats) {
        this.id = id;
        this.vendor = vendor;
        this.agentId = agentId;
        this.model = model;
        this.oilType = oilType;
        this.gearType = gearType;
        this.vehicleClass = vehicleClass;
        this.distanceKM = distanceKM;
        this.kidSeats = kidSeats;
    }

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

    public Long getAgentId() {
        return agentId;
    }

    public void setAgentId(Long agentId) {
        this.agentId = agentId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getOilType() {
        return oilType;
    }

    public void setOilType(String oilType) {
        this.oilType = oilType;
    }

    public String getGearType() {
        return gearType;
    }

    public void setGearType(String gearType) {
        this.gearType = gearType;
    }

    public String getVehicleClass() {
        return vehicleClass;
    }

    public void setVehicleClass(String vehicleClass) {
        this.vehicleClass = vehicleClass;
    }

    public Integer getDistanceKM() {
        return distanceKM;
    }

    public void setDistanceKM(Integer distanceKM) {
        this.distanceKM = distanceKM;
    }

    public Integer getKidSeats() {
        return kidSeats;
    }

    public void setKidSeats(Integer kidSeats) {
        this.kidSeats = kidSeats;
    }
}

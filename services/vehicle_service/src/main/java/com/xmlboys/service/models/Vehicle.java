package com.xmlboyz.service.models;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.OneToMany;
import javax.persistence.ManyToMany;

@Entity
public class Vehicle {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    	private Long id;
	
	
	
    	
	private String vendor;
	
	
    	
	private String model;
	
	
    	
	private String oilType;
	
	
    	
	private String gearType;
	
	
    	
	private String vehicleClass;
	
	
    	
	private Integer distanceKM;
	
	
    	
	private Integer kidSeats;
	
	
	public Vehicle() 
	{
	}
	public Vehicle(String _vendor, String _model, String _oilType, String _gearType, String _vehicleClass, Integer _distanceKM, Integer _kidSeats, Long _id) {
		super();
		 
		this.vendor = _vendor;
		 
		this.model = _model;
		 
		this.oilType = _oilType;
		 
		this.gearType = _gearType;
		 
		this.vehicleClass = _vehicleClass;
		 
		this.distanceKM = _distanceKM;
		 
		this.kidSeats = _kidSeats;
		 
		this.id = _id;
		
	}
	
	
	public String getVendor() {
		return vendor;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
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
	

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
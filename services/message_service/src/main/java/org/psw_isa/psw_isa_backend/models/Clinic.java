package org.psw_isa.psw_isa_backend.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class Clinic implements java.io.Serializable {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

	private Double locationLat;
	
	private Double locationLon;
	
	private String name; 
	
	private String address; 
	
	private String description;	
	
	
	public Clinic() 
	{
	}
	public Clinic(Double locationLat,Double locationLon ,String _name, String _address, String description) {
		super();
		
		this.locationLat=locationLat;
		
		this.locationLon=locationLon;
		
		this.name = _name;
		 
		this.address = _address;
		 
		this.setDescription(description);
		
	}
	public void assign(Clinic other) {

		this.locationLat=other.getLocationLat();
		
		this.locationLon=other.getLocationLon();
		
		this.name = other.getName();
		 
		this.address = other.getAddress();
		 
		this.setDescription(other.getDescription());
	}
	
	 
	public String getName() 
	{
		return this.name;
	}

	public void setName(String newValue) 
	{
		this.name = newValue;
	}
	 
	public String getAddress() 
	{
		return this.address;
	}
	public void setId(Long newValue) 
	{
		this.id = newValue;
	}
	 
	public Long getId() 
	{
		return this.id;
	}

	public void setAddress(String newValue) 
	{
		this.address = newValue;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getLocationLat() {
		return locationLat;
	}
	public void setLocationLat(Double locationLat) {
		this.locationLat = locationLat;
	}
	public Double getLocationLon() {
		return locationLon;
	}
	public void setLocationLon(Double locationLon) {
		this.locationLon = locationLon;
	}
	
}

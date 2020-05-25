package org.psw_isa.psw_isa_backend.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.psw_isa.psw_isa_backend.models.*;
import java.time.*;


@Entity
public class Doctor implements java.io.Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
	
	@ManyToOne
    @JoinColumn
	private User user; 
	
	@ManyToOne
	@JoinColumn
	private CareType careType; 
	
	@ManyToOne
    @JoinColumn
    private Clinic clinic;
 
	

	private Integer yearsOfExperience; 
	

	public Doctor() 
	{
	}

	public Doctor(User _user, CareType careType, Integer _yearsOfExperience,Clinic clinic) {

		super();
		 
		this.user = _user;
		 
		this.careType = careType;
		 
		this.yearsOfExperience = _yearsOfExperience;

		this.clinic = clinic;
		
	}

	public Long getId() {
		return this.id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	 
	public Doctor(Long id, User user, CareType careType, Clinic clinic, Integer yearsOfExperience) {
		super();
		this.id = id;
		this.user = user;
		this.careType = careType;
		this.clinic = clinic;
		this.yearsOfExperience = yearsOfExperience;
	}
	
	public CareType getCareType() {
		return careType;
	}
	public void setCareType(CareType careType) {
		this.careType = careType;
	}

	public User getUser() 
	{
		return this.user;
	}

	public void setUser(User newValue) 
	{
		this.user = newValue;
	}
	 

	public Clinic getClinic() 
	{
		return this.clinic;
	}

	public void setClinic(Clinic newValue) 
	{
		this.clinic = newValue;
	}
	 

	public Integer getYearsOfExperience() 
	{
		return this.yearsOfExperience;
	}

	public void setYearsOfExperience(Integer newValue) 
	{
		this.yearsOfExperience = newValue;
	}
	
}

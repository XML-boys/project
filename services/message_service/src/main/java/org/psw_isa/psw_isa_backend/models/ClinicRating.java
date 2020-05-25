package org.psw_isa.psw_isa_backend.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import java.time.*;


@Entity
public class ClinicRating {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

	
	
	private Integer rating;
	
	@ManyToOne
    @JoinColumn
	private Clinic clinic; 
	
	
	@ManyToOne
    @JoinColumn
	private Patient patient; 
	

	public ClinicRating() 
	{
	}
	public ClinicRating(Integer rating, Clinic clinic, Patient patient) {
		super();
		 
		this.rating = rating;;
		 
		this.clinic = clinic;
		 
		this.patient = patient;
		
	}
	
	 
	public Integer getRating() 
	{
		return this.rating;
	}

	public void setRating(Integer newValue) 
	{
		this.rating = newValue;
	}
	 
	public Clinic getClinic() 
	{
		return this.clinic;
	}

	public void setClinic(Clinic newValue) 
	{
		this.clinic = newValue;
	}
	 
	public Patient getPatient() 
	{
		return this.patient;
	}

	public void setPatient(Patient newValue) 
	{
		this.patient = newValue;
	}
	
}

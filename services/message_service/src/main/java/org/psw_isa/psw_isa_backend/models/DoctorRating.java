package org.psw_isa.psw_isa_backend.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import java.time.*;


@Entity
public class DoctorRating {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

	
	
	private Integer rating;
	
	@ManyToOne
    @JoinColumn
	private Doctor doctor; 
	
	
	@ManyToOne
    @JoinColumn
	private Patient patient; 
	

	public DoctorRating() 
	{
	}
	public DoctorRating(Integer rating, Doctor doctor, Patient patient) {
		super();
		 
		this.rating = rating;;
		 
		this.doctor = doctor;
		 
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
	 
	public Doctor getDoctor() 
	{
		return this.doctor;
	}

	public void setDoctor(Doctor newValue) 
	{
		this.doctor = newValue;
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

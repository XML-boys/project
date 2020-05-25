package org.psw_isa.psw_isa_backend.dtos;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import java.time.*;


public class DoctorRatingDTO {
	
    private Long id;

	
	
	private Integer rating;
	
	private Long doctorId; 
	
	
	private Long patientId; 
	

	public DoctorRatingDTO() 
	{
	}
	public DoctorRatingDTO(Integer rating, Long doctorId, Long patientId) {
		super();
		 
		this.rating = rating;;
		 
		this.doctorId = doctorId;
		 
		this.patientId = patientId;
		
	}
	
	 
	public Integer getRating() 
	{
		return this.rating;
	}

	public void setRating(Integer newValue) 
	{
		this.rating = newValue;
	}
	 
	public Long getDoctorId() 
	{
		return this.doctorId;
	}

	public void setDoctorId(Long newValue) 
	{
		this.doctorId = newValue;
	}
	 
	public Long getPatientId() 
	{
		return this.patientId;
	}

	public void setPatientId(Long newValue) 
	{
		this.patientId = newValue;
	}
	
}

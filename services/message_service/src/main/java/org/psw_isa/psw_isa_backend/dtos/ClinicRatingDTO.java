package org.psw_isa.psw_isa_backend.dtos;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import java.time.*;


public class ClinicRatingDTO {
	
    private Long id;

	
	
	private Integer rating;
	
	private Long clinicId; 
	
	
	private Long patientId; 
	

	public ClinicRatingDTO() 
	{
	}
	public ClinicRatingDTO(Integer rating, Long clinicId, Long patientId) {
		super();
		 
		this.rating = rating;;
		 
		this.clinicId = clinicId;
		 
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
	 
	public Long getClinicId() 
	{
		return this.clinicId;
	}

	public void setClinicId(Long newValue) 
	{
		this.clinicId = newValue;
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

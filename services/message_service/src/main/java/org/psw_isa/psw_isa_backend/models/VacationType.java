package org.psw_isa.psw_isa_backend.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.time.*;


@Entity
public class VacationType {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

	
	
	private String title; 
	

	public VacationType() 
	{
	}
	public VacationType(String _title) {
		super();
		 
		this.title = _title;
		
	}
	
	 
	public String getTitle() 
	{
		return this.title;
	}

	public void setTitle(String newValue) 
	{
		this.title = newValue;
	}
	
}
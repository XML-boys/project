package org.psw_isa.psw_isa_backend.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import java.time.*;


@Entity
public class ClinicAdministrator {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

	
	@ManyToOne
    @JoinColumn
	private Clinic clinic; 
	
	@ManyToOne
    @JoinColumn
	private User user; 
	

	public ClinicAdministrator() 
	{
	}
	public ClinicAdministrator(Clinic _clinic, User _user) {
		super();
		 
		this.clinic = _clinic;
		 
		this.user = _user;
		
	}
	
	 
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Clinic getClinic() 
	{
		return this.clinic;
	}

	public void setClinic(Clinic newValue) 
	{
		this.clinic = newValue;
	}
	 
	public User getUser() 
	{
		return this.user;
	}

	public void setUser(User newValue) 
	{
		this.user = newValue;
	}
	
}
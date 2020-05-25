package org.psw_isa.psw_isa_backend.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import java.time.*;


@Entity
public class OperationRequest {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

	
	@ManyToOne
    @JoinColumn
	private Patient patient; 
	
	
	private LocalDateTime time; 
	
	@ManyToOne
    @JoinColumn
	private Clinic clinic; 
	

	public OperationRequest() 
	{
	}
	public OperationRequest(Patient _patient, LocalDateTime _time, Clinic _clinic) {
		super();
		 
		this.patient = _patient;
		 
		this.time = _time;
		 
		this.clinic = _clinic;
		
	}
	
	public Long getId() {
		return this.id;
	}
	
	public void setId(Long id) {
		this.id=id;
	}
	 
	public Patient getPatient() 
	{
		return this.patient;
	}

	public void setPatient(Patient newValue) 
	{
		this.patient = newValue;
	}
	 
	public LocalDateTime getTime() 
	{
		return this.time;
	}

	public void setTime(LocalDateTime newValue) 
	{
		this.time = newValue;
	}
	 
	public Clinic getClinic() 
	{
		return this.clinic;
	}

	public void setClinic(Clinic newValue) 
	{
		this.clinic = newValue;
	}
	
}
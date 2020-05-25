package org.psw_isa.psw_isa_backend.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import java.time.*;
import java.util.ArrayList;


@Entity
public class Operation {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

	
	
	private ArrayList<Doctor> doctors; 
	
	@ManyToOne
    @JoinColumn
	private Patient patient; 
	
	@ManyToOne
    @JoinColumn
	private Room room; 
	
	@ManyToOne
    @JoinColumn
	private OperationRequest operationRequest; 
	
	
	private LocalDateTime startTime; 
	
	
	private LocalDateTime endTime; 
	

	public Operation() 
	{
	}
	public Operation(ArrayList<Doctor> _doctors, Patient _patient, Room _room, OperationRequest _operationRequest, LocalDateTime _startTime, LocalDateTime _endTime) {
		super();
		 
		this.doctors = _doctors;
		 
		this.patient = _patient;
		 
		this.room = _room;
		 
		this.operationRequest = _operationRequest;
		 
		this.startTime = _startTime;
		 
		this.endTime = _endTime;
		
	}
	
	 
	public ArrayList<Doctor> getDoctors() 
	{
		return this.doctors;
	}

	public void setDoctors(ArrayList<Doctor> newValue) 
	{
		this.doctors = newValue;
	}
	 
	public Patient getPatient() 
	{
		return this.patient;
	}

	public void setPatient(Patient newValue) 
	{
		this.patient = newValue;
	}
	 
	public Room getRoom() 
	{
		return this.room;
	}

	public void setRoom(Room newValue) 
	{
		this.room = newValue;
	}
	 
	public OperationRequest getOperationRequest() 
	{
		return this.operationRequest;
	}

	public void setOperationRequest(OperationRequest newValue) 
	{
		this.operationRequest = newValue;
	}
	 
	public LocalDateTime getStartTime() 
	{
		return this.startTime;
	}

	public void setStartTime(LocalDateTime newValue) 
	{
		this.startTime = newValue;
	}
	 
	public LocalDateTime getEndTime() 
	{
		return this.endTime;
	}

	public void setEndTime(LocalDateTime newValue) 
	{
		this.endTime = newValue;
	}
	public Long getId() {
		return this.id;
	}
	
	public void setId(Long id) {
		this.id=id;
	}
}
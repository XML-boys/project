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
public class Room {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

	
	
	private String title; 
	
	@ManyToOne
    @JoinColumn
	private Clinic clinic; 
	
	
	private Integer capacity; 
	
	private ArrayList<LocalDateTime> schedule=new ArrayList<LocalDateTime>();
	

	public Room() 
	{
	}
	public Room(String _title, Clinic _clinic, Integer _capacity) {
		super();
		 
		this.title = _title;
		 
		this.clinic = _clinic;
		 
		this.capacity = _capacity;
		
	}
	
	 
	public String getTitle() 
	{
		return this.title;
	}

	public void setTitle(String newValue) 
	{
		this.title = newValue;
	}
	 
	public Clinic getClinic() 
	{
		return this.clinic;
	}

	public void setClinic(Clinic newValue) 
	{
		this.clinic = newValue;
	}
	 
	public Integer getCapacity() 
	{
		return this.capacity;
	}

	public void setCapacity(Integer newValue) 
	{
		this.capacity = newValue;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public ArrayList<LocalDateTime> getSchedule() {
		return schedule;
	}
	public void setSchedule(ArrayList<LocalDateTime> schedule) {
		this.schedule = schedule;
	}
	
	public void addTime(LocalDateTime time) {
		
		this.schedule.add(time);
	}
}

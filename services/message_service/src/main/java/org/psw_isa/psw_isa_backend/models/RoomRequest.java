package org.psw_isa.psw_isa_backend.models;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.OneToMany;
import javax.persistence.ManyToMany;

@Entity
public class RoomRequest {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    	private Long id;
	
	
	
    	
	private LocalDateTime startTime;
	
	
    	
	private LocalDateTime endTime;
	
	@ManyToOne
    	@JoinColumn
	private Clinic clinic;
	
	@ManyToOne
    	@JoinColumn
	private Room room;
	
	
	public RoomRequest() 
	{
	}
	public RoomRequest(LocalDateTime _start, LocalDateTime _end, Clinic _clinic, Room _room, Long _id) {
		super();
		 
		this.startTime = _start;
		 
		this.endTime = _end;
		 
		this.clinic = _clinic;
		 
		this.room = _room;
		 
		this.id = _id;
		
	}
	
	
	public LocalDateTime getStartTime() {
		return startTime;
	}
	public void setStart(LocalDateTime startTime) {
		this.startTime = startTime;
	}
	
	public LocalDateTime getEndTime() {
		return endTime;
	}
	public void setEnd(LocalDateTime endTime) {
		this.endTime = endTime;
	}
	
	public Clinic getClinic() {
		return clinic;
	}
	public void setClinic(Clinic clinic) {
		this.clinic = clinic;
	}
	
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}
	

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}

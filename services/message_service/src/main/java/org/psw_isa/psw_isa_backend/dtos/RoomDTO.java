package org.psw_isa.psw_isa_backend.dtos;

import org.psw_isa.psw_isa_backend.models.Room;

public class RoomDTO {
	private Long id;

	
	private Long clinicId;
	
	
	
	private String title;
	
	private Integer capacity;
	
	public RoomDTO(){
		
	}
	
	public RoomDTO(Room room) {
		clinicId = room.getClinic().getId();
		title = room.getTitle();
		capacity = room.getCapacity();
	}

	public RoomDTO(Long id, Long clinicId, String title, Integer capacity) 
	{
		this.id = id; 
		this.clinicId = clinicId; 
		this.title = title;
		this.capacity = capacity;
	}
	
	
	public Long getClinicId() {
		return clinicId;
	}
	public void setClinicId(Long clinicId) {
		this.clinicId = clinicId;
	}
	
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public Integer getCapacity() {
		return capacity;
	}
	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}
	

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}

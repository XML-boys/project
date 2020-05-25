 package org.psw_isa.psw_isa_backend.dtos;

import java.time.LocalDateTime;

import org.psw_isa.psw_isa_backend.models.CareType;
import org.psw_isa.psw_isa_backend.models.Doctor;

public class CareRequestDTO {

	
	private LocalDateTime startTime;
	private Doctor doctor;
	private CareType careType;
	
	public CareRequestDTO(LocalDateTime startTime, Doctor doctor, CareType careType) {
		super();
		this.startTime = startTime;
		this.doctor = doctor;
		this.careType = careType;
	}
	
	public CareRequestDTO() {
		
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public CareType getcareType() {
		return careType;
	}

	public void setcareTypeID(CareType careType) {
		this.careType = careType;
	}
	
	
	
}

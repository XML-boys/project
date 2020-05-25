package org.psw_isa.psw_isa_backend.models;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class CareRequest {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

	
	@ManyToOne
    @JoinColumn
	private Doctor doctor;
	
	@ManyToOne
    @JoinColumn
	private Patient patient;
	
	private LocalDateTime time; 
	
	private Boolean approved;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	public Boolean getApproved() {
		return approved;
	}

	public void setApproved(Boolean approved) {
		this.approved = approved;
	}
	

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public CareRequest(Long id, Doctor doctor, LocalDateTime time, Boolean approved) {
		super();
		this.id = id;
		this.doctor = doctor;
		this.time = time;
		this.approved = approved;
	} 
	
	public CareRequest(Patient patient, Doctor doctor, LocalDateTime time, Boolean approved) {
		super();
		this.patient = patient;
		this.doctor = doctor;
		this.time = time;
		this.approved = approved;
	} 
	
	public CareRequest() {
		
	}
	
}

package org.psw_isa.psw_isa_backend.models;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Care {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
	
	@ManyToOne
    @JoinColumn
	private Doctor doctor; 
	
	@ManyToOne
    @JoinColumn
	private Patient patient; 
	
	@ManyToOne
    @JoinColumn
	private Room room; 
	
	@ManyToOne
    @JoinColumn
	private CareType careType; 
	
	
	private LocalDateTime startTime; 
	
	private LocalDateTime endTime;

	private Double price;

	private String comment;
	
	private Long medicalRecordId;

	@OneToOne
	private Diagnosis diagnosis;
	
	@OneToOne
	private Prescription prescription;
	
	private boolean approved;

	public CareType getCareType() {
		return careType;
	}

	public void setCareType(CareType careType) {
		this.careType = careType;
	}

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

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}

	public Care( Doctor doctor, Patient patient, Room room, LocalDateTime startTime, LocalDateTime endTime, Double price,String comment, Diagnosis diagnosis, Prescription prescription, Boolean approved) {
		super();
		this.doctor = doctor;
		this.patient = patient;
		this.room = room;
		this.startTime = startTime;
		this.endTime = endTime;
		this.price = price;
		this.comment=comment;
		this.diagnosis=diagnosis;
		this.prescription=prescription;
		this.approved=approved;
		
	} 
	
	public Care() {
		
	}
	
	


	

	public Double getPrice() {
		return price; 
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getComment() {
		return comment; 
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Diagnosis getDiagnosis() {
		return diagnosis; 
	}

	public void setDiagnosis(Diagnosis diagnosis) {
		this.diagnosis = diagnosis;
	}

	public Prescription getPrescription() {
		return prescription;
	}

	public void setPrescription(Prescription prescription) {
		this.prescription = prescription;
	}

	public boolean isApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}

	public Long getMedicalRecordId() {
		return medicalRecordId;
	}

	public void setMedicalRecordId(Long medicalRecordId) {
		this.medicalRecordId = medicalRecordId;
	}
	
}

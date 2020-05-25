package org.psw_isa.psw_isa_backend.dtos;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.psw_isa.psw_isa_backend.models.Diagnosis;
import org.psw_isa.psw_isa_backend.models.Prescription;

public class CareDTO {

	private Long careId;
	
	private Long doctorId; 
	
	private Long roomId; 
	
	private LocalDateTime startTime; 
	
	private LocalDateTime endTime;

	private Double price;
	
	private String comment;

	private Long  medicalRecordId;
	
	private Long diagnosisId;
	
	private Long prescriptionId;
	
	private boolean approved;



	public Long getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}

	public Long getRoomId() {
		return roomId;
	}

	public void setRoomId(Long roomId) {
		this.roomId = roomId;
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

	public CareDTO(Long careId,Long doctorId, Long roomId, LocalDateTime startTime, LocalDateTime endTime, Double price,String comment,Long diagnosisId, Long prescriptionId,Long medicalRecordId, Boolean approved) {
		super();
		this.careId=careId;
		this.doctorId = doctorId;
		this.roomId = roomId;
		this.startTime = startTime;
		this.endTime = endTime;
		this.price = price;
		this.comment=comment;
		this.diagnosisId=diagnosisId;
		this.prescriptionId=prescriptionId;
		this.medicalRecordId=medicalRecordId;
		this.approved=approved;
	
	} 
	
	public CareDTO() {
		
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

	

	public boolean isApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}

	public Long getDiagnosisId() {
		return diagnosisId;
	}

	public void setDiagnosisId(Long diagnosisId) {
		this.diagnosisId = diagnosisId;
	}

	public Long getPrescriptionId() {
		return prescriptionId;
	}

	public void setPrescriptionId(Long prescriptionId) {
		this.prescriptionId = prescriptionId;
	}

	public Long getCareId() {
		return careId;
	}

	public void setCareId(Long careId) {
		this.careId = careId;
	}

	public Long getMedicalRecordId() {
		return medicalRecordId;
	}

	public void setMedicalRecordId(Long medicalRecordId) {
		this.medicalRecordId = medicalRecordId;
	}
	
}

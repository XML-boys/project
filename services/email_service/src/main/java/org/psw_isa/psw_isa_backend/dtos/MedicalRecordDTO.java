package org.psw_isa.psw_isa_backend.dtos;

import org.psw_isa.psw_isa_backend.models.MedicalRecord;
import org.psw_isa.psw_isa_backend.models.Patient;



public class MedicalRecordDTO {

	private Long id;
	
	private Patient patient;
	
	
	private String height;
	
	private String width;
	
	private String bloodType;
	
	private String diopter;
	
	
	


public MedicalRecordDTO() {
		
	}

public MedicalRecordDTO(MedicalRecord medicalRecord) {
	this(medicalRecord.getId(), medicalRecord.getPatient(), medicalRecord.getWidth(), medicalRecord.getHeight(),medicalRecord.getBloodType(),medicalRecord.getDiopter());   

}
	
	
	public MedicalRecordDTO(Long id,Patient patient, String width, String height, String bloodType,String diopter) {
		super();
		this.id=id;
		this.patient=patient;
		this.width=width;
		this.height=height;
		this.bloodType=bloodType;
		this.diopter=diopter;
		
	}
	
	public Patient getPatient() {
		return patient;
	}


	public void setPatient(Patient  patient) {
		this.patient = patient;
	}


	public String getHeight() {
		return height;
	}


	public void setHeight(String height) {
		this.height = height;
	}


	public String getWidth() {
		return width;
	}


	public void setWidth(String width) {
		this.width = width;
	}


	public String getBloodType() {
		return bloodType;
	}


	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}


	public String getDiopter() {
		return diopter;
	}


	public void setDiopter(String diopter) {
		this.diopter = diopter;
	}

	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id=id;
	}


}

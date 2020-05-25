package org.psw_isa.psw_isa_backend.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class MedicalRecord {

	
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
	
	@ManyToOne
    @JoinColumn
	private Patient patient; 
	
	
	private String width;
	
	private String height;
	
	private String bloodType;
	
	private String diopter;
	
	
	
	
	public MedicalRecord() {
		
	}
	
	public MedicalRecord(Patient patient) {
		super();
		this.patient=patient;
		this.width="";
		this.height="";
		this.bloodType="";
		this.diopter="";
		
		
	}
	
	public MedicalRecord(Patient patient, String width, String height, String bloodType,String diopter) {
		super();
		this.patient=patient;
		this.width=width;
		this.height=height;
		this.bloodType=bloodType;
		this.diopter=diopter;
	
	}
	

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
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


	
	public Patient getPatient() {
		return patient;
	}
	
	public void setPatient(Patient patient) {
		this.patient=patient;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id=id;
	}

}

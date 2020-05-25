package org.psw_isa.psw_isa_backend.dtos;

import org.psw_isa.psw_isa_backend.models.Patient;

public class PatientDTO {

	private Long id;
	private String insuranceID;
	
	public PatientDTO() {
		
	}
	
	public PatientDTO(Patient patient) {
		this(patient.getId(), patient.getInsuranceID());
	}
	
	

	public PatientDTO(Long id, String insuranceID) {
		super();
		this.id = id;
		this.insuranceID = insuranceID;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getInsuranceID() {
		return insuranceID;
	}

	public void setInsuranceID(String insuranceID) {
		this.insuranceID = insuranceID;
	}
	
	
	
}

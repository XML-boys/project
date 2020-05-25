package org.psw_isa.psw_isa_backend.dtos;

import org.psw_isa.psw_isa_backend.models.MedicalRecord;
import org.psw_isa.psw_isa_backend.models.Patient;

public class PatientInfoDTO {
	
	public MedicalRecord medicalRecord;
	public Patient patient;
	
	public PatientInfoDTO(MedicalRecord medicalRecord, Patient patient) {
		super();
		this.medicalRecord = medicalRecord;
		this.patient = patient;
	}
	
	public PatientInfoDTO() {
		
	}

	public MedicalRecord getMedicalRecord() {
		return medicalRecord;
	}

	public void setMedicalRecord(MedicalRecord medicalRecord) {
		this.medicalRecord = medicalRecord;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	
	
}

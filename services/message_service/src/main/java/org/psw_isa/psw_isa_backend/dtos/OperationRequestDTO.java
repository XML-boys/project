package org.psw_isa.psw_isa_backend.dtos;

import org.psw_isa.psw_isa_backend.models.OperationRequest;
import java.time.LocalDateTime;

public class OperationRequestDTO {
	private Long id;

	
	private Long clinicId;
	
	private Long patientId;
	
	
	
	private LocalDateTime time;
	
	
	public OperationRequestDTO(Long id, Long patientId, Long clinicId, LocalDateTime time) 
	{
		this.id = id; 
		this.patientId = patientId;
		this.clinicId = clinicId;
		this.time = time;
	}

	public OperationRequestDTO(OperationRequest operationRequest) {
		// implement 
	}
	
	
	public Long getClinicId() {
		return clinicId;
	}
	public void setClinicId(Long clinicId) {
		this.clinicId = clinicId;
	}
	
	public Long getPatientId() {
		return patientId;
	}
	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}
	
	
	
	public LocalDateTime getTime() {
		return time;
	}
	public void setTime(LocalDateTime time) {
		this.time = time;
	}
	

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}

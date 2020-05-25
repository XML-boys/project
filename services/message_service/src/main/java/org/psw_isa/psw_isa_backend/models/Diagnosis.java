package org.psw_isa.psw_isa_backend.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Diagnosis {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
	
	private String diagnosis;
	
	public Diagnosis() {
		
	}
	
	public Diagnosis(String diagnosis) {
		this.diagnosis=diagnosis;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}
	
	public void setId(Long newValue) 
	{
		this.id = newValue;
	}
	 
	public Long getId() 
	{
		return this.id;
	}
	
}

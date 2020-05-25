package org.psw_isa.psw_isa_backend.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Medicine implements java.io.Serializable {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
	
	private String medicine;

	public Medicine() {
		
	}
	
	public Medicine(String medicine) {
		this.medicine=medicine;
	}
	
	public String getMedicine() {
		return medicine;
	}

	public void setMedicine(String medicine) {
		this.medicine = medicine;
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

package org.psw_isa.psw_isa_backend.models;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Prescription {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private Long id;
	
	
	private ArrayList<Medicine> medicines;

	
	private Long nurseId;
	
	private boolean approved;
	
	public Prescription() {
		
	}
	
	public Prescription(Long id, ArrayList<Medicine> lista, boolean approved) {
		super();
		this.id=id;
		this.medicines=lista;
		this.approved=approved;
		
	}
	public void setId(Long newValue) 
	{
		this.id = newValue;
	}
	 
	public Long getId() 
	{
		return this.id;
	}
	
	
	public ArrayList<Medicine> getMedicines() {
		return medicines;
	}

	public void setMedicines(ArrayList<Medicine> medicines) {
		this.medicines = medicines;
	}

	public Long getNurseId() {
		return nurseId;
	}

	public void setNurseId(Long nurseId) {
		this.nurseId = nurseId;
	}

	public boolean isApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}
	
	
}

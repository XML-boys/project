package org.psw_isa.psw_isa_backend.dtos;


import java.time.LocalDate;
import org.psw_isa.psw_isa_backend.models.CareType;

public class ClinicFilterDTO {

	private LocalDate date;
	private Long id;
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	

	public ClinicFilterDTO(LocalDate date, CareType type) {
		super();
		this.date = date;
	}
	
	public ClinicFilterDTO(LocalDate date, Long id) {
		super();
		this.date = date;
		this.id = id;
	}
	public ClinicFilterDTO() {

	}
	
}

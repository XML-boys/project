package org.psw_isa.psw_isa_backend.dtos;

import org.psw_isa.psw_isa_backend.models.CareType;

public class CareTypeDTO {
	private Long id;

	
	private String name;
	
	
	public CareTypeDTO(CareType careType) {
		this.id = careType.getId();
		this.name = careType.getName();
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}

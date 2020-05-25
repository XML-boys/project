package org.psw_isa.psw_isa_backend.dtos;

public class DeclineRegistrationRequestDTO {

	private Long id;
	
	private String comment;
	
	

	public DeclineRegistrationRequestDTO(Long id, String comment) {
		super();
		this.id = id;
		this.comment = comment;
	}
	
	public DeclineRegistrationRequestDTO() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
}

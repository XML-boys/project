package org.psw_isa.psw_isa_backend.dtos;

public class EmailDTO {

	private String message;
	
	private String to;
	
	private String subject;

	
	public EmailDTO() {
		
	}
	
	public EmailDTO(String subject, String to, String message) {
		super();
		this.message=message;
		this.subject=subject;
		this.to=to;
	}
	
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
}

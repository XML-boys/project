package org.psw_isa.psw_isa_backend.dtos;

public class LogInDTO {

	private String email;
	private String password;
	
	
	public LogInDTO(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}

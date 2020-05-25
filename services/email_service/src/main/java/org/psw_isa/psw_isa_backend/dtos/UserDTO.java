package org.psw_isa.psw_isa_backend.dtos;

import java.time.LocalDate;

public class UserDTO {
	
	public String firstname;
	public String lastname;
	public String email;
	public String mobilePhone;
	public String address;
	public String password;
	public Long id;
	public LocalDate birthday;
	
	public UserDTO(String firstname, String lastname, String email, String mobilePhone, String address, String password,
			Long id, LocalDate birthday) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.mobilePhone = mobilePhone;
		this.address = address;
		this.password = password;
		this.id = id;
		this.birthday = birthday;
	}
	
	public UserDTO(String firstname, String lastname, String mobilePhone, String address,
			LocalDate birthday) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.mobilePhone = mobilePhone;
		this.address = address;
		this.birthday = birthday;
	}

	public UserDTO() {
		super();
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}
	
	
	
	

}

package org.psw_isa.psw_isa_backend.models;


import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="users")
public class User implements java.io.Serializable {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

	
	private String firstname; 
	
	
	private String lastname; 
	
	
	private String mobilePhone; 
	
	
	private String email; 
	
	
	private String address; 
	

	private String password; 
	
	
	private LocalDate birthday; 

	private Integer numberOfLogins;
	

	public User() 
	{
	}
	public User(String _firstname, String _lastname, String _mobilePhone, String _email, String _address, LocalDate _birthday, String password, Integer numberOfLogins) {
		super();
		
		this.numberOfLogins = numberOfLogins;

		this.firstname = _firstname;
		 
		this.lastname = _lastname;
		 
		this.mobilePhone = _mobilePhone;
		 
		this.email = _email;
		 
		this.address = _address;
		 
		this.birthday = _birthday;

		this.password = password;
		
	}
	
	public User(String _firstname, String _lastname, String _mobilePhone, String _address, LocalDate _birthday) {
		super();
		 
		this.firstname = _firstname;
		 
		this.lastname = _lastname;
		 
		this.mobilePhone = _mobilePhone;
		 		 
		this.address = _address;
		 
		this.birthday = _birthday;
		
	}
	
	 
	public String getFirstname() 
	{
		return this.firstname;
	}

	public void setFirstname(String newValue) 
	{
		this.firstname = newValue;
	}
	 
	public String getLastname() 
	{
		return this.lastname;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setLastname(String newValue) 
	{
		this.lastname = newValue;
	}
	 
	public String getMobilePhone() 
	{
		return this.mobilePhone;
	}

	public void setMobilePhone(String newValue) 
	{
		this.mobilePhone = newValue;
	}
	 
	public String getEmail() 
	{
		return this.email;
	}

	public void setEmail(String newValue) 
	{
		this.email = newValue;
	}
	 
	public String getAddress() 
	{
		return this.address;
	}

	public void setAddress(String newValue) 
	{
		this.address = newValue;
	}
	 
	public LocalDate getBirthday() 
	{
		return this.birthday;
	}

	public void setBirthday(LocalDate newValue) 
	{
		this.birthday = newValue;
	}

	public void setNumberOfLogins(Integer val) 
	{
		this.numberOfLogins = val;
	}

	public Integer getNumberOfLogins() 
	{
		return numberOfLogins;
	}

	public void increaseNumberOfLogins() 
	{
		numberOfLogins++;
	}
	
}

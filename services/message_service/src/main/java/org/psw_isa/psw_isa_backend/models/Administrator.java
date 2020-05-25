package org.psw_isa.psw_isa_backend.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import java.time.*;


@Entity
public class Administrator {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

	
	@ManyToOne
    @JoinColumn
	private User user; 
	

	public Administrator() 
	{
	}
	public Administrator(User _user) {
		super();
		 
		this.user = _user;
		
	}
	
	 
	public User getUser() 
	{
		return this.user;
	}

	public void setUser(User newValue) 
	{
		this.user = newValue;
	}
	
}

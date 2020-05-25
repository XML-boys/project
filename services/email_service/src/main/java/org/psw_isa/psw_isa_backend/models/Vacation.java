package org.psw_isa.psw_isa_backend.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import java.time.*;


@Entity
public class Vacation {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

	
	
	private LocalDate startTime; 
	
	
	private LocalDate endTime; 
	
	@ManyToOne
    @JoinColumn
	private User user; 
	
	
	private Boolean approved; 

	private Boolean processed;
	
	
	private String commentFromUser; 
	
	
	private String commentFromAdministrator; 
	
	@ManyToOne
    @JoinColumn
	private VacationType type; 
	
	@ManyToOne
    @JoinColumn
	private ClinicAdministrator approver; 
	

	public Vacation() 
	{
	}
	public Vacation(LocalDate _startTime, LocalDate _endTime, User _user, Boolean _approved, String _commentFromUser, String _commentFromAdministrator, VacationType _type, ClinicAdministrator _approver, Boolean _processed) {
		super();
		 
		this.startTime = _startTime;

		this.processed = _processed;
		 
		this.endTime = _endTime;
		 
		this.user = _user;
		 
		this.approved = _approved;
		 
		this.commentFromUser = _commentFromUser;
		 
		this.commentFromAdministrator = _commentFromAdministrator;
		 
		this.type = _type;
		 
		this.approver = _approver;
		
	}
	
	 
	public LocalDate getStartTime() 
	{
		return this.startTime;
	}

	public void setStartTime(LocalDate newValue) 
	{
		this.startTime = newValue;
	}
	 
	public LocalDate getEndTime() 
	{
		return this.endTime;
	}

	public void setEndTime(LocalDate newValue) 
	{
		this.endTime = newValue;
	}
	 
	public User getUser() 
	{
		return this.user;
	}

	public void setUser(User newValue) 
	{
		this.user = newValue;
	}
	 
	public Boolean getApproved() 
	{
		return this.approved;
	}

	public void setApproved(Boolean newValue) 
	{
		this.approved = newValue;
	}
	 
	public String getCommentFromUser() 
	{
		return this.commentFromUser;
	}

	public void setCommentFromUser(String newValue) 
	{
		this.commentFromUser = newValue;
	}
	 
	public String getCommentFromAdministrator() 
	{
		return this.commentFromAdministrator;
	}

	public void setCommentFromAdministrator(String newValue) 
	{
		this.commentFromAdministrator = newValue;
	}
	 
	public VacationType getType() 
	{
		return this.type;
	}

	public void setType(VacationType newValue) 
	{
		this.type = newValue;
	}
	 
	public ClinicAdministrator getApprover() 
	{
		return this.approver;
	}

	public void setApprover(ClinicAdministrator newValue) 
	{
		this.approver = newValue;
	}

	public Long getId() 
	{
		return this.id;
	}

	public void setId(Long id) 
	{
		this.id = id;
	}
	
	public void setProcessed(Boolean processed) {
		this.processed = processed;
	}

	public Boolean getProcessed() {
		return this.processed;
	}
}

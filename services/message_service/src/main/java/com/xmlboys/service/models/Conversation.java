package com.xmlboys.service.models;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.OneToMany;
import javax.persistence.ManyToMany;


@Entity
public class Conversation {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    	private Long id;
	
	
	
    	
	private Long order_id;
	
	
	public Conversation() 
	{
	}
	public Conversation(Long _order_id, Long _id) {
		super();
		 
		this.order_id = _order_id;
		 
		this.id = _id;
		
	}
	
	
	public Long getOrderId() {
		return order_id;
	}
	public void setOrderId(Long order_id) {
		this.order_id = order_id;
	}
	

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}

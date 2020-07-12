package com.xmlboys.service.dtos;

import com.xmlboys.service.models.Conversation;

public class ConversationDTO {
	private Long id;

	
	private Long userId;
	
	
	
	private Long orderId;
	
	
	public ConversationDTO(Conversation conversation) {
		// implement 
	}
	
	public ConversationDTO() {
	}
	
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	
	
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
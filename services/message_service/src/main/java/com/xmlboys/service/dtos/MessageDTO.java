package com.xmlboys.service.dtos;

import com.xmlboys.service.models.Message;

public class MessageDTO {
	private Long id;

	
	
	private String fromUser;
	
	private String toUser;
	
	private Long conversationId;

	private String content;

	public MessageDTO(Message message) {
		// implement 
	}
	
	
	public String getFromUser() {
		return fromUser;
	}
	public void setFromUser(String fromUser) {
		this.fromUser = fromUser;
	}
	
	public String getToUser() {
		return toUser;
	}
	public void setToUser(String toUser) {
		this.toUser = toUser;
	}
	

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getConversationId() {
		return conversationId;
	}

	public void setConversationId(Long conversationId) {
		this.conversationId = conversationId;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getContent() {
		return this.content;
	}
	
}
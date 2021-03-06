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

import net.bytebuddy.implementation.attribute.AnnotationAppender.Target.OnType;

import javax.persistence.OneToMany;
import javax.persistence.ManyToMany;

@Entity
public class Message {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    	private Long id;
	
	
	
    	
	private String fromUser;
	
	
    	
	private String toUser;

	private String content;
	
	@ManyToOne
    	@JoinColumn
	private Conversation conversation;
	
	
	public Message() 
	{
	}
	public Message(String _fromUser, String _toUser, Conversation _conversation, String content, Long _id) {
		super();
		 
		this.fromUser = _fromUser;
		 
		this.toUser = _toUser;
		 
		this.conversation = _conversation;
		this.content = content;
		 
		this.id = _id;
		
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
	
	public Conversation getConversation() {
		return conversation;
	}
	public void setConversation(Conversation conversation) {
		this.conversation = conversation;
	}
	

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getContent() {
		return content;
	}
}
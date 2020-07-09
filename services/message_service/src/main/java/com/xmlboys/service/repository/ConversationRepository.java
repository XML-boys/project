package com.xmlboys.service.repository;

import java.util.List;

import com.xmlboys.service.models.Conversation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConversationRepository extends JpaRepository<Conversation, Long> {

	
	public Conversation findOneByid(Long id);
	
	public List<Conversation> findAll();
	
}
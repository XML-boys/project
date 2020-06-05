package com.xmlboyz.service.repository;

import java.util.List;

import com.xmlboyz.service.models.Conversation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConversationRepository extends JpaRepository<Conversation, Long> {

	
	public Conversation findOneByid(Long id);
	
	public List<Conversation> findAll();
	
}
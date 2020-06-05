package com.xmlboyz.service.service;

import java.util.List;

import com.xmlboyz.service.models.Conversation;
import com.xmlboyz.service.repository.ConversationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConversationService {

	
	@Autowired
	ConversationRepository conversationRepository;
	
	
	public Conversation findOneByid(Long id) {
		return conversationRepository.findOneByid(id);
	}
	
	public List<Conversation> findAll() {
		return conversationRepository.findAll();
	}
}

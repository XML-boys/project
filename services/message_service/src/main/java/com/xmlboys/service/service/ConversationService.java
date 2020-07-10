package com.xmlboys.service.service;

import java.util.List;

import com.xmlboys.service.dtos.ConversationDTO;
import com.xmlboys.service.models.Conversation;
import com.xmlboys.service.repository.ConversationRepository;
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

	public Conversation save(ConversationDTO dto) {
		return conversationRepository.save(new Conversation(dto.getOrderId(), null));
	}
}

package com.xmlboys.service.service;

import java.util.List;

import com.xmlboys.service.dtos.MessageDTO;
import com.xmlboys.service.models.Message;
import com.xmlboys.service.repository.MessageRepository;

import org.postgresql.translation.messages_bg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

	
	@Autowired
	MessageRepository messageRepository;
	
	@Autowired
	ConversationService conversationService;
	
	public Message findOneByid(Long id) {
		return messageRepository.findOneByid(id);
	}
	
	public List<Message> findAll() {
		return messageRepository.findAll();
	}

	public Message save(MessageDTO dto) {
		return messageRepository.save(new Message(dto.getFromUser(), dto.getToUser(), conversationService.findOneByid(dto.getConversationId()), dto.getContent(), null));
	}
}
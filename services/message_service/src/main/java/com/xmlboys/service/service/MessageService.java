package com.xmlboyz.service.service;

import java.util.List;

import com.xmlboyz.service.models.Message;
import com.xmlboyz.service.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

	
	@Autowired
	MessageRepository messageRepository;
	
	
	public Message findOneByid(Long id) {
		return messageRepository.findOneByid(id);
	}
	
	public List<Message> findAll() {
		return messageRepository.findAll();
	}
}
package com.xmlboyz.service.repository;

import java.util.List;

import com.xmlboyz.service.models.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {

	
	public Message findOneByid(Long id);
	
	public List<Message> findAll();
	
}
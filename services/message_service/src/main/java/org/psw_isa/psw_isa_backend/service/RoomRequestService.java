package org.psw_isa.psw_isa_backend.service;

import java.util.List;

import org.psw_isa.psw_isa_backend.models.RoomRequest;
import org.psw_isa.psw_isa_backend.repository.RoomRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomRequestService {

	
	@Autowired
	RoomRequestRepository roomRequestRepository;
	
	
	public RoomRequest findOneByid(Long id) {
		return roomRequestRepository.findOneByid(id);
	}
	
	public List<RoomRequest> findAll() {
		return roomRequestRepository.findAll();
	}
}
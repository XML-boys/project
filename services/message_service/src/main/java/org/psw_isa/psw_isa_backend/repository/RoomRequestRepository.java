package org.psw_isa.psw_isa_backend.repository;

import java.util.List;

import org.psw_isa.psw_isa_backend.models.RoomRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRequestRepository extends JpaRepository<RoomRequest, Long> {

	
	public RoomRequest findOneByid(Long id);
	
	public List<RoomRequest> findAll();
	
}
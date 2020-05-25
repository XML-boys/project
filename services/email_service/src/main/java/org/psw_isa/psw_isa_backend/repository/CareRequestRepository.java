package org.psw_isa.psw_isa_backend.repository;

import java.util.List;

import org.psw_isa.psw_isa_backend.models.CareRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CareRequestRepository extends JpaRepository<CareRequest, Long> {

	
	List<CareRequest> findAll();

	CareRequest findOneByid(Long id);
	
}

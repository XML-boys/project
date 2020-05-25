package org.psw_isa.psw_isa_backend.repository;

import java.util.List;

import org.psw_isa.psw_isa_backend.models.RegistrationRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RegistrationRequestRepository extends JpaRepository<RegistrationRequest, Long> {
	
	List<RegistrationRequest> findAll();
	
	public RegistrationRequest findOneById(Long id);
	
	

}

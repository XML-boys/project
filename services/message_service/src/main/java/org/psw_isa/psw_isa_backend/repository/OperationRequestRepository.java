package org.psw_isa.psw_isa_backend.repository;


import java.util.List;


import org.psw_isa.psw_isa_backend.models.OperationRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationRequestRepository extends JpaRepository<OperationRequest, Long> {

	List<OperationRequest> findAll();
	
	public OperationRequest findOneById(Long id);
	
	public void deleteById(Long id);
}

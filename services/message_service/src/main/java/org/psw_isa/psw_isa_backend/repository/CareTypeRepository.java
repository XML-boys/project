package org.psw_isa.psw_isa_backend.repository;

import java.util.List;

import org.psw_isa.psw_isa_backend.models.CareRequest;
import org.psw_isa.psw_isa_backend.models.CareType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CareTypeRepository extends JpaRepository<CareType, Long> {

	
	public CareType findOneByid(Long id);
	
	List<CareType> findAll();
	
}

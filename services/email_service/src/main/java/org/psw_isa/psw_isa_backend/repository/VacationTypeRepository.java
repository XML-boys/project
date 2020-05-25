package org.psw_isa.psw_isa_backend.repository;

import java.util.List;

import org.psw_isa.psw_isa_backend.models.VacationType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VacationTypeRepository extends JpaRepository<VacationType, Long> {

	
	public VacationType findOneByid(Long id);
	
	public List<VacationType> findAll();
	
}

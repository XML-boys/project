package org.psw_isa.psw_isa_backend.repository;

import java.util.List;

import org.psw_isa.psw_isa_backend.models.Diagnosis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface DiagnosisRepository extends JpaRepository<Diagnosis, Long> {
		
	public Diagnosis findOneByid(Long id);
	public List<Diagnosis> findAll();
	

	
}

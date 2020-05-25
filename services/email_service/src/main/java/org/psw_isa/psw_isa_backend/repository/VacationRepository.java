package org.psw_isa.psw_isa_backend.repository;

import java.util.List;

import org.psw_isa.psw_isa_backend.models.Vacation;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Lock;
import javax.persistence.LockModeType;



public interface VacationRepository extends JpaRepository<Vacation, Long> {

	

	public Vacation findOneByid(Long id);
	
	public List<Vacation> findAll();
	
	public Vacation save(Vacation vacation);

	
}

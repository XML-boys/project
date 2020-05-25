package org.psw_isa.psw_isa_backend.repository;

import java.util.List;

import org.psw_isa.psw_isa_backend.models.Nurse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NurseRepository extends JpaRepository<Nurse, Long> {
	
	Nurse findOneByid(Long id);

	Nurse findOneByuser(Long id);
	
	List<Nurse> findAll();

}

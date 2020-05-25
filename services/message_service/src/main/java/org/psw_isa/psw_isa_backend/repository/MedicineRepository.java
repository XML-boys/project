package org.psw_isa.psw_isa_backend.repository;

import java.util.List;


import org.psw_isa.psw_isa_backend.models.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicineRepository extends JpaRepository<Medicine, Long> {
	
	public Medicine findOneByid(Long id);
	public List<Medicine> findAll();
}

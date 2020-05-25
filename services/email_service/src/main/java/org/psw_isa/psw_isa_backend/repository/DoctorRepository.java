package org.psw_isa.psw_isa_backend.repository;

import org.psw_isa.psw_isa_backend.models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

	public Doctor findOneByid(Long id);
	public List<Doctor> findAll();
	
	public Doctor findOneByuser(Long id);
	
}

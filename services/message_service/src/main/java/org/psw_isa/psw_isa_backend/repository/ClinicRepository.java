package org.psw_isa.psw_isa_backend.repository;

import java.util.List;
import org.psw_isa.psw_isa_backend.models.Clinic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClinicRepository extends JpaRepository<Clinic, Long> {
	public Clinic findOneByid(Long id);
	public List<Clinic> findAll();
}

package org.psw_isa.psw_isa_backend.repository;

import java.util.List;
import org.psw_isa.psw_isa_backend.models.DoctorRating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRatingRepository extends JpaRepository<DoctorRating, Long> {
	public DoctorRating findOneByid(Long id);
	public List<DoctorRating> findAll();
}

package org.psw_isa.psw_isa_backend.repository;

import java.util.List;
import org.psw_isa.psw_isa_backend.models.ClinicRating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClinicRatingRepository extends JpaRepository<ClinicRating, Long> {
	public ClinicRating findOneByid(Long id);
	public List<ClinicRating> findAll();
}

package org.psw_isa.psw_isa_backend.repository;

import java.time.LocalDate;
import java.util.List;

import org.psw_isa.psw_isa_backend.models.Clinic;
import org.psw_isa.psw_isa_backend.models.ClinicAdministrator;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ClinicAdminRepository extends JpaRepository<ClinicAdministrator,Long > {

	@Modifying
	@Query(value = "UPDATE ClinicAdministrator admin SET admin.clinic = :clinic WHERE admin.id = :id", nativeQuery = true)
	public String updateAdminClinic(@Param("clinic") Long clinic, @Param("id") Long id);

	ClinicAdministrator findOneByid(Long id);
	
	List<ClinicAdministrator> findAll();
	
	ClinicAdministrator findOneByuser(Long id);
}

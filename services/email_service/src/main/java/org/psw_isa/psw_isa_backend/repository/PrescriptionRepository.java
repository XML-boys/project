package org.psw_isa.psw_isa_backend.repository;

import java.util.ArrayList;
import java.util.List;


import org.psw_isa.psw_isa_backend.models.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import org.psw_isa.psw_isa_backend.models.Medicine;



public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {
	
	
	Prescription findOneByid(Long id);
	
	List<Prescription> findAll();
	
	
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE prescription SET medicines = :medicines WHERE id = :id", nativeQuery = true)
	public int updatePrescription(@Param("medicines") ArrayList<Medicine> medicines,   @Param("id") Long id);

	
	@Transactional
	@Modifying
	@Query(value = "UPDATE prescription SET approved = :approved, nurse_id = :nurseId WHERE id = :id", nativeQuery = true)
	public int updateApprovePrescription(@Param("approved") boolean approved,@Param("nurseId") Long nurseId,@Param("id") Long id);

}

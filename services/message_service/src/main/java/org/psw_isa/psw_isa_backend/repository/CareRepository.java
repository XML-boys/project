package org.psw_isa.psw_isa_backend.repository;



import java.time.LocalDate;


import org.psw_isa.psw_isa_backend.models.Care;
import org.psw_isa.psw_isa_backend.models.Diagnosis;
import org.psw_isa.psw_isa_backend.models.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface CareRepository extends JpaRepository<Care, Long> {

	public Care findOneByid(Long id);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE care SET patient_id = :patient_id WHERE id = :id", nativeQuery = true)
	public int carePatientUpdate(@Param("patient_id") Long patientID, @Param("id") Long careID);


	

	
	@Transactional
	@Modifying
	@Query(value = "UPDATE care SET comment = :comment, diagnosis_id = :diagnosis_id, prescription_id = :prescription_id, medical_record_id= :medical_record_id, approved = :approved WHERE id = :id", nativeQuery = true)
	public int updateCareReview(@Param("comment") String comment, @Param("diagnosis_id") Long diagnosis_id, @Param("prescription_id") Long prescription_id,@Param("medical_record_id") Long medical_record_id, @Param("approved") boolean approved,  @Param("id") Long id);


	@Transactional
	@Modifying
	@Query(value = "UPDATE care SET comment = :comment, diagnosis_id = :diagnosis_id, prescription_id = :prescription_id WHERE id = :id", nativeQuery = true)
	public int updateOldCareReview(@Param("comment") String comment, @Param("diagnosis_id") Long diagnosis_id, @Param("prescription_id") Long prescription_id,  @Param("id") Long id);

}

package org.psw_isa.psw_isa_backend.repository;

import java.util.List;

import org.psw_isa.psw_isa_backend.models.MedicalRecord;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface MedicalRecordRepository extends JpaRepository<MedicalRecord, Long> {
	
	
	public MedicalRecord findOneByid(Long id);
	public MedicalRecord findOneBypatient_id(Long id);
	List<MedicalRecord> findAll();
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE medical_record SET height = :height, width = :width, blood_type = :blood_type, diopter = :diopter WHERE id = :id", nativeQuery = true)
	public int updateMedicalRecord(@Param("height") String height, @Param("width") String width, @Param("blood_type") String bloodType, @Param("diopter") String diopter,  @Param("id") Long id);

}

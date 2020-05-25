package org.psw_isa.psw_isa_backend.service;

import java.util.List;

import org.psw_isa.psw_isa_backend.models.Diagnosis;
import org.psw_isa.psw_isa_backend.models.Patient;
import org.psw_isa.psw_isa_backend.models.Prescription;
import org.psw_isa.psw_isa_backend.repository.PrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrescriptionService {

	@Autowired
	PrescriptionRepository prescriptionRepository;
	
	public Prescription save(Prescription prescription) {
		return prescriptionRepository.save(prescription);
	}
	
	
	public List<Prescription> findAll() {
		return prescriptionRepository.findAll();
	}
	
	
	public Prescription findOneByid(Long id) {
		return prescriptionRepository.findOneByid(id);
	}
	
	public int updateApprovePrescription(boolean approved,Long nurseId,Long id){
		return prescriptionRepository.updateApprovePrescription(approved,nurseId, id);
	}
	

}

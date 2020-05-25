package org.psw_isa.psw_isa_backend.service;

import java.util.List;

import org.psw_isa.psw_isa_backend.models.Diagnosis;
import org.psw_isa.psw_isa_backend.models.Medicine;
import org.psw_isa.psw_isa_backend.repository.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicineService {

	@Autowired
	MedicineRepository medicineRepository;
	
	public Medicine save(Medicine medicine) {
		return medicineRepository.save(medicine);
	}
	
	public List<Medicine> findAll() {
		return medicineRepository.findAll();
	}
	
	
	public Medicine findOneByid(Long id) {
		return medicineRepository.findOneByid(id);
	}
}

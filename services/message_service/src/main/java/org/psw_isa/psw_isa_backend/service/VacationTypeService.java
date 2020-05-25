package org.psw_isa.psw_isa_backend.service;

import java.util.List;

import org.psw_isa.psw_isa_backend.models.VacationType;
import org.psw_isa.psw_isa_backend.repository.VacationTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VacationTypeService {

	
	@Autowired
	VacationTypeRepository vacationTypeRepository;
	
	
	public VacationType findOneByid(Long id) {
		return vacationTypeRepository.findOneByid(id);
	}
	
	public List<VacationType> findAll() {
		return vacationTypeRepository.findAll();
	}
}
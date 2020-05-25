package org.psw_isa.psw_isa_backend.service;

import java.util.List;

import org.psw_isa.psw_isa_backend.models.CareType;
import org.psw_isa.psw_isa_backend.repository.CareTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CareTypeService {
	
	@Autowired
	CareTypeRepository careTypeRepository;
	
	
	public List<CareType> findAll(){
		return careTypeRepository.findAll();
	}
	
	public CareType findOneByid(Long id) {
		return careTypeRepository.findOneByid(id);
	}

	public CareType save(CareType careType) {
		careType.setId(null);
		return careTypeRepository.save(careType);
	}

	public CareType update(CareType careType) {
		return careTypeRepository.save(careType);
	}

	public Long delete(Long id) 
	{
		careTypeRepository.delete(findOneByid(id));
		return id; 
	}

}

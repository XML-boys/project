package org.psw_isa.psw_isa_backend.service;

import java.util.List;

import org.psw_isa.psw_isa_backend.models.Administrator;
import org.psw_isa.psw_isa_backend.repository.AdministratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdministratorService {

	
	@Autowired
	AdministratorRepository administratorRepository;
	
	
	public Administrator findOneByid(Long id) {
		return administratorRepository.findOneByid(id);
	}
	
	public List<Administrator> findAll() {
		return administratorRepository.findAll();
	}
}

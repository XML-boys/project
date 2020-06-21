package com.xmlboyz.service.service;

import java.util.List;

import com.xmlboyz.service.models.Vehicle;
import com.xmlboyz.service.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleService {

	
	@Autowired
	VehicleRepository vehicleRepository;
	
	
	public Vehicle findOneByid(Long id) {
		return vehicleRepository.findOneByid(id);
	}
	
	public List<Vehicle> findAll() {
		return vehicleRepository.findAll();
	}

	public Vehicle save(Vehicle vehicle) {
		return vehicleRepository.save(vehicle);
	}
}

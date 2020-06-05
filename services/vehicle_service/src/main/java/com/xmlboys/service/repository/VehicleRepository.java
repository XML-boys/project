package com.xmlboyz.service.repository;

import java.util.List;

import com.xmlboyz.service.models.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

	
	public Vehicle findOneByid(Long id);
	
	public List<Vehicle> findAll();
	
}
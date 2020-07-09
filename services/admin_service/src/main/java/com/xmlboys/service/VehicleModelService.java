package com.xmlboys.service;

import com.xmlboys.model.VehicleModel;
import com.xmlboys.repository.VehicleModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleModelService {
    @Autowired
    VehicleModelRepository vehicleModelRepository;

    public VehicleModel save(VehicleModel vehicleModel) {return vehicleModelRepository.save(vehicleModel);}

    public void delete(Long id) {vehicleModelRepository.deleteById(id);}

    public VehicleModel findById(Long id) { return vehicleModelRepository.findById(id).orElseGet(null);}

}

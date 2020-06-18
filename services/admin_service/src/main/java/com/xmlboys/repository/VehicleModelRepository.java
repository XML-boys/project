package com.xmlboys.repository;

import com.xmlboys.model.VehicleModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleModelRepository extends CrudRepository<VehicleModel, Long> {


}

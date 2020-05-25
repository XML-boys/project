package org.psw_isa.psw_isa_backend.service;

import org.psw_isa.psw_isa_backend.models.ClinicRating;
import org.psw_isa.psw_isa_backend.repository.ClinicRatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;
import org.psw_isa.psw_isa_backend.models.Clinic;

@Service
public class ClinicRatingService {

	@Autowired 
	ClinicRatingRepository clinicRatingRepository;
	
	
	public ClinicRating save(ClinicRating clinicRating) {
		return clinicRatingRepository.save(clinicRating);
	}

	public ClinicRating findOneByid(Long id) {
		return clinicRatingRepository.findOneByid(id);
	}

	public List<ClinicRating> findAll() {
		return clinicRatingRepository.findAll();
	}

	public Double getClinicAverage(Clinic clinic) 
	{
		int count = 0; 
		double sum = 0;
		List<ClinicRating> ratings = this.findAll();
		for (ClinicRating rating : ratings) {
			if (rating.getClinic() != null && rating.getClinic().getId() == clinic.getId()) {
				count++;
				sum += rating.getRating();
			}
		}
		return sum / count;

	}
}

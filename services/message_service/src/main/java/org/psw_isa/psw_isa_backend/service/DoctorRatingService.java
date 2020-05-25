package org.psw_isa.psw_isa_backend.service;

import org.psw_isa.psw_isa_backend.models.DoctorRating;
import org.psw_isa.psw_isa_backend.repository.DoctorRatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;
import org.psw_isa.psw_isa_backend.models.Doctor;

@Service
public class DoctorRatingService {

	@Autowired 
	DoctorRatingRepository doctorRatingRepository;
	
	
	public DoctorRating save(DoctorRating doctorRating) {
		return doctorRatingRepository.save(doctorRating);
	}

	public DoctorRating findOneByid(Long id) {
		return doctorRatingRepository.findOneByid(id);
	}

	public List<DoctorRating> findAll() {
		return doctorRatingRepository.findAll();
	}

	public Double getDoctorAverage(Doctor doctor) 
	{
		int count = 0; 
		double sum = 0;
		List<DoctorRating> ratings = this.findAll();
		for (DoctorRating rating : ratings) {
			if (rating.getDoctor() != null && rating.getDoctor().getId() == doctor.getId()) {
				count++;
				sum += rating.getRating();
			}
		}
		return sum / count;

	}
}

package org.psw_isa.psw_isa_backend.service;

import java.util.ArrayList;
import java.util.List;

import org.psw_isa.psw_isa_backend.models.ClinicAdministrator;
import org.psw_isa.psw_isa_backend.models.Doctor;
import org.psw_isa.psw_isa_backend.models.OperationRequest;
import org.psw_isa.psw_isa_backend.repository.OperationRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.psw_isa.psw_isa_backend.dtos.OperationRequestDTO;

import java.util.stream.*; 

@Service
public class OperationRequestService {

	@Autowired
	OperationRequestRepository operationRequestRepository;
	
	@Autowired 
	PatientService patientService;

	@Autowired
	ClinicService clinicService;
	
	@Autowired
	CheckRoleService checkRoleService;
	
	@Autowired
	ClinicAdminService clinicAdminService;

	@Autowired
	DoctorService doctorService;
	
	

	public List<OperationRequest> findAll() {
		return operationRequestRepository.findAll();
	}


	public OperationRequest save(OperationRequestDTO dto) 
	{
		OperationRequest operationRequest = new OperationRequest();
		operationRequest.setClinic(clinicService.findOneByid(dto.getClinicId()));
		operationRequest.setPatient(patientService.findOneByid(dto.getPatientId()));
		operationRequest.setTime(dto.getTime());
		return operationRequestRepository.save(operationRequest);
}

	
	public void deleteOneById(Long id) {
		operationRequestRepository.deleteById(id);

	}
	
	public List<OperationRequest> operationRequestForClinic(){
		if (clinicAdminService.getClinic() != null) {
			return findAll().stream()
				.filter(x -> x.getClinic().getId() == clinicAdminService.getClinic().getId())
				.collect(Collectors.toList());
		}
		else if (checkRoleService.checkIfDoctor()){
			Long clinicId = doctorService.findAll().stream()
				.filter(x -> x.getUser().getId() == checkRoleService.getUser().getId())
				.findFirst().get().getClinic().getId();
			return findAll().stream()
				.filter(x -> x.getClinic().getId() == clinicId)
				.collect(Collectors.toList());
			

		}
		else {
			return new ArrayList<>();
		}
	}
}

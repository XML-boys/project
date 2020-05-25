package org.psw_isa.psw_isa_backend.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.ListIterator;

import org.hibernate.mapping.Array;
import org.psw_isa.psw_isa_backend.dtos.CareRequestDTO;
import org.psw_isa.psw_isa_backend.dtos.ClinicFilterDTO;
import org.psw_isa.psw_isa_backend.models.Care;
import org.psw_isa.psw_isa_backend.models.Clinic;
import org.psw_isa.psw_isa_backend.models.ClinicAdministrator;
import org.psw_isa.psw_isa_backend.models.Doctor;
import org.psw_isa.psw_isa_backend.models.Operation;
import org.psw_isa.psw_isa_backend.models.OperationRequest;
import org.psw_isa.psw_isa_backend.models.Vacation;
import org.psw_isa.psw_isa_backend.repository.CareRepository;
import org.psw_isa.psw_isa_backend.repository.CareTypeRepository;
import org.psw_isa.psw_isa_backend.repository.DoctorRepository;
import org.psw_isa.psw_isa_backend.repository.OperationRepository;
import org.psw_isa.psw_isa_backend.repository.VacationRepository;
import org.psw_isa.psw_isa_backend.models.Clinic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {
	
	@Autowired
	DoctorRepository doctorRepository;
	
	@Autowired
	CareRepository careRepository;
	
	@Autowired
	OperationRepository operationRepository;

	@Autowired
	CheckRoleService checkRoleService;
	
	@Autowired
	CareTypeRepository careTypeRepository;
	
	@Autowired
	VacationRepository vacationRepository;
	
	@Autowired
	ClinicAdminService clinicAdminService;
	
	
	
	
	public List<Doctor> findAll() {
		return doctorRepository.findAll();
	}
	
	
	public Doctor findOneByid(Long id) {
		return doctorRepository.findOneByid(id);
	}
	
	
	
	public List<Doctor> listFreeDoctorsForClinic(Long clinicID, Long careTypeID, String date){
		List<Doctor> res = new ArrayList<>();
		List<Care> allCares = careRepository.findAll();
		List<Operation> allOperations = new ArrayList<Operation>();
		if(operationRepository.findAll() != null) {
			allOperations = operationRepository.findAll();
		}
		List<Doctor> allDoctors = doctorRepository.findAll(); 
		List<Care> doctorsCaresForDate = new ArrayList<>();
		List<Operation> doctorsOperationsForDate = new ArrayList<>();
		List<Vacation> allVacations = new ArrayList<Vacation>();
		if(vacationRepository.findAll() != null) {
			allVacations = vacationRepository.findAll();
		}
		List<Vacation> doctorsVacations = new ArrayList<Vacation>();
		LocalDate wantedDate = LocalDate.parse(date);
		LocalDate startTime = null;
		int onVacation = 0;
		
		if(wantedDate.isAfter(LocalDate.now()) || wantedDate.isEqual(LocalDate.now())) {
			for(Doctor doctor : allDoctors) {
				doctorsVacations.clear();
				doctorsCaresForDate.clear();
				doctorsOperationsForDate.clear();
				onVacation = 0;
				
				if(allVacations.size() > 0) {
					for(Vacation vacation : allVacations) {
						if(vacation.getUser().getId() == doctor.getUser().getId()) {
							doctorsVacations.add(vacation);
						}
					}
					
					
					for(Vacation vacation : doctorsVacations) {
						if(wantedDate.isAfter(vacation.getStartTime()) && wantedDate.isBefore(vacation.getEndTime())) {
							onVacation = 1;
						}
					}
				}
				
				
				
				
				if(onVacation == 0) {
					if(doctor.getClinic().getId() == clinicID) {
						if(doctor.getCareType().getId() == careTypeID) {
							if(allCares.size() > 0) {
								for(Care care : allCares) {	
									if(care.getDoctor().getId() == doctor.getId()) {
										startTime = care.getStartTime().toLocalDate();
										if((care.isApproved())&&(care.getPatient() != null) && (startTime.isEqual(wantedDate))) {
											System.out.println("nasao za taj dan");
											doctorsCaresForDate.add(care);
										}
									}
								}
							}
							if(allOperations.size() > 0) {
								for(Operation operation : allOperations) {
									if(operation.getDoctors().contains(doctor)) {
										startTime = operation.getStartTime().toLocalDate();
										if(startTime.isEqual(wantedDate)) {
											doctorsOperationsForDate.add(operation);
										}
									}
								}
							}
						}
						
						if(doctorsCaresForDate.size() + doctorsOperationsForDate.size() < 22) {
							System.out.println("nasao da je manje od dva : " + doctorsCaresForDate.size());
							if(!res.contains(doctor)) {
								if(doctor.getCareType().getId() == careTypeID) {
									res.add(doctor);
								}
							}
						}
					}
				}
				
			}
		} else {
			res = new ArrayList<Doctor>();
		}
				
		
		
		System.out.println("broj slobodnih doktora u klinici: " + res.size());
		
		return res;
	}
	
	
	public List<CareRequestDTO> listAvailableCaresForDoctor(Long careTypeID, Long doctorID, String date){
		List<CareRequestDTO> res = new ArrayList<CareRequestDTO>();
		List<Care> allCares = careRepository.findAll();
		List<Care> doctorsCares = new ArrayList<Care>();
		List<Care> doctorsCaresForDate = new ArrayList<Care>();
		List<Operation> allOperations = operationRepository.findAll();
		List<Operation> doctorsOperations = new ArrayList<Operation>();
		List<Operation> doctorsOperationsForDate = new ArrayList<Operation>();
		List<Vacation> allVacations = vacationRepository.findAll();
		List<Vacation> doctorsVacations = new ArrayList<Vacation>();
		LocalDate wantedDate = LocalDate.parse(date);
		LocalDateTime checkTime = null;
		LocalDate startTime = null;
		String checkTimeStr = "";
		
		int onVacation = 0;
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		
		List<String> times = new ArrayList<String>() {{
			add(" 07:00");
			add(" 07:30");
			add(" 08:00");
			add(" 08:30");
			add(" 09:00");
			add(" 09:30");
			add(" 10:00");
			add(" 10:30");
			add(" 11:00");
			add(" 11:30");
			add(" 12:00");
			add(" 12:30");
			add(" 13:00");
			add(" 13:30");
			add(" 14:00");
			add(" 14:30");
			add(" 15:00");
			add(" 15:30");
			add(" 16:00");
			add(" 16:30");
			add(" 17:00");
			add(" 17:30");
		}};
		
		
		if(wantedDate.isAfter(LocalDate.now()) || wantedDate.isEqual(LocalDate.now())) {
			if(allVacations.size() > 0) {
				for(Vacation vacation : allVacations) {
					if(vacation.getUser().getId() == doctorRepository.findOneByid(doctorID).getUser().getId()) {
						doctorsVacations.add(vacation);
					}
				}
				
				
				for(Vacation vacation : doctorsVacations) {
					if(wantedDate.isAfter(vacation.getStartTime()) && wantedDate.isBefore(vacation.getEndTime())) {
						onVacation = 1;
					}
				}
			}
			
			if(onVacation == 0) {	
				for(Care care : allCares) {
					if(care.isApproved() && care.getDoctor().getId() == doctorID && care.getPatient() != null) {
						doctorsCares.add(care);
					}
				}
				
				for(Care care : doctorsCares) {
					startTime = care.getStartTime().toLocalDate();
					if(wantedDate.equals(startTime)) {
						doctorsCaresForDate.add(care);
					}
				}
				
				if(allOperations.size() > 0) {
					for(Operation operation : allOperations) {
						if(operation.getDoctors().contains(doctorRepository.findOneByid(doctorID))) {
							doctorsOperations.add(operation);
						}
					}
					
					for(Operation operation : doctorsOperations) {
						startTime = operation.getStartTime().toLocalDate();
						if(wantedDate.equals(startTime)) {
							doctorsOperationsForDate.add(operation);
						}
					}
				}
				
				for(String time : times) {
					int ind = 0;
					checkTimeStr = date + time;
					checkTime = LocalDateTime.parse(checkTimeStr, formatter);
					
					for(Care care : doctorsCaresForDate) {
						if(care.getStartTime().equals(checkTime)) {
							System.out.println("NASAO ISTI: " + care.getStartTime() + " = " + checkTime);
							ind = 1;
						}
					}
					
					for(Operation operation : doctorsOperationsForDate) {
						if(operation.getStartTime().equals(checkTime)) {
							System.out.println("NASAO ISTI: " + operation.getStartTime() + " = " + checkTime);
							ind = 1;
						}
					}
					
					if(ind == 0) {
						res.add(new CareRequestDTO(checkTime, doctorRepository.findOneByid(doctorID), careTypeRepository.findOneByid(careTypeID))); 
					} 
					
				}
			
			}
		} else {
			res = new ArrayList<CareRequestDTO>();
		}
			

		
		return res;
	}
	
	
	public ArrayList<Doctor> listAvailableDoctors(Long clinicId,LocalDateTime date){
		ArrayList<Doctor> res = new ArrayList<Doctor>();
		List<Care> allCares = careRepository.findAll();
		List<Care> doctorsCares = new ArrayList<Care>();
		List<Doctor> allDoctors=doctorRepository.findAll();
		List<Doctor> clinicDoctors= new ArrayList<Doctor>();
		List<Operation> allOperations = operationRepository.findAll();
		List<Operation> doctorsOperations = new ArrayList<Operation>();
	
		List<Vacation> allVacations = vacationRepository.findAll();
		List<Vacation> doctorsVacations = new ArrayList<Vacation>();
	

		LocalDate wantedDate=date.toLocalDate();
		int onVacation = 0;
		int zauzet=0;
		int brojacDoktora=0;
		
		for(Doctor doctor: allDoctors) {
			
			if(doctor.getClinic().getId()==clinicId) {
				
			}
		}
		
		
		for(Doctor doctor : clinicDoctors) {
			
			zauzet=0;
			doctorsVacations.clear();
			onVacation=0;
			doctorsCares.clear();
			doctorsOperations.clear();
			
		
			for(Vacation vacation : allVacations) {
				if(vacation.getUser().getId() == doctor.getUser().getId()) {
					doctorsVacations.add(vacation);
				}
			}
			
			
			for(Vacation vacation : doctorsVacations) {
				if(wantedDate.isAfter(vacation.getStartTime()) && wantedDate.isBefore(vacation.getEndTime())) {
					onVacation = 1;
				}
			}
			
			if(onVacation == 0) {	
				for(Care care : allCares) {
					if(care.isApproved() && care.getDoctor().getId() ==doctor.getId() && care.getPatient() != null) {
						doctorsCares.add(care);
					}
				}
				
				for(Care care : doctorsCares) {
					
					if(care.getStartTime().isBefore(date) && care.getEndTime().isAfter(date)) {
						
						zauzet=1;
					}
					
					
				}
				
				
				for(Operation operation : allOperations) {
					if(operation.getDoctors().contains(doctor)) {
						doctorsOperations.add(operation);
					}
				}
				
				for(Operation operation : doctorsOperations) {

					
				if(operation.getStartTime().isBefore(date) && operation.getEndTime().isAfter(date)) {
						
						zauzet=1;
					}
					
				}
			
			if(zauzet==0) {
				if(brojacDoktora<3) {
				
				res.add(doctor);
				brojacDoktora++;
				}
				
			}
			
			
			}
		
		}
		
		return res;
	}
	

	public ArrayList<Doctor>doctorForClinic(){
		
		Long userId=checkRoleService.getUser().getId();
		List<ClinicAdministrator> clinicAdministrators=clinicAdminService.findAll();
		List<Doctor> allDoctors=doctorRepository.findAll();
		ArrayList<Doctor> doctorsForClinic=new ArrayList<Doctor>();
		
		
for(ClinicAdministrator admin: clinicAdministrators) {
			
			if(admin.getUser().getId()==userId) {
				
				
				for(Doctor doctor : allDoctors) {
					
					if(admin.getClinic().getId()==doctor.getClinic().getId()) {
						doctorsForClinic.add(doctor);
					}
					
				}
			}
		}
		
		
		
		
		return doctorsForClinic;
	}
	
	
	public Clinic getClinic() {
		for (Doctor d : findAll()) if (checkRoleService.getUser() != null && d.getUser().getId() == checkRoleService.getUser().getId()) return d.getClinic();
		return null;
	}

	public List<Doctor> findAllByClinic(Clinic clinic) {
		List<Doctor> result = new ArrayList<Doctor>();
		for (Doctor doc  : this.findAll()) {
			if (doc.getClinic() != null && doc.getClinic().getId() == clinic.getId()) {
				result.add(doc);
			}
		}
		return result;
	}

	public void save(Doctor doctor) {
		doctorRepository.save(doctor);
	}

}

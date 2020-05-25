package org.psw_isa.psw_isa_backend.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.psw_isa.psw_isa_backend.dtos.CareDTO;
import org.psw_isa.psw_isa_backend.dtos.EmailDTO;
import org.psw_isa.psw_isa_backend.models.Care;
import org.psw_isa.psw_isa_backend.models.Doctor;
import org.psw_isa.psw_isa_backend.models.Operation;
import org.psw_isa.psw_isa_backend.models.Patient;
import org.psw_isa.psw_isa_backend.models.User;
import org.psw_isa.psw_isa_backend.repository.DoctorRepository;
import org.psw_isa.psw_isa_backend.repository.OperationRepository;
import org.psw_isa.psw_isa_backend.repository.PatientRepository;
import org.psw_isa.psw_isa_backend.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OperationService {

	
	@Autowired
	OperationRepository operationRepository;
	
	@Autowired
	CheckRoleService checkRoleService;
	
	@Autowired
	RoomService  roomService;
	
	@Autowired
	DoctorRepository doctorRepository;
	
	@Autowired
	PatientRepository patientRepository;
	
	@Autowired
	SendEmailService sendEmailService;
	
	@Autowired
	RoomRepository roomRepository;
	
	public List<Operation> operationHistory(){
		User user = checkRoleService.getUser();
		List<Operation> res = new ArrayList<Operation>();
		List<Operation> patientsOperations = new ArrayList<Operation>();
		List<Operation> allOperations = operationRepository.findAll();
		List<Patient> allPatients = patientRepository.findAll();
		
		if(user == null) {
			System.out.println("NEMA USERA");
			res = null;
		} else {
			for(Patient patient : allPatients) {
				if(patient.getUser().getId() == user.getId()) {
					System.out.println("NASAO USERA");
					for(Operation operation : allOperations) {
						if(operation.getPatient() != null) {
							if(operation.getPatient().getId() == patient.getId()){
								System.out.println("NASAO MU JEDAN PREGLED");
								patientsOperations.add(operation);
							}
						}
					}
				}
			}
			
			for(Operation operation : patientsOperations) {
				if(operation.getEndTime().isBefore(LocalDateTime.now())) {
					System.out.println("PREGLED OD RANIJE");
					res.add(operation);
				}
			}
			
			
			Collections.sort(res, new Comparator<Operation>()  {
				  @Override
				  public int compare(Operation c1, Operation c2) {
				    return c1.getStartTime().compareTo(c2.getStartTime());
				  }
				});
			
		}
		
		
		
		return res;
		
	}
	
	public List<Operation> filterOperationHistory(String date){
		
		User user = checkRoleService.getUser();
		List<Operation> res = new ArrayList<Operation>();
		List<Operation> patientsOperationHistory = new ArrayList<Operation>();
		List<Operation> patientsOperations = new ArrayList<Operation>();
		List<Operation> allOperations = operationRepository.findAll();
		List<Patient> allPatients = patientRepository.findAll();
		
		LocalDate wantedDate = LocalDate.parse(date);
		LocalDate startTime = null;
		
		if(user == null) {
			System.out.println("NEMA USERA");
			res = null;
		} else {
			for(Patient patient : allPatients) {
				if(patient.getUser().getId() == user.getId()) {
					System.out.println("NASAO USERA");
					for(Operation operation : allOperations) {
						if(operation.getPatient() != null) {
							if(operation.getPatient().getId() == patient.getId()){
								System.out.println("NASAO MU JEDAN PREGLED");
								patientsOperations.add(operation);
							}
						}
					}
				}
			}
			
			for(Operation operation : patientsOperations) {
				if(operation.getEndTime().isBefore(LocalDateTime.now())) {
					System.out.println("PREGLED OD RANIJE");
					patientsOperationHistory.add(operation);
				}
			}
			
			for(Operation operation : patientsOperationHistory) {
				startTime = operation.getStartTime().toLocalDate();
				if(startTime.isEqual(wantedDate)) {
					System.out.println("NASAO TAJ DATUM");
					res.add(operation);
				}
				
			}
			
			Collections.sort(res, new Comparator<Operation>()  {
				  @Override
				  public int compare(Operation c1, Operation c2) {
				    return c1.getStartTime().compareTo(c2.getStartTime());
				  }
				});
			
		}
		
		
		
		
		return res;
	}
	
	
	
	
	
	
	public Operation save(Operation operation) {
		
		EmailDTO mail=new EmailDTO();
		
		for(Doctor doctor : operation.getDoctors()) {
			
			mail.setTo(doctor.getUser().getEmail());
			mail.setSubject("Dodeljena operacija");
			mail.setMessage("Dodeljena vam je operacija u sali"+ " "+ operation.getRoom().getTitle()+" u vreme:"+ operation.getStartTime() );
		}
		
		
		
		return operationRepository.save(operation);
	}
	
	
	public Operation saveAdmin(Operation operation) {
		
		if (operation.getRoom() == null) return null;
		
		EmailDTO mail=new EmailDTO();
		if (operation.getRoom().getSchedule() == null) {
			operation.getRoom().setSchedule(new ArrayList<>());
		}
		if (operation.getStartTime() == null) {
			operation.setStartTime(roomService.findNextTimeForRoom(operation.getRoom().getId()));
		}
		if (operation.getRoom() != null) {
			if (operation.getRoom().getSchedule() != null) {
				if (operation.getRoom().getSchedule().stream().filter(x -> x.equals(operation.getStartTime()))
					.count() == 0) {
						operation.getRoom().getSchedule().add(operation.getStartTime());
						roomRepository.save(operation.getRoom());
				}
				else {
					// we are trying to schedule already scheduled room
					return null;
				}

			}
		}
		for(Doctor doctor : operation.getDoctors()) {
			
			mail.setTo(doctor.getUser().getEmail());
			mail.setSubject("Dodeljena operacija");
			mail.setMessage("Dodeljena vam je operacija u sali"+ " "+ operation.getRoom().getTitle()+" u vreme:"+ operation.getStartTime() );
		}
		
		
		
		return operationRepository.save(operation);
	}
	
	public ArrayList<Operation> findAllOperationsForDateForDoctor(LocalDate date) {
		List<Operation> all = operationRepository.findAll();
		List<Operation> assigned = new ArrayList<>();
		ArrayList<Operation> vreme=new ArrayList<Operation>();
		
		Long userID = checkRoleService.getUser().getId();
		Long doctorID = null;
		
		for(Doctor doctor : doctorRepository.findAll()) {
			if(doctor.getUser().getId() == userID) {
				doctorID = doctor.getId();
				break;
			}
		}
		
		LocalDate startTime = null;
		for(Operation operation : all) {
			
			for(Doctor doc :operation.getDoctors()) {
			if(doc.getClinic().getId() == doctorID && (operation.getStartTime().isAfter(LocalDateTime.now()))) {
				startTime = operation.getStartTime().toLocalDate();
				
				if((operation.getPatient() != null) && (startTime.isEqual(date))) {
					assigned.add(operation);
				}
			}
		}
				
		}
			
		Collections.sort(assigned, new Comparator<Operation>()  {
			  @Override
			  public int compare(Operation c1, Operation c2) {
			    return c1.getStartTime().compareTo(c2.getStartTime());
			  }
			});
		
		for(Operation operation : assigned) {
			LocalDateTime zaConvert=operation.getStartTime();
			
			LocalTime konvertovan=zaConvert.toLocalTime();
			
			
			
			vreme.add(operation);
			
		}
		
		
		return vreme;
	}
}

package org.psw_isa.psw_isa_backend.service;

import org.psw_isa.psw_isa_backend.dtos.ClinicFilterDTO;
import org.psw_isa.psw_isa_backend.models.Care;
import org.psw_isa.psw_isa_backend.models.Clinic;
import org.psw_isa.psw_isa_backend.models.Doctor;
import org.psw_isa.psw_isa_backend.models.Operation;
import org.psw_isa.psw_isa_backend.models.Vacation;
import org.psw_isa.psw_isa_backend.repository.CareRepository;
import org.psw_isa.psw_isa_backend.repository.ClinicRepository;
import org.psw_isa.psw_isa_backend.repository.DoctorRepository;
import org.psw_isa.psw_isa_backend.repository.OperationRepository;
import org.psw_isa.psw_isa_backend.repository.VacationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.psw_isa.psw_isa_backend.service.CareService;
import org.psw_isa.psw_isa_backend.models.Care;
import org.psw_isa.psw_isa_backend.models.Room;
import org.psw_isa.psw_isa_backend.service.DoctorService;
import org.psw_isa.psw_isa_backend.service.ClinicRatingService;
import org.psw_isa.psw_isa_backend.service.DoctorRatingService;
import org.psw_isa.psw_isa_backend.models.Doctor;
import org.psw_isa.psw_isa_backend.models.Patient;
import org.psw_isa.psw_isa_backend.dtos.ClinicReportDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.TreeMap;

@Service
public class ClinicService {

	@Autowired
	ClinicRepository clinicRepository;

	@Autowired
	DoctorRepository doctorRepository;

	@Autowired
	CareRepository careRepository;

	@Autowired
	OperationRepository operationRepository;

	@Autowired
	VacationRepository vacationRepository;

	@Autowired
	CareService careService;

	@Autowired
	DoctorService doctorService;

	@Autowired
	DoctorRatingService doctorRatingService;

	@Autowired
	ClinicRatingService clinicRatingService;

	@Autowired
	RoomService roomService;

	@Autowired
	ClinicAdminService clinicAdminService;

	@Autowired
	PatientService patientService;

	public Clinic save(Clinic clinic) {
		clinic.setId(null);
		return clinicRepository.save(clinic);
	}

	public Clinic findOneByid(Long id) {
		return clinicRepository.findOneByid(id);
	}

	public List<Clinic> findAll() {
		if (clinicAdminService.getClinic() != null) {
			ArrayList<Clinic> result = new ArrayList<>();
			result.add(clinicRepository.findOneByid(clinicAdminService.getClinic().getId()));
			return result;
		}
		return clinicRepository.findAll();
	}

	/*
	 * public List<Clinic> findClinicsWithFreeDoctors(ClinicFilterDTO
	 * clinicFilterDTO){ List<Clinic> res = new ArrayList<>(); List<Doctor>
	 * allDoctors = doctorRepository.findAll(); List<Care> allCares =
	 * careRepository.findAll(); List<Operation> allOperations =
	 * operationRepository.findAll();
	 * 
	 * int noCare = 0;
	 * 
	 * for(Doctor doctor : allDoctors) { if(doctor.getCareType().getId() ==
	 * clinicFilterDTO.getType().getId()){ for(Care care : allCares) {
	 * if(care.getDoctor().getId() == doctor.getId()) {
	 * if((care.getStartTime().isBefore(clinicFilterDTO.getTime()) &&
	 * care.getEndTime().isBefore(clinicFilterDTO.getTime())) ||
	 * (care.getStartTime().isAfter(clinicFilterDTO.getTime()) &&
	 * care.getEndTime().isAfter(clinicFilterDTO.getTime()))) { noCare = 1;
	 * if(!res.contains(doctor.getClinic())) { res.add(doctor.getClinic()); } } } }
	 * if(noCare == 1) { for(Operation operation : allOperations) {
	 * if(operation.getDoctor().getId() == doctor.getId()) {
	 * if((operation.getStartTime().isBefore(clinicFilterDTO.getTime()) &&
	 * operation.getEndTime().isBefore(clinicFilterDTO.getTime())) ||
	 * (operation.getStartTime().isAfter(clinicFilterDTO.getTime()) &&
	 * operation.getEndTime().isAfter(clinicFilterDTO.getTime()))) {
	 * if(!res.contains(doctor.getClinic())) { res.add(doctor.getClinic()); } } } }
	 * }
	 * 
	 * }
	 * 
	 * } return res; }
	 * 
	 */

	public List<Clinic> findClinicsWithFreeDoctors(Long id, String date) {
		List<Clinic> res = new ArrayList<>();
		List<Clinic> allClinics = new ArrayList<Clinic>();
		allClinics = clinicRepository.findAll();
		List<Care> allCares = careRepository.findAll();
		List<Operation> allOperations = new ArrayList<Operation>();
		if (operationRepository.findAll() != null) {
			allOperations = operationRepository.findAll();
		}
		List<Doctor> allDoctors = doctorRepository.findAll();
		List<Care> doctorsCaresForDate = new ArrayList<>();
		List<Operation> doctorsOperationsForDate = new ArrayList<>();
		List<Vacation> allVacations = new ArrayList<Vacation>();
		if (vacationRepository.findAll() != null) {
			allVacations = vacationRepository.findAll();
		}
		List<Vacation> doctorsVacations = new ArrayList<Vacation>();
		LocalDate wantedDate = LocalDate.parse(date);
		LocalDate startTime = null;
		Boolean hasDoctor = false;
		int onVacation = 0;

		if (wantedDate.isAfter(LocalDate.now()) || wantedDate.isEqual(LocalDate.now())) {
			for (Doctor doctor : allDoctors) {
				onVacation = 0;
				doctorsVacations.clear();
				doctorsCaresForDate.clear();
				doctorsOperationsForDate.clear();

				if (allVacations.size() > 0) {
					for (Vacation vacation : allVacations) {
						if (vacation.getUser().getId() == doctor.getUser().getId()) {
							doctorsVacations.add(vacation);
						}
					}

					for (Vacation vacation : doctorsVacations) {
						if (wantedDate.isAfter(vacation.getStartTime()) && wantedDate.isBefore(vacation.getEndTime())) {
							onVacation = 1;
						}
					}
				}

				if (onVacation == 0) {
					if (doctor.getCareType().getId() == id) {
						if (allCares.size() > 0) {
							for (Care care : allCares) {
								if (care.getDoctor().getId() == doctor.getId()) {
									startTime = care.getStartTime().toLocalDate();
									if (care.isApproved() && (care.getPatient() != null)
											&& (startTime.isEqual(wantedDate))) {
										System.out.println("nasao za taj dan");
										doctorsCaresForDate.add(care);
									}
								}
							}
						}
						if (allOperations.size() > 0) {
							for (Operation operation : allOperations) {
								if (operation.getDoctors().contains(doctor)) {
									startTime = operation.getStartTime().toLocalDate();
									if (startTime.isEqual(wantedDate)) {
										doctorsOperationsForDate.add(operation);
									}
								}
							}
						}
					}
				}

				if (doctorsCaresForDate.size() + doctorsOperationsForDate.size() < 22 && onVacation == 0) {
					System.out.println("nasao da je manje od dva : " + doctorsCaresForDate.size());
					if (!res.contains(doctor.getClinic())) {
						// for(Clinic clinic : allClinics) {
						for (Doctor doctorClinic : allDoctors) {
							if (doctorClinic.getClinic().getId() == doctor.getClinic().getId()) {
								if (doctorClinic.getCareType().getId() == id) {
									System.out.println("dodaje ga");
									res.add(doctor.getClinic());
								}
							}
						}
						// }
						// System.out.println("dodaje ga");
						// res.add(doctor.getClinic());
					}
				}
			}
		} else {
			res = new ArrayList<Clinic>();
		}

		System.out.println("broj klinika: " + res.size());

		return res;
	}

	public List<Care> findCaresForClinic(Clinic clinic) {
		List<Care> cares = new ArrayList<Care>();
		for (Care care : careService.findAll()) {
			if (care.getRoom() != null && care.getRoom().getClinic() != null
					&& care.getRoom().getClinic().getId() == clinic.getId()) {
				cares.add(care);
			}
		}
		return cares;
	}

	public List<Patient> findPatientsForClinic(Clinic clinic) {
		List<Patient> res = new ArrayList<>();
		List<Patient> patients = patientService.findAll();
		List<Care> cares = findCaresForClinic(clinic);
		for (Patient patient : patientService.findAll()) {
			boolean found = false;
			for (Care care : cares) {
				if (care.getPatient() != null && patient.getId() == care.getPatient().getId())
					found = true;
			}
			if (found)
				res.add(patient);
		}
		return res;
	}

	public Double getRevenue(Clinic clinic, LocalDateTime start, LocalDateTime end) {
		Double sum = 0.0;
		for (Care care : this.findCaresForClinic(clinic)) {
			if (care.getStartTime().isAfter(start) && care.getEndTime().isBefore(end)) {
				sum += care.getPrice();
			}
		}
		return sum;
	}

	public ClinicReportDTO getReport(Clinic clinic, LocalDateTime start, LocalDateTime end) {
		int dayCount = (int) this.findCaresForClinic(clinic).stream()
				.filter(x -> x.getStartTime().isAfter(LocalDateTime.now().minusDays(1))).count();
		int weekCount = (int) this.findCaresForClinic(clinic).stream()
				.filter(x -> x.getStartTime().isAfter(LocalDateTime.now().minusDays(7))).count();
		int monthCount = (int) this.findCaresForClinic(clinic).stream()
				.filter(x -> x.getStartTime().isAfter(LocalDateTime.now().minusDays(30))).count();
		double averageRate = clinicRatingService.getClinicAverage(clinic);
		Map<Long, Double> doctorRatings = new TreeMap<Long, Double>();
		List<Doctor> doctors = doctorService.findAllByClinic(clinic);
		for (Doctor doctor : doctors) {
			doctorRatings.put(doctor.getId(), doctorRatingService.getDoctorAverage(doctor));
		}
		return new ClinicReportDTO(dayCount, weekCount, monthCount, averageRate, doctorRatings,
				this.getRevenue(clinic, start, end));

	}

	public List<Room> getRoomsForClinic(Clinic clinic) {
		List<Room> rooms = new ArrayList<>();
		for (Room room : roomService.findAll()) {
			if (room.getClinic().getId() == clinic.getId())
				rooms.add(room);
		}
		return rooms;
	}

}

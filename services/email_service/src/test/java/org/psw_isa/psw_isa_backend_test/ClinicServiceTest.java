package org.psw_isa.psw_isa_backend_test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.psw_isa.psw_isa_backend.BackendApplication;
import org.psw_isa.psw_isa_backend.models.Care;
import org.psw_isa.psw_isa_backend.models.CareType;
import org.psw_isa.psw_isa_backend.models.Clinic;
import org.psw_isa.psw_isa_backend.models.Doctor;
import org.psw_isa.psw_isa_backend.models.Operation;
import org.psw_isa.psw_isa_backend.models.User;
import org.psw_isa.psw_isa_backend.models.Vacation;
import org.psw_isa.psw_isa_backend.repository.ClinicRepository;
import org.psw_isa.psw_isa_backend.repository.CareRepository;
import org.psw_isa.psw_isa_backend.repository.CareTypeRepository;
import org.psw_isa.psw_isa_backend.repository.DoctorRepository;
import org.psw_isa.psw_isa_backend.repository.OperationRepository;
import org.psw_isa.psw_isa_backend.repository.VacationRepository;
import org.psw_isa.psw_isa_backend.service.ClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ContextConfiguration(classes=BackendApplication.class)
public class ClinicServiceTest {

	 @TestConfiguration
	    static class UserServiceImplTestContextConfiguration {
	  
	        @Bean
	        public ClinicService clinicService() {
	            return new ClinicService();
	        }
	    }
	 @Autowired
	 ClinicService clinicService;
	 
	 @Autowired
	 @MockBean
	 DoctorRepository doctorRepository;
	 
	 @Autowired
	 @MockBean
	 ClinicRepository clinicRepository;
	 

	 @Autowired
	 @MockBean
	 CareTypeRepository careTypeRepository;

	 @Autowired 
	 @MockBean
	 VacationRepository vacationRepository;

	 @Autowired
	 @MockBean
	 OperationRepository operationRepository;

	 @Autowired
	 @MockBean
	 CareRepository careRepository;

	 
	 private ArrayList<Doctor> doctors=new ArrayList<Doctor>();
	 
	 private ArrayList<Care> cares=new ArrayList<Care>();
	 
	 private ArrayList<Clinic> clinics=new ArrayList<Clinic>();
	 
	 private Clinic clinic=new Clinic();
	 
	 private Doctor doctor;
	 
	 private CareType careType;
	 
	
	 
	 	@Test 
	public void findClinicWithFreeDoctorsTest() {
		doctor = new Doctor();
		careType = new CareType();
		clinic = new Clinic();
		ArrayList<CareType> careTypes = new ArrayList<CareType>();
		ArrayList<Doctor> doctors= new ArrayList<Doctor>();
		ArrayList<Clinic> clinics = new ArrayList<Clinic>();
		ArrayList<Operation> operations = new ArrayList<Operation>();
		ArrayList<Care> cares = new ArrayList<Care>();
		ArrayList<Vacation> vacations = new ArrayList<Vacation>();
		careType.setId(1L);
		careTypes.add(careType);
		clinic.setId(1L);
		clinics.add(clinic);
		doctor.setId(1L);
		doctor.setCareType(careType);
		doctor.setClinic(clinic);	
		doctors.add(doctor);	
		when(careTypeRepository.findAll()).thenReturn(careTypes);
		when(doctorRepository.findAll()).thenReturn(doctors);
		when(operationRepository.findAll()).thenReturn(operations);
		when(vacationRepository.findAll()).thenReturn(vacations);
		when(careRepository.findAll()).thenReturn(cares);
		when(clinicRepository.findAll()).thenReturn(clinics);
		assertEquals(1,clinicService.findClinicsWithFreeDoctors(1L, "2020-06-09").size());

	}

	
}

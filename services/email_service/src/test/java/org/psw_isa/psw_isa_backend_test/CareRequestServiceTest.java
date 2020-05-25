package org.psw_isa.psw_isa_backend_test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.psw_isa.psw_isa_backend.BackendApplication;
import org.psw_isa.psw_isa_backend.dtos.CareRequestDTO;
import org.psw_isa.psw_isa_backend.models.Care;
import org.psw_isa.psw_isa_backend.models.CareType;
import org.psw_isa.psw_isa_backend.models.Clinic;
import org.psw_isa.psw_isa_backend.models.ClinicAdministrator;
import org.psw_isa.psw_isa_backend.models.Doctor;
import org.psw_isa.psw_isa_backend.models.Operation;
import org.psw_isa.psw_isa_backend.models.Patient;
import org.psw_isa.psw_isa_backend.models.User;
import org.psw_isa.psw_isa_backend.models.Vacation;
import org.psw_isa.psw_isa_backend.repository.ClinicRepository;
import org.psw_isa.psw_isa_backend.repository.CareRepository;
import org.psw_isa.psw_isa_backend.repository.CareRequestRepository;
import org.psw_isa.psw_isa_backend.repository.CareTypeRepository;
import org.psw_isa.psw_isa_backend.repository.ClinicAdminRepository;
import org.psw_isa.psw_isa_backend.repository.DoctorRepository;
import org.psw_isa.psw_isa_backend.repository.OperationRepository;
import org.psw_isa.psw_isa_backend.repository.PatientRepository;
import org.psw_isa.psw_isa_backend.repository.VacationRepository;
import org.psw_isa.psw_isa_backend.service.CareRequestService;
import org.psw_isa.psw_isa_backend.service.CheckRoleService;
import org.psw_isa.psw_isa_backend.service.ClinicService;
import org.psw_isa.psw_isa_backend.service.DoctorService;
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
public class CareRequestServiceTest {

	 @TestConfiguration
	    static class UserServiceImplTestContextConfiguration {
	  
	        @Bean
	        public CareRequestService careRequestService() {
	            return new CareRequestService();
	        }
	    }


   @Autowired
   CareRequestService careRequestService;


   @Autowired
   @MockBean
   CheckRoleService checkRoleService;

   @Autowired
   @MockBean
   PatientRepository patientRepository;

   @Autowired
   @MockBean
   ClinicAdminRepository clinicAdminRepository;

   @Autowired
   @MockBean
   CareRequestRepository careRequestRepository;

	 
	 private ArrayList<Patient> patients=new ArrayList<Patient>();
	 
    private ArrayList<ClinicAdministrator> clinicAdministrators=new ArrayList<>();
    
    private User user;
	 
	 private Clinic clinic=new Clinic();
	 
	 private Doctor doctor;
	 
     private CareType careType;
     
     private Patient patient;
     
     private CareRequestDTO careRequestDTO;
	


	 
	@Test 
	public void createRequestTest() {
        careRequestDTO = new CareRequestDTO();
        user=new User();
        user.setId(1L);
        patient=new Patient();
        patient.setUser(user);
        patients.add(patient);
        when(checkRoleService.getUser()).thenReturn(user);
        when(patientRepository.findAll()).thenReturn(patients);
        when(clinicAdminRepository.findAll()).thenReturn(clinicAdministrators);
        assertEquals(1,careRequestService.createRequest(careRequestDTO));
    
	}

	
}

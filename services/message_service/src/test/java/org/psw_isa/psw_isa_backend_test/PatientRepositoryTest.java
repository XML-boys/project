package org.psw_isa.psw_isa_backend_test;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.psw_isa.psw_isa_backend.BackendApplication;
import org.psw_isa.psw_isa_backend.models.Patient;
import org.psw_isa.psw_isa_backend.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
@DataJpaTest
@ContextConfiguration(classes=BackendApplication.class)
public class PatientRepositoryTest {

	@Autowired
    private TestEntityManager entityManager;
	
	 @Autowired
	 private PatientRepository patientRepository;
	 
	 private Long id=Long.valueOf(1);
	 
	 private Patient patient;

	 @BeforeEach
	    public void setUp() {
		// given
		patient = new Patient();
		patient.setInsuranceID("1234567891234");
		entityManager.persist(patient);
		id = entityManager.getId(patient, Long.class);
		entityManager.flush();
	    }

	    @AfterEach
	    public void tearDown() {
			entityManager.flush();
	    }
	    
	    @Test 
	    public void testFindAll() {

		assertEquals( 1,patientRepository.findAll().size());
		entityManager.remove(patient);
	
	    }
	    
	    @Test
	    public void testfindOneByIdNotNull() {
	    	
	    	assertNotNull(patientRepository.findOneByid(id));
			entityManager.remove(patient);
	    }
	    
	    
	    
	    @Test
	    public void testfindOneById() {
	    	
	    	assertEquals(id,patientRepository.findOneByid(id).getId());
			entityManager.remove(patient);
	    }
	    
	    @Test
	    public void testsave() {
	    	patientRepository.save(new Patient());
	    	assertEquals( 2,patientRepository.findAll().size());
			entityManager.remove(patient);
	    }
	    
	    @Test
	    public void testDelete() {
	    	patientRepository.deleteAll();
	    	assertEquals( 0,patientRepository.findAll().size());
	    }
	   
	    
	    
	    
}

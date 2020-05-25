package org.psw_isa.psw_isa_backend_test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.psw_isa.psw_isa_backend.BackendApplication;
import org.psw_isa.psw_isa_backend.models.Care;
import org.psw_isa.psw_isa_backend.models.Patient;
import org.psw_isa.psw_isa_backend.repository.CareRepository;
import org.psw_isa.psw_isa_backend.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@ContextConfiguration(classes=BackendApplication.class)
public class CareRepositoryTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private CareRepository careRepository;
	

	private Long id =Long.valueOf(1);

	private Long idp=Long.valueOf(1);

	private Care care;

	private Patient patient;
	
	@BeforeEach
	public void setUp() {
		
		care = new Care();
		patient=new Patient();
		entityManager.persist(care);
		entityManager.persist(patient);
		id = entityManager.getId(care, Long.class);
		idp = entityManager.getId(patient, Long.class);
		entityManager.flush();


	
	
	}

	@AfterEach
	public void tearDown() {
		entityManager.flush();
	}
	
	
	@Test
	public void testfindOneById() {
		
		assertEquals(id, careRepository.findOneByid(id).getId());
		entityManager.remove(care);
		entityManager.remove(patient);
	}

	
	
	@Test
	public void testCarePatientUpdate() {
		assertEquals(1, careRepository.carePatientUpdate(idp, id));
		entityManager.remove(care);
		entityManager.remove(patient);
		
	}


}

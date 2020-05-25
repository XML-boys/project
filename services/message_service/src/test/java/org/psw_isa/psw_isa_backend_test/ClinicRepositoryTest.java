package org.psw_isa.psw_isa_backend_test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.psw_isa.psw_isa_backend.BackendApplication;
import org.psw_isa.psw_isa_backend.models.Clinic;
import org.psw_isa.psw_isa_backend.models.Doctor;
import org.psw_isa.psw_isa_backend.repository.ClinicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@ContextConfiguration(classes=BackendApplication.class)
public class ClinicRepositoryTest {

	@Autowired
	private TestEntityManager entityManager;
	
	
	@Autowired
	private ClinicRepository clinicRepository;
	

	private Long id =Long.valueOf(1);
	
	@BeforeEach
	public void setUp() {
		Clinic clinic=new Clinic();
		entityManager.merge(clinic);
		
		entityManager.flush();
	}

	@AfterEach
	public void tearDown() {
		entityManager.clear();
	}
	
	/*
	@Test
	public void testFindOneById() {
		
		assertEquals(id,clinicRepository.findOneByid(id).getId() );
		
	}
	*/
	@Test
	public void testFindAll() {
		
		assertEquals(1,clinicRepository.findAll().size());
		
	}
}

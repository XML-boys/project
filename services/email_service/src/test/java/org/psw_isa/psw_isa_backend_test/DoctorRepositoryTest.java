package org.psw_isa.psw_isa_backend_test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

import javax.persistence.Id;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.psw_isa.psw_isa_backend.BackendApplication;
import org.psw_isa.psw_isa_backend.models.Care;
import org.psw_isa.psw_isa_backend.models.Doctor;
import org.psw_isa.psw_isa_backend.models.Patient;

import org.psw_isa.psw_isa_backend.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@ContextConfiguration(classes=BackendApplication.class)
public class DoctorRepositoryTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private DoctorRepository doctorRepository;
	
	@Id
	private Long id =Long.valueOf(1);
	
	@BeforeEach
	public void setUp() {
		Doctor doctor=new Doctor();
		entityManager.merge(doctor);
		
		entityManager.flush();
	}

	@AfterEach
	public void tearDown() {
		entityManager.clear();
		entityManager.flush();
	}
	
	
	
	/*
	@Test
	public void testFindAll() {
		
		assertEquals(1,doctorRepository.findAll().size());
		
		for(Doctor doctor : doctorRepository.findAll()) {
			System.out.println("ID                 JEEEEEEEEE                  "
					+ ""+doctor.getId()+"                                           ");
			System.out.println(doctor.getId().getClass());
		}
		
	}
	*/
	
	@Test
	public void testFindOneById() {
		assertEquals(id,doctorRepository.findOneByid(1L).getId());
	}
	
}

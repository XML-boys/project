package org.psw_isa.psw_isa_backend_test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.psw_isa.psw_isa_backend.BackendApplication;
import org.psw_isa.psw_isa_backend.models.CareType;
import org.psw_isa.psw_isa_backend.models.Vacation;
import org.psw_isa.psw_isa_backend.repository.CareTypeRepository;
import org.psw_isa.psw_isa_backend.repository.VacationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import javax.persistence.LockModeType;

import org.springframework.transaction.annotation.Transactional;


@ExtendWith(SpringExtension.class)
@DataJpaTest
@ContextConfiguration(classes=BackendApplication.class)
public class VacationRepositoryTest {

	
	@Autowired
	private TestEntityManager entityManager;

	
	private Long id = Long.valueOf(1);
	
	@Autowired
	private VacationRepository vacationRepository;

	
	private Vacation vacation;

	@BeforeEach
	public void setUp() {
		vacation= new Vacation();
		entityManager.persist(vacation);
		id = entityManager.getId(vacation, Long.class);
		entityManager.flush();
	}

	@AfterEach
	public void tearDown() {
		entityManager.flush();
	}

	@Test
	public void testFindAll() {

		assertEquals(1, vacationRepository.findAll().size());
		entityManager.remove(vacation);
	}
	
	@Test
	public void testFindOneById() {
		
		assertEquals(id,vacationRepository.findOneByid(id).getId() );
		entityManager.remove(vacation);
	}
	
}

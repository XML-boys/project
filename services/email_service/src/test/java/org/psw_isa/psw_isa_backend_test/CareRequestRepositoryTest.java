package org.psw_isa.psw_isa_backend_test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.psw_isa.psw_isa_backend.BackendApplication;
import org.psw_isa.psw_isa_backend.models.CareRequest;
import org.psw_isa.psw_isa_backend.repository.CareRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@ContextConfiguration(classes=BackendApplication.class)
public class CareRequestRepositoryTest {

	@Autowired
	private TestEntityManager entityManager;

	private Long id = Long.valueOf(1);

	@Autowired
	private CareRequestRepository careRequestRepository;

	private CareRequest careRequest;

	@BeforeEach
	public void setUp() {
		careRequest=new CareRequest();
		entityManager.persist(careRequest);
		id = entityManager.getId(careRequest, Long.class);
		entityManager.flush();
	}

	@AfterEach
	public void tearDown() {
		entityManager.flush();
	}

	@Test
	public void testFindAll() {

		assertEquals(1, careRequestRepository.findAll().size());
		entityManager.remove(careRequest);

	}
}

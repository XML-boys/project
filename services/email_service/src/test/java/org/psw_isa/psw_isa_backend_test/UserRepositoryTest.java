package org.psw_isa.psw_isa_backend_test;

import org.psw_isa.psw_isa_backend.repository.UserRepository;
import org.psw_isa.psw_isa_backend.BackendApplication;
import org.psw_isa.psw_isa_backend.models.User;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.beans.factory.annotation.*;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.junit.jupiter.api.extension.ExtendWith;



import static java.time.Duration.ofMillis;
import static java.time.Duration.ofMinutes;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@ContextConfiguration(classes=BackendApplication.class)
public class UserRepositoryTest {
 
    @Autowired
    private TestEntityManager entityManager;
 
    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    public void setUp() {
	// given
	User user = new User();
	entityManager.merge(user);
	entityManager.flush();
    }

    @AfterEach
    public void tearDown() {
    	entityManager.clear();
    }
 
    @Test 
    public void testFindAll() {

	assertEquals(userRepository.findAll().size(), 1);
    }
 
}

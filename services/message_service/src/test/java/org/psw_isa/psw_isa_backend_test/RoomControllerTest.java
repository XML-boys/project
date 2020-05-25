package org.psw_isa.psw_isa_backend.test;


import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("classpath:application-integrationtest.properties")
public class RoomControllerTest {

  


    private MediaType contentType = new MediaType(
            MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype());

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private DataSource dataSource;

    @PostConstruct
    public void setUp() {
        this.mockMvc = MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .build();
    }

    @AfterEach
    public void rollback() {
        Resource resource = new ClassPathResource("data-h2.sql");
        ResourceDatabasePopulator resourceDatabasePopulator = new ResourceDatabasePopulator(resource);
        resourceDatabasePopulator.execute(dataSource);
    }


    @Test
    public void roomTest() throws Exception {
        mockMvc.perform(get("/room/"))
        .andExpect(status().isOk());

    }


    @Test
    public void updateTest() throws Exception {
        mockMvc.perform(get("/room/"+1L))
        .andExpect(status().isOk());
        
        
        // (value="/{id}", consumes = "application/json"
       
    }
  


    @Test
    public void findNextTimeForRoomTest() throws Exception {
        mockMvc.perform(get("/room/"+1L+"/next"))
        .andExpect(status().isOk());
    	// value="/{roomId}/next"
      
    }
}
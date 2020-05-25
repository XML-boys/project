package org.psw_isa.psw_isa_backend_test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.psw_isa.psw_isa_backend.BackendApplication;
import org.psw_isa.psw_isa_backend.dtos.RoomDTO;
import org.psw_isa.psw_isa_backend.models.Care;
import org.psw_isa.psw_isa_backend.models.Clinic;
import org.psw_isa.psw_isa_backend.models.Doctor;
import org.psw_isa.psw_isa_backend.models.Patient;
import org.psw_isa.psw_isa_backend.models.Room;
import org.psw_isa.psw_isa_backend.models.User;
import org.psw_isa.psw_isa_backend.repository.CareRepository;
import org.psw_isa.psw_isa_backend.repository.RoomRepository;
import org.psw_isa.psw_isa_backend.repository.UserRepository;
import org.psw_isa.psw_isa_backend.service.CareService;
import org.psw_isa.psw_isa_backend.service.CheckRoleService;
import org.psw_isa.psw_isa_backend.service.RoomService;
import org.psw_isa.psw_isa_backend.service.UserService;
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
public class RoomServiceTest {

    @TestConfiguration
    static class UserServiceImplTestContextConfiguration {
  
        @Bean
        public RoomService roomService() {
            return new RoomService();
        }
    }

    @Autowired
    private RoomService roomService;


    @Autowired
    @MockBean
    private RoomRepository roomRepository;
   
    @Autowired
    @MockBean
    private CheckRoleService checkRoleService;
    
    @Autowired
    @MockBean
    private CareRepository careRepository;
    
    @Autowired
    @MockBean
    private UserRepository userRepository;

    private Room room;
    
    private ArrayList<Care> cares=new ArrayList<Care>();

    private ArrayList<Room> rooms=new ArrayList<Room>();

    private RoomDTO roomDTO;

    private Clinic clinic;
	 
    private Doctor doctor;
    
    private Care care;

    private Patient patient;
      

    @Test
    public void findAllUnassignedAndUpcomingForClinicTest(){
    	
    	
    }

    @Test
	public void updateTest() {

        
        roomDTO=new RoomDTO();
        roomDTO.setId(1L);
        room = new Room();
        room.setId(1L);
        
        when(roomRepository.findOneByid(any(Long.class))).thenReturn(room);
        assertEquals(1L, roomService.update(roomDTO).getId());
	}

    public void findAllInClinicTest() {
        room = new Room();
        clinic = new Clinic();
        clinic.setId(1L);
        room.setId(1L);
        room.setClinic(clinic);
        when(roomRepository.findAll()).thenReturn(rooms);
        assertEquals(1, roomService.findAllInClinic(clinic).size());
    }
    
    @Test
    public void findNextTimeForRoomTest() {
        room=new Room();
        room.setId(1L);
        String checkTimeStr = LocalDate.now().toString() + " 07:00";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime checkTime = LocalDateTime.parse(checkTimeStr, formatter);

        when(roomRepository.findOneByid(any(Long.class))).thenReturn(room);
        assertEquals(checkTime,roomService.findNextTimeForRoom(1L));
	
	}

}

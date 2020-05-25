package org.psw_isa.psw_isa_backend.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import java.util.stream.Collectors;


import org.psw_isa.psw_isa_backend.models.Room;
import org.psw_isa.psw_isa_backend.models.Clinic;
import org.psw_isa.psw_isa_backend.dtos.RoomDTO;
import org.psw_isa.psw_isa_backend.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import java.time.LocalDate;

import org.psw_isa.psw_isa_backend.Logger;

import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RoomService {
	
	@Autowired
	RoomRepository roomRepository;
	
	@Autowired
	ClinicAdminService clinicAdminService;
	
	public List<Room> findAll() {
		if (clinicAdminService.getClinic() != null) 
		{
			return roomRepository.findAll().stream().filter(room -> room.getClinic().getId() == clinicAdminService.getClinic().getId()).collect(Collectors.toList());
		}
		else return roomRepository.findAll();
	}
	
	public List<Room> findAllInClinic(Clinic clinic) {
		List<Room> res = new ArrayList<>();
		List<Room> rooms = this.findAll();
		for (Room r : rooms)
		{
			if (r.getClinic() != null) 
			{
				if(r.getClinic().getId() == clinic.getId()) 
				{
					res.add(r);
				}
			}
		}
		return res;
	}
	
	
	public Room findOneByid(Long id) {
		return roomRepository.findOneByid(id);
	}
	public Room save(RoomDTO room) {
		return roomRepository.save(new Room(room.getTitle(), clinicAdminService.getClinic(), room.getCapacity()));
	}
	public Room update(RoomDTO room) {
		Room newRoom = findOneByid(room.getId());
		newRoom.setTitle(room.getTitle());
		newRoom.setCapacity(room.getCapacity());
		roomRepository.save(newRoom);
		return newRoom;
	}

	public Long delete(Long id) {
		roomRepository.delete(findOneByid(id));
		return id;
	}

	public LocalDateTime findNextTimeForRoom(Long roomId) {
		List<String> times = new ArrayList<String>() {{
			add(" 07:00");
			add(" 07:30");
			add(" 08:00");
			add(" 08:30");
			add(" 09:00");
			add(" 09:30");
			add(" 10:00");
			add(" 10:30");
			add(" 11:00");
			add(" 11:30");
			add(" 12:00");
			add(" 12:30");
			add(" 13:00");
			add(" 13:30");
			add(" 14:00");
			add(" 14:30");
			add(" 15:00");
			add(" 15:30");
			add(" 16:00");
			add(" 16:30");
			add(" 17:00");
			add(" 17:30");
		}};
		Logger.getInstance().debug("Creating formatter....");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDate date = LocalDate.now();
		Logger.getInstance().debug("Got new date " + date.toString());
		boolean found = false;
		Room room = findOneByid(roomId);
		if (room == null) {
			Logger.getInstance().error("Room not found");
			return null;
		}
		while (!found) {
			for(String time : times) {
				String checkTimeStr = date.toString() + time;
				LocalDateTime checkTime = LocalDateTime.parse(checkTimeStr, formatter);
				Logger.getInstance().debug("Checking if room has scheduled time: " + checkTime.toString());
				if (room.getSchedule() == null) {
					Logger.getInstance().debug("Schedule not initialized, creating one and saving");
					room.setSchedule(new ArrayList<LocalDateTime>());
					roomRepository.save(room);
				}
				if (!room.getSchedule().contains(checkTime)) {					
					found = true;
					Logger.getInstance().debug("FOUND");
					return checkTime;
				}
			}
			if (!found) {
				Logger.getInstance().debug("NOT FOUND: advancing one day");
				date = date.plusDays(1);
			}
		}
		return null;
	}

}

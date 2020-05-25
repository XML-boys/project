package org.psw_isa.psw_isa_backend.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.psw_isa.psw_isa_backend.models.Vacation;
import org.psw_isa.psw_isa_backend.repository.VacationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class VacationService {

	
	@Autowired
	VacationRepository vacationRepository;

	@Autowired
	CheckRoleService checkRoleService;
	
	public Vacation findOneByid(Long id) {
		return vacationRepository.findOneByid(id);
	}
	
	public List<Vacation> findAll() {
		return vacationRepository.findAll();
	}

	public Long save(Vacation vacation) 
	{
		vacation.setId(null);
		vacation.setUser(checkRoleService.getUser());
		Vacation v = vacationRepository.save(vacation);
		return v.getId();
	}
	public Long update(Long id, Vacation vacation) 
	{
		vacation.setId(id);
		Vacation that = findOneByid(id);
		System.out.println(that);
		if (that.getProcessed() != null && that.getProcessed() == true) return id;
		Vacation v = vacationRepository.save(vacation);
		return v.getId();
	}
	
public Long findVacation(String date) {
		
		
		List<Vacation> allVacations = vacationRepository.findAll();
		List<Vacation> vacations = new ArrayList<Vacation>();
		LocalDate wantedDate = LocalDate.parse(date);
		
		Long onVacation =  (long) 0;
		
		for(Vacation vacation : allVacations) {
			if(vacation.getUser().getId() == checkRoleService.getUser().getId()) {
				vacations.add(vacation);
			}
		}
		
		
		for(Vacation vacation : vacations) {
			if((wantedDate.isEqual(vacation.getStartTime())) || (wantedDate.isAfter(vacation.getStartTime()) && wantedDate.isBefore(vacation.getEndTime()))) {
				onVacation =(long) 1;
			}
		}
		
		return onVacation;
	}
}

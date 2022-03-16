package com.mentbot.mainProject.security.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mentbot.mainProject.dto.ScheduleDto;
import com.mentbot.mainProject.dto.UserDto;
import com.mentbot.mainProject.models.DocSpecialities;
import com.mentbot.mainProject.models.Doctor;
import com.mentbot.mainProject.models.Schedule;
import com.mentbot.mainProject.models.Specialization;
import com.mentbot.mainProject.models.User;
import com.mentbot.mainProject.repo.DoctorRepo;
import com.mentbot.mainProject.repo.ScheduleRepo;
import com.mentbot.mainProject.repo.UserRepo;

@Service
public class ScheduleDetailsServiceImpl implements ScheduleService{

	@Autowired
	ScheduleRepo scheduleRepo;
	
	@Autowired
	DoctorRepo doctorrepo;
	

	@Override
	public void addSchedules(ScheduleDto scheduleDto) {
		Schedule schedules=new Schedule();
		Doctor doctor = doctorrepo.getById(scheduleDto.getDoctor().getDoctor_id());
		schedules.setDoctor(doctor);
		schedules.setStarttime(scheduleDto.getStarttime());
		schedules.setEndtime(scheduleDto.getEndtime());
		schedules.setDayavailable(scheduleDto.getDayavailable());
		scheduleRepo.save(schedules);
		
	}
	
// @Override
//	public List<ScheduleDto> getScheduleDetailsByDoctorId(Long doctorId ) {
//		List<ScheduleDto> scheduleDtos = new ArrayList<>();
////		scheduleRepo.findAllById(doctorId).forEach(schedules -> {
////			ScheduleDto sdto = new ScheduleDto(schedules);
////			scheduleDtos.add(sdto);
////		});
//		
//		return scheduleDtos;
//	}

	

	
	
	

}


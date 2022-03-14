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
import com.mentbot.mainProject.models.User;
import com.mentbot.mainProject.repo.ScheduleRepo;
import com.mentbot.mainProject.repo.UserRepo;

@Service
public class ScheduleDetailsServiceImpl implements ScheduleService{

	@Autowired
	ScheduleRepo scheduleRepo;
	
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


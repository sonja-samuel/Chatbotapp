package com.mentbot.mainProject.security.services;

import java.util.List;

import com.mentbot.mainProject.dto.DoctorDto;
import com.mentbot.mainProject.dto.ScheduleDto;

public interface ScheduleService {
	
//	public List<ScheduleDto> getScheduleDetailsByDoctorId(Long doctorId);
	
	public void addSchedules(ScheduleDto scheduleDto);

}

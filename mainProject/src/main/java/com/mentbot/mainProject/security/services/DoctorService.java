package com.mentbot.mainProject.security.services;

import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

import com.mentbot.mainProject.dto.AppointmentDto;
import com.mentbot.mainProject.dto.DoctorDto;
import com.mentbot.mainProject.dto.ScheduleDto;
import com.mentbot.mainProject.dto.SpecializationDto;
import com.mentbot.mainProject.dto.UserDto;

public interface DoctorService {
	
	public void addDetails(DoctorDto doctordto,int userId);
//	public void addSpecialities(DocSpecialitiesDto docspecdto);
	
//	List<AppointmentDto> getAppointmentsByDoctorId(int doctorId);
}

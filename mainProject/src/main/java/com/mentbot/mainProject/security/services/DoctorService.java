package com.mentbot.mainProject.security.services;

import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

import com.mentbot.mainProject.dto.AppointmentDto;
import com.mentbot.mainProject.dto.DocSpecialitiesDto;
import com.mentbot.mainProject.dto.DoctorDto;
import com.mentbot.mainProject.dto.ScheduleDto;

public interface DoctorService {
	
	public void addDetails(DoctorDto doctordto);
	public void addSpecialities(DocSpecialitiesDto docspecdto);
	
//	List<AppointmentDto> getAppointmentsByDoctorId(int doctorId);
}

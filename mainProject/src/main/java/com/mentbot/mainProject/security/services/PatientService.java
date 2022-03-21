package com.mentbot.mainProject.security.services;

import com.mentbot.mainProject.dto.PatientDto;
import com.mentbot.mainProject.dto.ScheduleDto;

public interface PatientService {
	
	public void addDetailsForPatient(PatientDto patientDto,int userId);

}

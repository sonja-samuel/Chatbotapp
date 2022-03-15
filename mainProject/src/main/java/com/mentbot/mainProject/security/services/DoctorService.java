package com.mentbot.mainProject.security.services;

import com.mentbot.mainProject.dto.DocSpecialitiesDto;
import com.mentbot.mainProject.dto.DoctorDto;

public interface DoctorService {
	
	public void addDetails(DoctorDto doctordto);
	public void addSpecialities(DocSpecialitiesDto docspecdto);
	

}

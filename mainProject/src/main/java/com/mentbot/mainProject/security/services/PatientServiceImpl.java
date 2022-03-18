package com.mentbot.mainProject.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mentbot.mainProject.dto.PatientDto;
import com.mentbot.mainProject.models.Doctor;
import com.mentbot.mainProject.models.Patient;
import com.mentbot.mainProject.repo.PatientRepo;
import com.mentbot.mainProject.repo.ScheduleRepo;

@Service
public class PatientServiceImpl implements PatientService{

	@Autowired
	PatientRepo patientRepo;
	
	@Override
	public void addDetailsForPatient(PatientDto patientDto) {
		Patient patient=new Patient();
	    patient.setGender(patientDto.getGender());
	    patient.setBloodgroup(patientDto.getBloodgroup());
		
		patientRepo.save(patient);
		
	}

}

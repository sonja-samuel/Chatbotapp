package com.mentbot.mainProject.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mentbot.mainProject.dto.PatientDto;
import com.mentbot.mainProject.models.Doctor;
import com.mentbot.mainProject.models.Patient;
import com.mentbot.mainProject.models.User;
import com.mentbot.mainProject.repo.PatientRepo;
import com.mentbot.mainProject.repo.ScheduleRepo;
import com.mentbot.mainProject.repo.UserRepo;

@Service
public class PatientServiceImpl implements PatientService{

	@Autowired
	PatientRepo patientRepo;
	@Autowired
	UserRepo userRepo;
	
	@Override
	public void addDetailsForPatient(PatientDto patientDto,int userId) {
		Patient patient=new Patient();
		User user=userRepo.getById(Long.valueOf(userId));
		patient.setUser(user);
	    patient.setGender(patientDto.getGender());
	    patient.setBloodgroup(patientDto.getBloodgroup());
		
		patientRepo.save(patient);
		
	}

}

package com.mentbot.mainProject.security.services;

import org.springframework.stereotype.Service;

import com.mentbot.mainProject.dto.PatientDto;
import com.mentbot.mainProject.models.Patient;
import com.mentbot.mainProject.models.User;
import com.mentbot.mainProject.repo.PatientRepo;
import com.mentbot.mainProject.repo.UserRepo;

import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {

	private PatientRepo patientRepo;
	private UserRepo userRepo;

	public PatientServiceImpl(PatientRepo patientRepo, UserRepo userRepo) {
		this.patientRepo = patientRepo;
		this.userRepo = userRepo;
	}

	@Override
	public void addDetailsForPatient(PatientDto patientDto, int userId) {
		Patient patient = new Patient();
		User user = userRepo.getById(Long.valueOf(userId));
		patient.setUser(user);
		patient.setGender(patientDto.getGender());
		patient.setBloodgroup(patientDto.getBloodGroup());
		patientRepo.save(patient);

	}

	@Override
	public Patient getPatientByUser(User user) {
		Optional<Patient> patient = patientRepo.findByUser(user);
		return patient.orElse(null);
	}
}

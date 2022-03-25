package com.mentbot.mainProject.security.services;

import com.mentbot.mainProject.dto.PatientDto;
import com.mentbot.mainProject.models.Patient;
import com.mentbot.mainProject.models.User;

public interface PatientService {

	void addDetailsForPatient(PatientDto patientDto, int userId);

	Patient getPatientByUser(User user);

}

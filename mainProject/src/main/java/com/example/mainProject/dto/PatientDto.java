package com.example.mainProject.dto;

import javax.persistence.OneToOne;

import com.example.mainProject.models.Patient;
import com.example.mainProject.models.User;

public class PatientDto {
	
    private long patient_id;
    private UserDto user;
	public PatientDto(Patient patient) {
		
		this.patient_id = patient.getId();
		this.user = new UserDto(patient.getUser());
	}
	public long getId() {
		return patient_id;
	}
	public void setId(long patient_id) {
		this.patient_id = patient_id;
	}
	public UserDto getUser() {
		return user;
	}
	public void setUser(UserDto user) {
		this.user = user;
	}
	

}

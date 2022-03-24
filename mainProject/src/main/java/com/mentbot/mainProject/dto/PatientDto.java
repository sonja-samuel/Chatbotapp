package com.mentbot.mainProject.dto;

import javax.persistence.OneToOne;

import com.mentbot.mainProject.models.Patient;
import com.mentbot.mainProject.models.User;

public class PatientDto {

	private long patientId;
	private UserDto user;
	private String gender;
	private String bloodGroup;

	public PatientDto() {

	}

	public PatientDto(Patient patient) {

		this.patientId = patient.getPatient_id();
		this.gender = patient.getGender();
		this.bloodGroup = patient.getBloodgroup();
	}

	public long getPatientId() {
		return patientId;
	}

	public void setPatientId(long patientId) {
		this.patientId = patientId;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public UserDto getUser() {
		return user;
	}

	public void setUser(UserDto user) {
		this.user = user;
	}

}

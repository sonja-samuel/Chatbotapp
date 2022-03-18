package com.mentbot.mainProject.dto;

import javax.persistence.OneToOne;

import com.mentbot.mainProject.models.Patient;
import com.mentbot.mainProject.models.User;

public class PatientDto {
	
    private long patient_id;
    private UserDto user;
    private String gender;
	private String bloodgroup;
	public long getPatient_id() {
		return patient_id;
	}
	public void setPatient_id(long patient_id) {
		this.patient_id = patient_id;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBloodgroup() {
		return bloodgroup;
	}
	public void setBloodgroup(String bloodgroup) {
		this.bloodgroup = bloodgroup;
	}
	public PatientDto(Patient patient) {
		
		this.patient_id = patient.getPatient_id();
		this.user = new UserDto(patient.getUser());
		this.gender=patient.getGender();
		this.bloodgroup=patient.getBloodgroup();
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

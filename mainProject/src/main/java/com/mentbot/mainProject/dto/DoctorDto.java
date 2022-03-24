package com.mentbot.mainProject.dto;

import java.time.format.DateTimeFormatter;
import java.util.Set;

import com.mentbot.mainProject.models.Doctor;

public class DoctorDto {

	private Long doctor_id;
	private String professionalStatement;
	private String practicingDate;
	private UserDto user;
	private Set<Integer> specializationIds;

	public DoctorDto(Doctor doctor) {

		this.doctor_id = doctor.getDoctor_id();
		this.professionalStatement = doctor.getProf_statement();
		this.practicingDate = doctor.getPracticing_date().format(DateTimeFormatter.ofPattern("ddMMyyyy"));
		this.user = new UserDto(doctor.getUser());

	}

	public DoctorDto() {
	}

	public Long getDoctor_id() {
		return doctor_id;
	}

	public void setDoctor_id(Long doctor_id) {
		this.doctor_id = doctor_id;
	}

	public long getId() {
		return doctor_id;
	}

	public void setId(long id) {
		this.doctor_id = doctor_id;
	}

	public String getProfessionalStatement() {
		return professionalStatement;
	}

	public void setProfessionalStatement(String professionalStatement) {
		this.professionalStatement = professionalStatement;
	}

	public String getPracticingDate() {
		return practicingDate;
	}

	public void setPracticingDate(String practicingDate) {
		this.practicingDate = practicingDate;
	}

	public UserDto getUser() {
		return user;
	}

	public void setUser(UserDto user) {
		this.user = user;
	}

	public Set<Integer> getSpecializationIds() {
		return specializationIds;
	}

	public void setSpecializationIds(Set<Integer> specializationIds) {
		this.specializationIds = specializationIds;
	}

}

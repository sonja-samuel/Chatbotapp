package com.mentbot.mainProject.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Set;

import com.mentbot.mainProject.models.DocSpecialities;
import com.mentbot.mainProject.models.Doctor;
import com.mentbot.mainProject.models.Specialization;
import com.mentbot.mainProject.models.User;

public class DoctorDto {

private Long doctor_id;
	
private String prof_statement;
private String practicing_date;
private UserDto user;
private Set<Integer> specializationIds;

    


	
	
	

	public DoctorDto(Doctor doctor) {
	
		this.doctor_id =doctor.getDoctor_id();
		this.prof_statement =doctor.getProf_statement();
//		this.practicing_date = doctor.getPracticing_date();
     	this.user = new UserDto(doctor.getUser());
//        this.docspecialization=doctor.getDocspecialities();
	}

	public Long getDoctor_id() {
		return doctor_id;
	}

	public void setDoctor_id(Long doctor_id) {
		this.doctor_id = doctor_id;
	}
	public String getProf_statement() {
		return prof_statement;
	}

	public void setProf_statement(String prof_statement) {
		this.prof_statement = prof_statement;
	}


	public String getPracticing_date() {
		return practicing_date;
	}
	public void setPracticing_date(String practicing_date) {
		this.practicing_date = practicing_date;
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

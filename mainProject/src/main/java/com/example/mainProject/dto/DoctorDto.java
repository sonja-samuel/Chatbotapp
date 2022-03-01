package com.example.mainProject.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import com.example.mainProject.models.DocSpecialities;
import com.example.mainProject.models.Doctor;
import com.example.mainProject.models.Specialization;
import com.example.mainProject.models.User;

public class DoctorDto {

private Long doctor_id;
	
	private String prof_statement;
	private LocalDateTime practicing_date;
	private UserDto user;
	private Set<DocSpecialities> docspecialization;
    


	public Long getDoctor_id() {
		return doctor_id;
	}

	public void setDoctor_id(Long doctor_id) {
		this.doctor_id = doctor_id;
	}

	
	

	public DoctorDto(Doctor doctor) {
	
		this.doctor_id =doctor.getDoctor_id();
		this.prof_statement =doctor.getProf_statement();
		this.practicing_date = doctor.getPracticing_date();
     	this.user = new UserDto(doctor.getUser());
        this.docspecialization=doctor.getDocspecialities();
	}

	public Set<DocSpecialities> getDocspecialization() {
		return docspecialization;
	}

	public void setDocspecialization(Set<DocSpecialities> docspecialization) {
		this.docspecialization = docspecialization;
	}

	public long getId() {
		return doctor_id;
	}

	public void setId(long id) {
		this.doctor_id = doctor_id;
	}

	public String getProf_statement() {
		return prof_statement;
	}

	public void setProf_statement(String prof_statement) {
		this.prof_statement = prof_statement;
	}

	public LocalDateTime getPracticing_date() {
		return practicing_date;
	}

	public void setPracticing_date(LocalDateTime practicing_date) {
		this.practicing_date = practicing_date;
	}

	public UserDto getUser() {
		return user;
	}

	public void setUser(UserDto user) {
		this.user = user;
	}

	

	
}

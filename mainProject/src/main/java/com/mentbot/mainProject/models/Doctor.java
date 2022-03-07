package com.mentbot.mainProject.models;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name="Doctor_table")
public class Doctor {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long doctor_id;
	
	private String prof_statement;
	private Date practicing_date;
	
	@OneToOne
	private User user;
	
	@OneToMany
	private Set<DocSpecialities> docspecialities;

	
	
	public Set<DocSpecialities> getDocspecialities() {
		return docspecialities;
	}


	public void setDocspecialities(Set<DocSpecialities> docspecialities) {
		this.docspecialities = docspecialities;
	}


	


	public Long getDoctor_id() {
		return doctor_id;
	}


	public void setDoctor_id(Long doctor_id) {
		this.doctor_id = doctor_id;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public String getProf_statement() {
		return prof_statement;
	}


	public void setProf_statement(String prof_statement) {
		this.prof_statement = prof_statement;
	}


	public Date getPracticing_date() {
		return practicing_date;
	}


	public void setPracticing_date(Date practicing_date) {
		this.practicing_date = practicing_date;
	}



}

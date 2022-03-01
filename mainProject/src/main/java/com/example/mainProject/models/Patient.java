package com.example.mainProject.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Patient_table")
public class Patient {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long patient_id;
	
	@OneToOne
	private User user;


	public long getPatient_id() {
		return patient_id;
	}

	public void setPatient_id(long patient_id) {
		this.patient_id = patient_id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public long getId() {
		return patient_id;
	}

	public void setId(long id) {
		this.patient_id = patient_id;
	}


}

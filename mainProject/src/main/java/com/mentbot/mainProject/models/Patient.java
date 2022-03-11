package com.mentbot.mainProject.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
	
	@OneToMany
	private List<Appointment> appointments;


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

	public List<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}
	


}

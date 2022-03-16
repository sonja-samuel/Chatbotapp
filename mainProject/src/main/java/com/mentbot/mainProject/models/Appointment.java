package com.mentbot.mainProject.models;

import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="appointment")
public class Appointment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long appointment_id;
	
	private LocalTime starttime;
	private LocalTime endtime;
	
	@Enumerated(EnumType.STRING)
	@Column(length=20)
	private AppointmentStatus status;
	
    private LocalDateTime appointment_takentime;
    
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="doctor_id")
	
    private Doctor doctor;
    
    @ManyToOne(fetch = FetchType.LAZY)
   	@JoinColumn(name="patient_id")
    private Patient patient;

	

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Long getAppointment_id() {
		return appointment_id;
	}

	public void setAppointment_id(Long appointment_id) {
		this.appointment_id = appointment_id;
	}

	public LocalTime getStarttime() {
		return starttime;
	}

	public void setStarttime(LocalTime starttime) {
		this.starttime = starttime;
	}

	public LocalTime getEndtime() {
		return endtime;
	}

	public void setEndtime(LocalTime endtime) {
		this.endtime = endtime;
	}

	public AppointmentStatus getStatus() {
		return status;
	}

	public void setStatus(AppointmentStatus status) {
		this.status = status;
	}

	public LocalDateTime getAppointment_takentime() {
		return appointment_takentime;
	}

	public void setAppointment_takentime(LocalDateTime appointment_takentime) {
		this.appointment_takentime = appointment_takentime;
	}
    
    

}

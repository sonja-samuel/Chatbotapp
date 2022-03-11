package com.mentbot.mainProject.dto;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Set;

import com.mentbot.mainProject.models.Appointment;
import com.mentbot.mainProject.models.DocSpecialities;
import com.mentbot.mainProject.models.Doctor;
import com.mentbot.mainProject.models.Specialization;
import com.mentbot.mainProject.models.User;

public class AppointmentDto {

	private Long appointmentId;
	
	private LocalTime start_time;
	private LocalTime end_time;
	private Long doctorId;
	private Long patientId;
	private String status;
	
   	

	public AppointmentDto(Appointment appointment) {
		super();
		this.appointmentId = appointment.getAppointment_id();
		this.start_time = appointment.getStarttime();
		this.end_time = appointment.getEndtime();
	}

	public Long getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(Long appointmentId) {
		this.appointmentId = appointmentId;
	}

	public LocalTime getStart_time() {
		return start_time;
	}

	public void setStart_time(LocalTime start_time) {
		this.start_time = start_time;
	}
	
	public LocalTime getEnd_time() {
		return end_time;
	}

	public void setEnd_time(LocalTime end_time) {
		this.end_time = end_time;
	}
	
	public Long getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}	
}

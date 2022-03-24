package com.mentbot.mainProject.dto;

import com.mentbot.mainProject.models.Appointment;

import java.time.LocalDate;
import java.time.LocalTime;

public class AppointmentDto {

	private Long appointmentId;
	private LocalTime startTime;
	private LocalTime endTime;
	private Long doctorId;
	private Long patientId;
	private String status;
	private String comments;
	private LocalDate appointmentDate;
	private Long specialityId;
    private String patientName;

	public AppointmentDto(Appointment appointment) {

		this.appointmentId = appointment.getAppointment_id();
		this.startTime = appointment.getStarttime();
		this.endTime = appointment.getEndtime();
		this.appointmentDate = appointment.getAppointmentDate();
		this.doctorId = appointment.getDoctor().getDoctor_id();
		this.patientId = appointment.getPatient().getPatient_id();
		this.status = appointment.getStatus().name();
		this.comments = appointment.getComments();
		this.specialityId = appointment.getSpecId();
	}

	public LocalDate getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(LocalDate appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public Long getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(Long appointmentId) {
		this.appointmentId = appointmentId;
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	public LocalTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}

	public Long getSpecialityId() {
		return specialityId;
	}

	public void setSpecialityId(Long specialityId) {
		this.specialityId = specialityId;
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

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

}

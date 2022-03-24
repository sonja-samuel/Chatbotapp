package com.mentbot.mainProject.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mentbot.mainProject.models.AppointmentStatus;

import java.time.LocalDate;
import java.time.LocalTime;

public class AppointmentDetailDto {
	private long appointmentId;

	@JsonFormat(pattern = "HH:mm")
	private LocalTime startTime;

	@JsonFormat(pattern = "HH:mm")
	private LocalTime endTime;

	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate appointmentDate;

	private String speciality;

	private String doctorName;

	private AppointmentStatus status;

	public AppointmentDetailDto(long appointmentId, LocalTime startTime, LocalTime endTime, LocalDate appointmentDate,
			String speciality, String doctorName, AppointmentStatus status) {
		this.appointmentId = appointmentId;
		this.startTime = startTime;
		this.endTime = endTime;
		this.appointmentDate = appointmentDate;
		this.speciality = speciality;
		this.doctorName = doctorName;
		this.status = status;
	}

	public long getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(long appointmentId) {
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

	public LocalDate getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(LocalDate appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public AppointmentStatus getStatus() {
		return status;
	}

	public void setStatus(AppointmentStatus status) {
		this.status = status;
	}
}

package com.mentbot.mainProject.security.services;

import com.mentbot.mainProject.dto.AppointmentDetailDto;
import com.mentbot.mainProject.dto.AvailableSlotsDto;
import com.mentbot.mainProject.dto.DoctorNameDto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface AppointmentService {

	void addAppointment(LocalDate appointmentDate, int specId, int doctorId, int patientId, LocalTime startTime,
			LocalTime endTime);

	List<AvailableSlotsDto> getAvailableSlots(int doctorId, LocalDate date);

	List<DoctorNameDto> getDoctors(int specialityId);

	List<AppointmentDetailDto> getAppointmentsForPatient(int patientId);
}

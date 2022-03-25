package com.mentbot.mainProject.security.services;

import com.mentbot.mainProject.dto.AppointmentDto;
import com.mentbot.mainProject.dto.DoctorDto;
import com.mentbot.mainProject.models.Doctor;
import com.mentbot.mainProject.models.User;

import java.util.List;

public interface DoctorService {

	void addDetails(DoctorDto doctordto, int userId);

	List<AppointmentDto> getAppointmentsByDoctorId(int doctorId);

	void confirmAppointment(int appointmentId, String status);

	Doctor getDoctorByUser(User user);

}

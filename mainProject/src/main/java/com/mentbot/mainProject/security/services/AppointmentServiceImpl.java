package com.mentbot.mainProject.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mentbot.mainProject.dto.AppointmentDto;
import com.mentbot.mainProject.dto.DoctorDto;
import com.mentbot.mainProject.models.Doctor;
import com.mentbot.mainProject.repo.AppointmentRepo;
import com.mentbot.mainProject.repo.DoctorRepo;

@Service
public class AppointmentServiceImpl implements AppointmentService {
	
	@Autowired
	AppointmentRepo appointmentRepo;
	


	@Override
	public void addAppointment(AppointmentDto appointmentDto) {
		
		
	}

	
}

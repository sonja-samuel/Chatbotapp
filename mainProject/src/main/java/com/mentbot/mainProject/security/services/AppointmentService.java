package com.mentbot.mainProject.security.services;

import com.mentbot.mainProject.dto.AppointmentDto;
import com.mentbot.mainProject.dto.AvailableSlotsDto;

import java.time.LocalDate;
import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

public interface AppointmentService {

    void addAppointment(LocalDate appointmentDate,int specId,int doctorId, int patientId,int startTime,int endTime);

    List<AvailableSlotsDto> getAvailableSlots(int doctorId, LocalDate date);
}

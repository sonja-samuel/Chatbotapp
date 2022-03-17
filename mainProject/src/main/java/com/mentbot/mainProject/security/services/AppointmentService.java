package com.mentbot.mainProject.security.services;

import com.mentbot.mainProject.dto.AppointmentDto;
import com.mentbot.mainProject.dto.AvailableSlotsDto;

import java.time.LocalDate;
import java.util.List;

public interface AppointmentService {

    void addAppointment(AppointmentDto appointmentDto);

    List<AvailableSlotsDto> getAvailableSlots(int doctorId, LocalDate date);
}

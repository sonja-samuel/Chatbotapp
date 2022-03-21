package com.mentbot.mainProject.security.services;

import com.mentbot.mainProject.dto.AppointmentDto;
import com.mentbot.mainProject.dto.DoctorDto;

import java.util.List;

public interface DoctorService {

    public void addDetails(DoctorDto doctordto, int userId);
//	public void addSpecialities(DocSpecialitiesDto docspecdto);

    List<AppointmentDto> getAppointmentsByDoctorId(int doctorId);

    void confirmAppointment(int appointmentId, String status);

}

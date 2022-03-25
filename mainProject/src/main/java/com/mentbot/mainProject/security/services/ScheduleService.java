package com.mentbot.mainProject.security.services;

import com.mentbot.mainProject.dto.ScheduleDto;
import com.mentbot.mainProject.models.Doctor;

public interface ScheduleService {

	void addSchedules(ScheduleDto scheduleDto, Doctor doctor);

}

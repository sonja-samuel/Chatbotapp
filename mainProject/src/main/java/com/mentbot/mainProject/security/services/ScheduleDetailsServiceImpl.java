package com.mentbot.mainProject.security.services;

import com.mentbot.mainProject.dto.ScheduleDto;
import com.mentbot.mainProject.models.Doctor;
import com.mentbot.mainProject.models.Schedule;
import com.mentbot.mainProject.repo.DoctorRepo;
import com.mentbot.mainProject.repo.ScheduleRepo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Service;

@Service
public class ScheduleDetailsServiceImpl implements ScheduleService {

	private ScheduleRepo scheduleRepo;
	private DoctorRepo doctorRepo;

	public ScheduleDetailsServiceImpl(ScheduleRepo scheduleRepo, DoctorRepo doctorRepo) {
		this.scheduleRepo = scheduleRepo;
		this.doctorRepo = doctorRepo;
	}

	@Override
	public void addSchedules(ScheduleDto scheduleDto, Doctor doctor) {
		Schedule schedule = new Schedule();
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("H:mm");
		LocalTime startTime = LocalTime.parse(scheduleDto.getStartTime(), dateTimeFormatter);
		LocalTime endTime = LocalTime.parse(scheduleDto.getEndTime(), dateTimeFormatter);
		schedule.setDoctor(doctor);
		schedule.setStartTime(startTime);
		schedule.setEndTime(endTime);
		schedule.setAvailableDays(scheduleDto.getAvailableDays());
		scheduleRepo.save(schedule);

	}

}

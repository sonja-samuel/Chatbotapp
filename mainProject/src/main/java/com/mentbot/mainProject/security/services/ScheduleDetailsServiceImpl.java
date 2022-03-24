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

    private DoctorRepo doctorrepo;

    public ScheduleDetailsServiceImpl(ScheduleRepo scheduleRepo, DoctorRepo doctorrepo) {
        this.scheduleRepo = scheduleRepo;
        this.doctorrepo = doctorrepo;
    }


    @Override
    public void addSchedules(ScheduleDto scheduleDto, Doctor doctor) {
        Schedule schedule = new Schedule();
      
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("H:mm");
        LocalTime startTime = LocalTime.parse(scheduleDto.getStartTime(), dtf);
        LocalTime endTime = LocalTime.parse(scheduleDto.getEndTime(), dtf);
//        Doctor doctor=doctorrepo.getById(Long.valueOf(doctorId));
//        Doctor doctor = doctorrepo.getById(scheduleDto.getDoctor().getDoctor_id());
        schedule.setDoctor(doctor);
        schedule.setStartTime(startTime);
        schedule.setEndTime(endTime);
        schedule.setAvailableDays(scheduleDto.getAvailableDays());
        scheduleRepo.save(schedule);

    }

// @Override
//	public List<ScheduleDto> getScheduleDetailsByDoctorId(Long doctorId ) {
//		List<ScheduleDto> scheduleDtos = new ArrayList<>();
////		scheduleRepo.findAllById(doctorId).forEach(schedules -> {
////			ScheduleDto sdto = new ScheduleDto(schedules);
////			scheduleDtos.add(sdto);
////		});
//		
//		return scheduleDtos;
//	}


}


package com.mentbot.mainProject.security.services;

import com.mentbot.mainProject.dto.ScheduleDto;
import com.mentbot.mainProject.models.Doctor;
import com.mentbot.mainProject.models.Schedule;
import com.mentbot.mainProject.repo.DoctorRepo;
import com.mentbot.mainProject.repo.ScheduleRepo;
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
    public void addSchedules(ScheduleDto scheduleDto,int doctorId) {
        Schedule schedule = new Schedule();
//        Doctor doctor = doctorrepo.getById(scheduleDto.getDoctor().getDoctor_id());
        Doctor doctor=doctorrepo.getById(Long.valueOf(doctorId));
        schedule.setDoctor(doctor);
        schedule.setStartTime(scheduleDto.getStartTime());
        schedule.setEndTime(scheduleDto.getEndTime());
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


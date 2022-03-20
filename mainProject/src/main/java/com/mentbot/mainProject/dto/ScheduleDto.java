package com.mentbot.mainProject.dto;

import com.mentbot.mainProject.models.Doctor;
import com.mentbot.mainProject.models.Schedule;

import javax.persistence.OneToOne;
import java.time.LocalTime;
import java.util.List;

public class ScheduleDto {
    private Long scheduleId;
    private LocalTime startTime;
    private LocalTime endTime;
    private  String availableDays;
    @OneToOne
    private Doctor doctor;

    public ScheduleDto(Schedule schedule) {

        this.scheduleId = schedule.getSchedule_id();
        this.startTime = schedule.getStartTime();
        this.endTime = schedule.getEndTime();
        this.availableDays = schedule.getAvailableDays();

    }

    public ScheduleDto() {
		
	}

	public Long getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Long scheduleId) {
        this.scheduleId = scheduleId;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public String getAvailableDays() {
        return availableDays;
    }

    public void setAvailableDays(String availableDays) {
        this.availableDays = availableDays;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }


}

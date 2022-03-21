package com.mentbot.mainProject.dto;

import com.mentbot.mainProject.models.Doctor;
import com.mentbot.mainProject.models.Schedule;

import javax.persistence.OneToOne;
import java.time.LocalTime;
import java.util.List;

public class ScheduleDto {
    private Long scheduleId;
    private String startTime;
    private String endTime;
    private  String availableDays;
    private int doctorId;
   
    public ScheduleDto(Schedule schedule) {

        this.scheduleId = schedule.getSchedule_id();
//      this.startTime = schedule.getStartTime();
//      this.endTime = schedule.getEndTime();
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


    public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getAvailableDays() {
        return availableDays;
    }

    public void setAvailableDays(String availableDays) {
        this.availableDays = availableDays;
    }

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

}

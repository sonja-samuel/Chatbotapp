package com.mentbot.mainProject.dto;

import java.time.LocalTime;
import java.util.Date;

import javax.persistence.OneToOne;

import com.mentbot.mainProject.models.Doctor;
import com.mentbot.mainProject.models.Schedule;

public class ScheduleDto {
private Long schedule_id;

	
	private LocalTime starttime;
	private LocalTime endtime;
	private Date dayavailable;
	
	@OneToOne
	private Doctor doctor;
	
	
	private boolean isavailable;
	public ScheduleDto(Schedule schedule) {
	
		this.schedule_id = schedule.getSchedule_id();
		this.starttime = schedule.getStarttime();
		this.endtime = schedule.getEndtime();
		this.dayavailable = schedule.getDayavailable();
		
	}
	
	public Long getSchedule_id() {
		return schedule_id;
	}
	public void setSchedule_id(Long schedule_id) {
		this.schedule_id = schedule_id;
	}
	public LocalTime getStarttime() {
		return starttime;
	}
	public void setStarttime(LocalTime starttime) {
		this.starttime = starttime;
	}
	public LocalTime getEndtime() {
		return endtime;
	}
	public void setEndtime(LocalTime endtime) {
		this.endtime = endtime;
	}
	public boolean isIsavailable() {
		return isavailable;
	}
	public void setIsavailable(boolean isavailable) {
		this.isavailable = isavailable;
	}
	public Date getDayavailable() {
		return dayavailable;
	}
	public void setDayavailable(Date dayavailable) {
		this.dayavailable = dayavailable;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	

}

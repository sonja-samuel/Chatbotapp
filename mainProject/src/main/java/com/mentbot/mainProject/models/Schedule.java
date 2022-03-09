package com.mentbot.mainProject.models;

import java.time.LocalTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="schedule")
public class Schedule {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long schedule_id;

	
	private LocalTime starttime;
	private LocalTime endtime;
	
	private boolean isavailable;
	private Date dayavailable;
	private String reasonofavailability;
	
	
	
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
	
	public String getReasonofavailability() {
		return reasonofavailability;
	}
	
	public void setReasonofavailability(String reasonofavailability) {
		this.reasonofavailability = reasonofavailability;
	}
	
	

}

package com.mentbot.mainProject.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mentbot.mainProject.models.Appointment;
import com.mentbot.mainProject.models.Doctor;

@Repository
public interface AppointmentRepo extends JpaRepository<Appointment,Long>{
	

}

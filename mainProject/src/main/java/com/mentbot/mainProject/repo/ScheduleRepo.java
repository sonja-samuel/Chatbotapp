package com.mentbot.mainProject.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mentbot.mainProject.models.Doctor;
import com.mentbot.mainProject.models.Schedule;
import java.util.Optional;

@Repository
public interface ScheduleRepo extends JpaRepository<Schedule,Long>{
	
//		Optional<Schedule> findAllById(Long doctorId);
}

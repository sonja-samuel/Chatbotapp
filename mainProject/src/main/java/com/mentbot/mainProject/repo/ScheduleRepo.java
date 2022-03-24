package com.mentbot.mainProject.repo;

import com.mentbot.mainProject.models.Doctor;
import com.mentbot.mainProject.models.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ScheduleRepo extends JpaRepository<Schedule, Long> {

	Optional<Schedule> findByDoctor(Doctor doctor);
}

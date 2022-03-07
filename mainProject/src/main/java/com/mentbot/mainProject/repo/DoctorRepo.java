package com.mentbot.mainProject.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mentbot.mainProject.models.Doctor;

@Repository
public interface DoctorRepo extends JpaRepository<Doctor,Long>{
	

}

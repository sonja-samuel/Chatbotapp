package com.example.mainProject.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.mainProject.models.Doctor;

@Repository
public interface DoctorRepo extends JpaRepository<Doctor,Long>{
	

}

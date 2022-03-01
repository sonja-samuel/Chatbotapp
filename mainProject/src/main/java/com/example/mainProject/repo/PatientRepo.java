package com.example.mainProject.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.mainProject.models.Patient;

@Repository
public interface PatientRepo extends JpaRepository<Patient,Long> {

}

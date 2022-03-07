package com.mentbot.mainProject.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mentbot.mainProject.models.Patient;

@Repository
public interface PatientRepo extends JpaRepository<Patient,Long> {

}

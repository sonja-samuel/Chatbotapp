package com.mentbot.mainProject.repo;

import com.mentbot.mainProject.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mentbot.mainProject.models.Patient;

import java.util.Optional;

@Repository
public interface PatientRepo extends JpaRepository<Patient,Long> {

    Optional<Patient> findByUser(User user);

}

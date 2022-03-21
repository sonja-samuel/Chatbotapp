package com.mentbot.mainProject.repo;

import com.mentbot.mainProject.models.Specialization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mentbot.mainProject.models.Doctor;

import java.util.List;

@Repository
public interface DoctorRepo extends JpaRepository<Doctor, Long> {

    List<Doctor> findAllBySpecialization(Specialization specialization);
}

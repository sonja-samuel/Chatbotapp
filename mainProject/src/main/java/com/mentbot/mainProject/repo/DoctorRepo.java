package com.mentbot.mainProject.repo;

import com.mentbot.mainProject.models.Doctor;
import com.mentbot.mainProject.models.Specialization;
import com.mentbot.mainProject.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DoctorRepo extends JpaRepository<Doctor, Long> {

	List<Doctor> findAllBySpecialization(Specialization specialization);

	Optional<Doctor> findByUser(User user);
}

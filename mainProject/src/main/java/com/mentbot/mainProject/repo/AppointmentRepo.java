package com.mentbot.mainProject.repo;

import com.mentbot.mainProject.models.Appointment;
import com.mentbot.mainProject.models.Doctor;
import com.mentbot.mainProject.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AppointmentRepo extends JpaRepository<Appointment, Long> {

	List<Appointment> findAllByDoctorAndAppointmentDate(Doctor doctor, LocalDate appointmentDate);

	List<Appointment> findAllByDoctor(Doctor doctor);

	List<Appointment> findAllByPatient(Patient patient);
}

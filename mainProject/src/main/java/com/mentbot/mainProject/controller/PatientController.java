package com.mentbot.mainProject.controller;

import com.mentbot.mainProject.dto.AppointmentDetailDto;
import com.mentbot.mainProject.dto.PatientDto;
import com.mentbot.mainProject.models.Patient;
import com.mentbot.mainProject.models.User;
import com.mentbot.mainProject.security.services.AppointmentService;
import com.mentbot.mainProject.security.services.PatientService;
import com.mentbot.mainProject.security.services.UserService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@PreAuthorize("hasRole('ROLE_PATIENT')")
@RequestMapping("/patient")
public class PatientController {

	private PatientService patientService;

	private AppointmentService appointmentService;

	private UserService userService;

	public PatientController(PatientService patientService, AppointmentService appointmentService,
			UserService userService) {
		this.patientService = patientService;
		this.appointmentService = appointmentService;
		this.userService = userService;
	}

	@PostMapping("/addDetails")
	public ResponseEntity<?> addDetailsForPatient(@RequestBody PatientDto patientDto) {
		User user = userService.getUser();
		if (user == null) {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
		patientService.addDetailsForPatient(patientDto, user.getId().intValue());
		return new ResponseEntity<>(HttpStatus.OK);

	}

	@GetMapping("/getAppointments")
	public List<AppointmentDetailDto> getAppointments() {
		User user = userService.getUser();
		if (user == null) {
			return new ArrayList();
		}
		Patient patient = patientService.getPatientByUser(user);
		if (patient == null) {
			return new ArrayList();
		}
		return appointmentService.getAppointmentsForPatient((int) patient.getPatient_id());
	}
}

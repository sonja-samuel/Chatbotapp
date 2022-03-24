package com.mentbot.mainProject.controller;

import com.mentbot.mainProject.dto.AppointmentDto;
import com.mentbot.mainProject.dto.DoctorDto;
import com.mentbot.mainProject.dto.ScheduleDto;
import com.mentbot.mainProject.models.Doctor;
import com.mentbot.mainProject.models.User;
import com.mentbot.mainProject.security.services.DoctorService;
import com.mentbot.mainProject.security.services.ScheduleService;
import com.mentbot.mainProject.security.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@PreAuthorize("hasRole('ROLE_DOCTOR')")
@RequestMapping("/doctors")
public class DoctorController {

	private DoctorService doctorService;

	private ScheduleService scheduleService;

	private UserService userService;

	public DoctorController(DoctorService doctorService, ScheduleService scheduleService, UserService userService) {
		this.doctorService = doctorService;
		this.scheduleService = scheduleService;
		this.userService = userService;
	}

	@PostMapping("/addDetails")
	public ResponseEntity<?> addDetailsOfDoctor(@RequestBody DoctorDto doctordto) {
		User user = userService.getUser();
		if (user == null) {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
		doctorService.addDetails(doctordto, user.getId().intValue());
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("/addSchedule")
	public ResponseEntity<?> addScheduleForDoctor(@RequestBody ScheduleDto scheduleDto) {

		User user = userService.getUser();
		if (user == null) {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}

		Doctor doctor = doctorService.getDoctorByUser(user);
		if (doctor == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		scheduleService.addSchedules(scheduleDto, doctor);
		return new ResponseEntity<>(HttpStatus.OK);

	}

	@GetMapping("/getAppointments")
	public List<AppointmentDto> getAppointments() {

		User user = userService.getUser();
		if (user == null) {
			return new ArrayList();
		}

		Doctor doctor = doctorService.getDoctorByUser(user);
		if (doctor == null) {
			return new ArrayList();
		}
		return doctorService.getAppointmentsByDoctorId(doctor.getDoctor_id().intValue());
	}

	@PostMapping("/confirmAppointment")
	public ResponseEntity<?> confirmAppointment(@RequestParam int appointmentId, String status) {

		doctorService.confirmAppointment(appointmentId, status);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}

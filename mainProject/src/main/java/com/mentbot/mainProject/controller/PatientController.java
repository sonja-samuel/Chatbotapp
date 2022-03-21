package com.mentbot.mainProject.controller;

import com.mentbot.mainProject.dto.AppointmentDetailDto;
import com.mentbot.mainProject.dto.PatientDto;
import com.mentbot.mainProject.security.services.AppointmentService;
import com.mentbot.mainProject.security.services.PatientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@PreAuthorize("hasRole('ROLE_PATIENT')")
@RequestMapping("/patient")
public class PatientController {

    private PatientService patientService;

    private AppointmentService appointmentService;

    public PatientController(PatientService patientService, AppointmentService appointmentService) {
        this.patientService = patientService;
        this.appointmentService = appointmentService;
    }

    @PostMapping("/addDetails")
    public ResponseEntity<?> addDetailsForPatient(@RequestBody PatientDto patientDto, @RequestParam int userId) {

        patientService.addDetailsForPatient(patientDto, userId);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @GetMapping("/getAppointments")
    public List<AppointmentDetailDto> getAppointments(@RequestParam int patientId) {
        return appointmentService.getAppointmentsForPatient(patientId);
    }
}

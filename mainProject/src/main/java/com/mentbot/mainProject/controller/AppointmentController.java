package com.mentbot.mainProject.controller;

import com.mentbot.mainProject.dto.AppointmentDto;
import com.mentbot.mainProject.dto.AvailableSlotsDto;
import com.mentbot.mainProject.security.services.AppointmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@PreAuthorize("hasRole('ROLE_PATIENT')")
@RequestMapping("/appointment")
public class AppointmentController {

    private AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

//    @PostMapping("/addAppointment")
//    public ResponseEntity<?> addAppointment(@RequestParam LocalDate appointmentDate,@RequestParam int specId,@RequestParam int doctorId, @RequestParam int patientId,@RequestParam int startTime,@RequestParam int endTime) {
//
//        appointmentService.addAppointment(appointmentDate,specId,doctorId,patientId, startTime,endTime);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }

    @GetMapping("/getAvailableSlots")
    public List<AvailableSlotsDto> getAvailableSlots(@RequestParam int doctorId, @RequestParam String date) {

        return appointmentService.getAvailableSlots(doctorId, LocalDate.parse(date, DateTimeFormatter.ofPattern("")));
    }

}

package com.mentbot.mainProject.controller;

import com.mentbot.mainProject.dto.AvailableSlotsDto;
import com.mentbot.mainProject.dto.DoctorNameDto;
import com.mentbot.mainProject.models.Patient;
import com.mentbot.mainProject.models.User;
import com.mentbot.mainProject.security.services.AppointmentService;
import com.mentbot.mainProject.security.services.PatientService;
import com.mentbot.mainProject.security.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@PreAuthorize("hasRole('ROLE_PATIENT')")
@RequestMapping("/appointment")
public class AppointmentController {

    private AppointmentService appointmentService;

    private UserService userService;

    private PatientService patientService;

    public AppointmentController(AppointmentService appointmentService,
                                 UserService userService,
                                 PatientService patientService) {
        this.appointmentService = appointmentService;
        this.userService = userService;
        this.patientService = patientService;
    }

    @PostMapping("/addAppointment")
    public ResponseEntity<?> addAppointment(@RequestParam String appointmentDate, @RequestParam int specId, @RequestParam int doctorId, @RequestParam String startTime, @RequestParam String endTime) {
        User user = userService.getUser();
        if(user == null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        Patient patient = patientService.getPatientByUser(user);
        if (patient == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        LocalDate apptDate = LocalDate.parse(appointmentDate, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        LocalTime startTimeLocalTime = LocalTime.parse(startTime, DateTimeFormatter.ofPattern("HH:mm"));
        LocalTime endTimeLocalTime = LocalTime.parse(endTime, DateTimeFormatter.ofPattern("HH:mm"));
        appointmentService.addAppointment(apptDate, specId, doctorId, (int) patient.getPatient_id(), startTimeLocalTime, endTimeLocalTime);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/getAvailableSlots")
    public List<AvailableSlotsDto> getAvailableSlots(@RequestParam int doctorId, @RequestParam String date) {
        return appointmentService.getAvailableSlots(doctorId, LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd")));
    }

    @GetMapping("/getDoctors")
    public List<DoctorNameDto> getDoctors(@RequestParam int specialityId) {
        return appointmentService.getDoctors(specialityId);
    }

}

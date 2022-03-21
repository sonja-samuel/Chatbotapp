package com.mentbot.mainProject.controller;

import java.util.List;

import com.mentbot.mainProject.security.services.AppointmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mentbot.mainProject.dto.AppointmentDto;
import com.mentbot.mainProject.dto.DoctorDto;
import com.mentbot.mainProject.dto.ScheduleDto;
import com.mentbot.mainProject.security.services.DoctorService;
import com.mentbot.mainProject.security.services.ScheduleService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@PreAuthorize("hasRole('ROLE_DOCTOR')")
@RequestMapping("/doctors")
public class DoctorController {

    private DoctorService doctorservice;

    private ScheduleService scheduleservice;

    private AppointmentService appointmentService;

    public DoctorController(DoctorService doctorservice, ScheduleService scheduleservice, AppointmentService appointmentService) {
        this.doctorservice = doctorservice;
        this.scheduleservice = scheduleservice;
        this.appointmentService = appointmentService;
    }

    @PostMapping("/addDetails")
    public ResponseEntity<?> addDetailsOfDoctor(@RequestBody DoctorDto doctordto, @RequestParam int userId) {

        doctorservice.addDetails(doctordto, userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //
//	@GetMapping("/getAvailableSlots")
//	public ResponseEntity<List<ScheduleDto>> getAvaialableSlots(){
//		
//			
//		return new ResponseEntity<>(HttpStatus.OK);
//	}
//	@PostMapping("/addSpecialities")
//	public ResponseEntity<?> addSpecialityForDoctor(@RequestBody DocSpecialitiesDto docSpecDto){
//	
//    doctorservice.addSpecialities(docSpecDto);
//	return new ResponseEntity<>(HttpStatus.OK);
//
//	}

    @PostMapping("/addSchedule")
    public ResponseEntity<?> addScheduleForDoctor(@RequestBody ScheduleDto scheduleDto) {

        scheduleservice.addSchedules(scheduleDto);
        return new ResponseEntity<>(HttpStatus.OK);

    }


    @GetMapping("/getAppointments")
    public List<AppointmentDto> getAppointments(@RequestParam int doctorId) {

        return doctorservice.getAppointmentsByDoctorId(doctorId);
    }

    @PostMapping("/confirmAppointment")
    public ResponseEntity<?> confirmAppointment(@RequestParam int appointmentId, String status) {

        doctorservice.confirmAppointment(appointmentId, status);
        return new ResponseEntity<>(HttpStatus.OK);
    }

//	 @PostMapping("/addSpecialities")
//		public ResponseEntity<?> addSpecialityForDoctor(@RequestBody DocSpecialitiesDto docSpecDto){
//		
//	    doctorservice.addSpecialities(docSpecDto);
//		return new ResponseEntity<>(HttpStatus.OK);
//
//		}
}

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

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@PreAuthorize("hasRole('ROLE_DOCTOR')")
@RequestMapping("/doctors")
public class DoctorController {

    private DoctorService doctorservice;

    private ScheduleService scheduleservice;

    private UserService userService;

    public DoctorController(DoctorService doctorservice,
                            ScheduleService scheduleservice,
                            UserService userService) {
        this.doctorservice = doctorservice;
        this.scheduleservice = scheduleservice;
        this.userService = userService;
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

        User user = userService.getUser();
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        Doctor doctor = doctorservice.getDoctorByUser(user);
        if(doctor == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        scheduleservice.addSchedules(scheduleDto, doctor);
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

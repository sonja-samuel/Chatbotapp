package com.mentbot.mainProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mentbot.mainProject.dto.AppointmentDto;
import com.mentbot.mainProject.dto.DoctorDto;
import com.mentbot.mainProject.dto.ScheduleDto;
import com.mentbot.mainProject.security.services.DoctorService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@PreAuthorize("hasRole('ROLE_DOCTOR')")
@RequestMapping("/doctors")
public class DoctorController {

//	@Autowired
//	DoctorService doctorservice;
////	
////	@Autowired
////	ScheduleService 
//	
//	@PostMapping("/addDetails")
//	public ResponseEntity<?> addDetailsOfDoctor(@RequestBody DoctorDto doctordto){
//		
//		doctorservice.addDetails(doctordto);
//		return new ResponseEntity<>(HttpStatus.OK);
//	}
//
//	@GetMapping("/getAvailableSlots")
//	public ResponseEntity<List<ScheduleDto>> getAvaialableSlots(){
//		
//			
//		return new ResponseEntity<>(HttpStatus.OK);
//	}
}

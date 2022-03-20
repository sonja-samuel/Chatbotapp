package com.mentbot.mainProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
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

//import com.mentbot.mainProject.dto.DocSpecialitiesDto;
import com.mentbot.mainProject.dto.PatientDto;
import com.mentbot.mainProject.security.services.AppointmentService;
import com.mentbot.mainProject.security.services.PatientService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@PreAuthorize("hasRole('ROLE_PATIENT')")
@RequestMapping("/patient")
public class PatientController {
	
	@Autowired
	PatientService patientService;
	
	@PostMapping("/addDetails")
	public ResponseEntity<?> addDetailsForPatient(@RequestBody PatientDto patientDto,@RequestParam int userId){
	
	patientService.addDetailsForPatient(patientDto,userId);
	return new ResponseEntity<>(HttpStatus.OK);

	}
	

}

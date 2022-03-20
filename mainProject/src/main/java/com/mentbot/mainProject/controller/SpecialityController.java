package com.mentbot.mainProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mentbot.mainProject.dto.SpecializationDto;
import com.mentbot.mainProject.security.services.SpecializationService;

@RestController
@RequestMapping("/speciality")
public class SpecialityController {
	
	@Autowired
	private SpecializationService specializationService;
	
	@GetMapping("/listSpeciality")
    public ResponseEntity<List<SpecializationDto>> getAllSpeciality(){
		
		List<SpecializationDto> specializations=specializationService.getAllSpeciality();
		return new ResponseEntity<>(specializations,HttpStatus.OK);
		
	}
	
	

}

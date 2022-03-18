package com.mentbot.mainProject.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mentbot.mainProject.dto.UserDto;
import com.mentbot.mainProject.security.services.UserService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@PreAuthorize("hasRole('ROLE_PATIENT') || hasRole('ROLE_DOCTOR')")
@RequestMapping("/common")
public class UserController {
	
	private UserService userService;

	public UserController(UserService userService) {
	
		this.userService = userService;
	}
	
	@GetMapping("/getUserDetails")
	public UserDto getUserDetails(@RequestParam int userId ){
		
		return userService.getUserDetails(userId);
	}
	   

}

package com.example.mainProject.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.mainProject.dto.UserDto;
import com.example.mainProject.security.services.AdminService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@PreAuthorize("hasRole('ROLE_ADMIN')")
@RequestMapping("/admin/v1")
public class AdminController {
	
	@Autowired
	AdminService adminservice;
	
	@GetMapping("/getusers")
	public ResponseEntity<List<UserDto>> getAllUsersDetails(){
		
		List<UserDto> users=adminservice.getAllUsers();
		return new ResponseEntity<>(users,HttpStatus.OK);
		
	}
	
	@PutMapping("/updateuser")
	public ResponseEntity<UserDto> updateEachUser(UserDto userdto){
		
		adminservice.updateUser(userdto);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	

}

package com.mentbot.mainProject.security.services;

import java.util.List;

import com.mentbot.mainProject.dto.DoctorDto;
import com.mentbot.mainProject.dto.PatientDto;
import com.mentbot.mainProject.dto.UserDto;
import com.mentbot.mainProject.models.Doctor;
import com.mentbot.mainProject.models.Patient;
import com.mentbot.mainProject.models.User;


public interface AdminService {
	
	
	public List<UserDto> getAllUsers();

	public void updateUser(UserDto userdto);

	public void deleteUser(Long id);

	
	
	
	
	

}

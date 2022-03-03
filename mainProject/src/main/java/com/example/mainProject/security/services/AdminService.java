package com.example.mainProject.security.services;

import java.util.List;

import com.example.mainProject.dto.DoctorDto;
import com.example.mainProject.dto.PatientDto;
import com.example.mainProject.dto.UserDto;
import com.example.mainProject.models.Doctor;
import com.example.mainProject.models.Patient;
import com.example.mainProject.models.User;


public interface AdminService {
	
	//getting all user,patient,doctor info...............
	public List<UserDto> getAllUsers();
//	public List<PatientDto> getAllPatients();
//	public List<DoctorDto> getAllDoctors();
	
	
	//updating specific record of user,patient,doctor.......
	public void updateUser(UserDto userdto);
//	public void updatePatient(PatientDto patientdto);
//	public void updateDoctor(DoctorDto doctordto);
//	
	//deleting specific record of user,patient,doctor.......
	public void deleteUser(Long id);
//	public void deletePatient(Long id);
//	public void deleteDoctor(Long id);
	
	
	
	
	

}

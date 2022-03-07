package com.mentbot.mainProject.security.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mentbot.mainProject.dto.DoctorDto;
import com.mentbot.mainProject.dto.PatientDto;
import com.mentbot.mainProject.dto.UserDto;
import com.mentbot.mainProject.models.Doctor;
import com.mentbot.mainProject.models.Patient;
import com.mentbot.mainProject.models.User;
import com.mentbot.mainProject.repo.DoctorRepo;
import com.mentbot.mainProject.repo.PatientRepo;
import com.mentbot.mainProject.repo.UserRepo;

@Service
public class AdminServiceImp implements AdminService {

	@Autowired
	UserRepo userrepo;
	
	@Autowired
	PatientRepo patientrepo;
	
	@Autowired
	DoctorRepo doctorrepo;
	
	@Override
	public List<UserDto> getAllUsers() {
		List<UserDto> userDtos = new ArrayList<>();
		userrepo.findAll().forEach(user -> {
			UserDto dto = new UserDto(user);
			userDtos.add(dto);
		});
		
		return userDtos;
	}

//	@Override
//	public List<PatientDto> getAllPatients() {
//		List<PatientDto> patientDtos = new ArrayList<>();
//		patientrepo.findAll().forEach(patient -> {
//			PatientDto patientdto = new PatientDto(patient);
//			patientDtos.add(patientdto);
//		});
//		
//		return patientDtos;
//	}

//	@Override
//	public List<DoctorDto> getAllDoctors() {
//		List<DoctorDto> doctorDtos = new ArrayList<>();
//		doctorrepo.findAll().forEach(doctor -> {
//			DoctorDto doctordto = new DoctorDto(doctor);
//			doctorDtos.add(doctordto);
//		});
//		
//		return doctorDtos;
//	}

	@Override
	public void updateUser(UserDto userdto) {
	    Long id = userdto.getId();
		User user = userrepo.getById(id);
		user.setUsername(user.getUsername());
		user.setPassword(user.getPassword());
		user.setEmail(user.getEmail());
		user.setAddressline(user.getAddressline());
		user.setFirstname(user.getFirstname());
		user.setLastname(user.getLastname());
		user.setPhonenum(user.getPhonenum());
		user.setCity(user.getCity());
		user.setState(user.getState());
		user.setCountry(user.getCountry());
		user.setRoles(user.getRoles()); 
		user.setPincode(user.getPincode());
     	
     	
		userrepo.save(user);
		
	}

//	@Override
//	public void updatePatient(PatientDto patientdto) {
//		Long id=patientdto.getId();
//		Patient patient=new Patient();
//		patient.setId(patient.getId());
////		patient.setUser(patient.getUser());
//		patientrepo.save(patient);
//		
//	}
//
//	@Override
//	public void updateDoctor(DoctorDto doctordto) {
//		Long id=doctordto.getDoctor_id();
//		Doctor doctor=new Doctor();
//		doctor.setDoctor_id(doctor.getDoctor_id());
//		doctor.setProf_statement(doctor.getProf_statement());
//		doctor.setPracticing_date(doctor.getPracticing_date());
//		doctor.setUser(doctor.getUser());
//		doctorrepo.save(doctor);
//		
//	}

	@Override
	public void deleteUser(Long id) {
		userrepo.deleteById(id);
		
	}

//	@Override
//	public void deletePatient(Long id) {
//		patientrepo.deleteById(id);
//	}
//
//	@Override
//	public void deleteDoctor(Long id) {
//		doctorrepo.deleteById(id);
//		
//	}

}

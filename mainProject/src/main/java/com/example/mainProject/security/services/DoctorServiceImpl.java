package com.example.mainProject.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mainProject.dto.DoctorDto;
import com.example.mainProject.models.Doctor;
import com.example.mainProject.repo.DoctorRepo;

@Service
public class DoctorServiceImpl implements DoctorService {
	
	@Autowired
	DoctorRepo doctorrepo;
	

	@Override
	public void addDetails(DoctorDto doctordto) {
		Doctor doctor=new Doctor();
		doctor.setProf_statement(doctordto.getProf_statement());
		doctor.setPracticing_date(doctordto.getPracticing_date());
		
		doctorrepo.save(doctor);
		
	}

	
}

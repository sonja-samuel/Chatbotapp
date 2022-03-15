package com.mentbot.mainProject.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mentbot.mainProject.dto.DocSpecialitiesDto;
import com.mentbot.mainProject.dto.DoctorDto;
import com.mentbot.mainProject.models.DocSpecialities;
import com.mentbot.mainProject.models.Doctor;
import com.mentbot.mainProject.models.Specialization;
import com.mentbot.mainProject.repo.DocSpecialitiesRepo;
import com.mentbot.mainProject.repo.DoctorRepo;
import com.mentbot.mainProject.repo.SpecializationRepo;

@Service
public class DoctorServiceImpl implements DoctorService {
	
	@Autowired
	DoctorRepo doctorrepo;
	
	@Autowired
	SpecializationRepo specrepo;
	
	@Autowired
	DocSpecialitiesRepo docspecrepo;
	

	@Override
	public void addDetails(DoctorDto doctordto) {
		Doctor doctor=new Doctor();
		doctor.setProf_statement(doctordto.getProf_statement());
		doctor.setPracticing_date(doctordto.getPracticing_date());
		
		doctorrepo.save(doctor);
		
	}


	@Override
	public void addSpecialities(DocSpecialitiesDto docspecdto) {
		
		DocSpecialities docspec=new DocSpecialities();
		Doctor doctor = doctorrepo.getById(docspecdto.getDoctorId());
		Specialization spec= specrepo.getById(docspecdto.getSpecId());
		docspec.setDoctor(doctor);
		docspec.setSpecialization(spec);
		 docspecrepo.save(docspec);
		
	}

	
}

package com.mentbot.mainProject.security.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mentbot.mainProject.dto.DocSpecialitiesDto;
import com.mentbot.mainProject.dto.DoctorDto;
import com.mentbot.mainProject.dto.ScheduleDto;
import com.mentbot.mainProject.models.DocSpecialities;
import com.mentbot.mainProject.models.Doctor;
import com.mentbot.mainProject.models.Specialization;
import com.mentbot.mainProject.models.User;
import com.mentbot.mainProject.repo.DocSpecialitiesRepo;
import com.mentbot.mainProject.repo.DoctorRepo;
import com.mentbot.mainProject.repo.SpecializationRepo;
import com.mentbot.mainProject.repo.UserRepo;

@Service
public class DoctorServiceImpl implements DoctorService {
	
	@Autowired
	DoctorRepo doctorrepo;
	
	@Autowired
	SpecializationRepo specrepo;
	
	@Autowired
	DocSpecialitiesRepo docspecrepo;
	
	@Autowired
	UserRepo userrepo;
	
	
	
	
	
//
//	@Override
//	public void addDetails(DoctorDto doctordto) {
//		Doctor doctor=new Doctor();
//		doctor.setProf_statement(doctordto.getProf_statement());
//		doctor.setPracticing_date(doctordto.getPracticing_date());
//		
//		doctorrepo.save(doctor);
//		
//	}


	@Override
	public void addSpecialities(DocSpecialitiesDto docspecdto) {
		
		DocSpecialities docspec=new DocSpecialities();
		Doctor doctor = doctorrepo.getById(docspecdto.getDoctorId());
		Specialization spec= specrepo.getById(docspecdto.getSpecId());
		docspec.setDoctor(doctor);
		docspec.setSpecialization(spec);
		docspecrepo.save(docspec);
		
	}
	
	 @Override
	    public void addDetails(DoctorDto doctordto, int userId) {

//			LocalDate practicingDate = LocalDate.parse(doctordto.getPracticing_date(), DateTimeFormatter.ofPattern("dd-mm-yyyy"));
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	        LocalDate practicingDate = LocalDate.parse(doctordto.getPracticing_date(), formatter);

	        Set<Long> specializationIds = doctordto.getSpecializationIds().stream()
	                .mapToLong(Integer::longValue)
	                .boxed().collect(Collectors.toSet());

	        Doctor doctor = new Doctor();
	        User user = userrepo.getById(Long.valueOf(userId));
	        doctor.setUser(user);
	        doctor.setProf_statement(doctordto.getProf_statement());
	        doctor.setPracticing_date(practicingDate);
	        List<Specialization> specializations = specrepo.findAllById(specializationIds);
//			Set<Specialization> specializations = (Set<Specialization>) specrepo.findAllById(specializationIds);
	        Set<Specialization> docSpecializations = new HashSet<Specialization>(specializations);
//	        doctor.setSpecialization(docSpecializations);
	        doctorrepo.save(doctor);
	    }


	

	
}

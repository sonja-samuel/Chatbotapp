package com.mentbot.mainProject.security.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mentbot.mainProject.dto.SpecializationDto;
import com.mentbot.mainProject.repo.SpecializationRepo;

@Service
public class SpecializationServiceImpl implements SpecializationService {
	
	@Autowired
	private SpecializationRepo specrepo;
	
	@Override
	public List<SpecializationDto> getAllSpeciality() {
		List<SpecializationDto> specialization = new ArrayList<>();
		specrepo.findAll().forEach(spec -> {
			SpecializationDto dto = new SpecializationDto(spec);
			specialization.add(dto);
		});
		
		return specialization;
	}


}

package com.mentbot.mainProject.dto;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.mentbot.mainProject.models.DocSpecialities;
import com.mentbot.mainProject.models.Doctor;
import com.mentbot.mainProject.models.Specialization;

public class DocSpecialitiesDto {
     
	private Long id;

	private Long doctorId;
	private Long specId;
	

	public DocSpecialitiesDto(DocSpecialities docspec) {
		
		this.id =docspec.getId();
		this.doctorId = docspec.getDoctor().getDoctor_id();
		this.specId = docspec.getSpecialization().getId();
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Long getDoctorId() {
		return doctorId;
	}


	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}


	public Long getSpecId() {
		return specId;
	}


	public void setSpecId(Long specId) {
		this.specId = specId;
	}
	

}

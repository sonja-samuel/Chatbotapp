package com.mentbot.mainProject.dto;

import com.mentbot.mainProject.models.Specialization;

public class SpecializationDto {

	private Long id;

	private String specialityName;

	public SpecializationDto(Specialization spec) {

		this.id = spec.getSpec_id();
		this.specialityName = spec.getSpec_name();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSpecialityName() {
		return specialityName;
	}

	public void setSpecialityName(String specialityName) {
		this.specialityName = specialityName;
	}

}

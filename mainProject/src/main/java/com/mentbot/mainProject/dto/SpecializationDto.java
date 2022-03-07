package com.mentbot.mainProject.dto;

import com.mentbot.mainProject.models.Specialization;

public class SpecializationDto {
	
    private Long id;
	
	private String spec_name;

	public SpecializationDto(Specialization spec) {
		
		this.id = spec.getId();
		this.spec_name =spec.getSpec_name();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSpec_name() {
		return spec_name;
	}

	public void setSpec_name(String spec_name) {
		this.spec_name = spec_name;
	}
	
	

}

package com.mentbot.mainProject.models;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name ="specialization")
public class Specialization {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long spec_id;
	
	private String spec_name;
	
	@OneToMany
	private Set<DocSpecialities> docspecialities;
	

	public Long getId() {
		return spec_id;
	}

	public void setId(Long spec_id) {
		this.spec_id = spec_id;
	}

	public String getSpec_name() {
		return spec_name;
	}

	public void setSpec_name(String spec_name) {
		this.spec_name = spec_name;
	}
		
	
}

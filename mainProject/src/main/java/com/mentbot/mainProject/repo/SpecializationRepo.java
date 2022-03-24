package com.mentbot.mainProject.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mentbot.mainProject.models.Specialization;

@Repository
public interface SpecializationRepo extends JpaRepository<Specialization, Long> {

}

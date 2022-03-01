package com.example.mainProject.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.mainProject.models.ERole;
import com.example.mainProject.models.Role;

@Repository
public interface RoleRepo extends JpaRepository<Role,Long>{
	
	Optional<Role> findByName(ERole name);

}

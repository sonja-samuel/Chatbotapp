package com.mentbot.mainProject.security.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mentbot.mainProject.dto.DoctorDto;
import com.mentbot.mainProject.dto.PatientDto;
import com.mentbot.mainProject.dto.UserDto;
import com.mentbot.mainProject.models.Doctor;
import com.mentbot.mainProject.models.Patient;
import com.mentbot.mainProject.models.User;
import com.mentbot.mainProject.repo.DoctorRepo;
import com.mentbot.mainProject.repo.PatientRepo;
import com.mentbot.mainProject.repo.UserRepo;

@Service
public class AdminServiceImp implements AdminService {

	private UserRepo userRepo;

	public AdminServiceImp(UserRepo userRepo) {
		this.userRepo = userRepo;

	}

	@Override
	public List<UserDto> getAllUsers() {
		List<UserDto> userDtos = new ArrayList<>();
		userRepo.findAll().forEach(user -> {
			UserDto dto = new UserDto(user);
			userDtos.add(dto);
		});

		return userDtos;
	}

	@Override
	public void updateUser(UserDto userdto) {
		Long id = userdto.getId();
		User user = userRepo.getById(id);
		user.setUsername(user.getUsername());
		user.setPassword(user.getPassword());
		user.setEmail(user.getEmail());
		user.setAddressline(user.getAddressline());
		user.setFirstname(user.getFirstname());
		user.setLastname(user.getLastname());
		user.setPhonenum(user.getPhonenum());
		user.setCity(user.getCity());
		user.setState(user.getState());
		user.setCountry(user.getCountry());
		user.setRoles(user.getRoles());
		user.setPincode(user.getPincode());

		userRepo.save(user);

	}

	@Override
	public void deleteUser(Long id) {
		userRepo.deleteById(id);

	}

}

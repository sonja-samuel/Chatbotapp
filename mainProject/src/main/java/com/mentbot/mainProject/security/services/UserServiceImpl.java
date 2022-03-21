package com.mentbot.mainProject.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mentbot.mainProject.dto.UserDto;
import com.mentbot.mainProject.models.User;
import com.mentbot.mainProject.repo.UserRepo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;

	@Override
	public UserDto getUserDetails(int id) {
		User user=userRepo.getById(Long.valueOf(id));
		UserDto userDto=new UserDto(user);
		
		return userDto;
	}

	
	
	
	

}

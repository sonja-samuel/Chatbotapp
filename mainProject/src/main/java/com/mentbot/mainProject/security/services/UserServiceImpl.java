package com.mentbot.mainProject.security.services;

import org.springframework.stereotype.Service;

import com.mentbot.mainProject.dto.UserDto;
import com.mentbot.mainProject.models.User;
import com.mentbot.mainProject.repo.UserRepo;

@Service
public class UserServiceImpl implements UserService {

	
	private UserRepo userRepo;

	@Override
	public UserDto getUserDetails(int userId) {
		User user=userRepo.getById(Long.valueOf(userId));
		UserDto userDto=new UserDto(user);
		
		return userDto;
	}

	
	
	
	

}

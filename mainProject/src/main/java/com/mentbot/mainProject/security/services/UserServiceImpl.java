package com.mentbot.mainProject.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.mentbot.mainProject.dto.UserDto;
import com.mentbot.mainProject.models.User;
import com.mentbot.mainProject.repo.UserRepo;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

   
    private UserRepo userRepo;
    

    public UserServiceImpl(UserRepo userRepo) {
		this.userRepo = userRepo;
	}

	@Override
    public UserDto getUserDetails(int userId) {
        User user = userRepo.getById(Long.valueOf(userId));
        UserDto userDto = new UserDto(user);

        return userDto;
    }

    @Override
    public User getUser() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        String username = authentication.getName();
        Optional<User> user = userRepo.findByUsername(username);
        return user.orElse(null);
    }
}
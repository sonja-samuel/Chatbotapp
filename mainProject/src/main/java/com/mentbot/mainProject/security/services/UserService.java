package com.mentbot.mainProject.security.services;

import com.mentbot.mainProject.dto.UserDto;
import com.mentbot.mainProject.models.User;

public interface UserService {

    UserDto getUserDetails(int id);

    User getUser();

}

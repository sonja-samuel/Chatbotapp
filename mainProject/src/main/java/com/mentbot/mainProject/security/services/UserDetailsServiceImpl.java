package com.mentbot.mainProject.security.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mentbot.mainProject.models.User;
import com.mentbot.mainProject.repo.UserRepo;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	UserRepo userrepo;
	

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	
	    User user=userrepo.findByUsername(username)
	    		.orElseThrow(() -> new UsernameNotFoundException("User not Found with username" + username));
	    
	    return UserDetailsImpl.build(user);
	}

}


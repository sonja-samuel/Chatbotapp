package com.example.mainProject.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mainProject.security.services.ChatService;




@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@PreAuthorize("hasRole('ROLE_PATIENT')")
@RequestMapping("/api")
public class ChatController {
	


	@Autowired
    ChatService chatservice;
	
	
	 @GetMapping("/patient/chat")
	 public void chatInitiate() {
		 
		 chatservice.initiateBot();
	 }
		
		
}
package com.mentbot.mainProject.security.services;

import java.io.File;

import org.alicebot.ab.Bot;
import org.alicebot.ab.Chat;
import org.alicebot.ab.MagicBooleans;
import org.springframework.stereotype.Service;

@Service
public class ChatServiceImpl implements ChatService {


	public Chat initiateBot() {
		
		final boolean TRACE_MODE = false;
	//	final String botName = "super";
		Bot bot;
		Chat chatSession;
		

		

			File currDir = new File(".");
			String path = currDir.getAbsolutePath();
			path = path.substring(0, path.length() - 2);
			System.out.println(path);
			String resourcesPath = path + File.separator + "src" + File.separator + "main" + File.separator + "resources";
			System.out.println(resourcesPath); 
			MagicBooleans.trace_mode = TRACE_MODE;
			bot = new Bot("super", resourcesPath);
			chatSession = new Chat(bot);
			bot.brain.nodeStats();
		
			return chatSession;
		
	}

		

	

}

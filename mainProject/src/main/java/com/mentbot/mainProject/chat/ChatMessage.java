package com.mentbot.mainProject.chat;

import com.mentbot.mainProject.constants.MessageType;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class ChatMessage {
 
	private String message;
	private String sender;
	private String recipient;
//	private MessageType messageType;

	public ChatMessage() {
	}

	@Override
	public String toString() {
		return "ChatMessage{" +
				"message='" + message + '\'' +
				", sender='" + sender + '\'' +
				", recipient='" + recipient + '\'' +
//				", messageType=" + messageType +
				'}';
	}
}

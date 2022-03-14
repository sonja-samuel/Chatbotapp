package com.mentbot.mainProject.chat;

import com.mentbot.mainProject.constants.MessageType;
import lombok.*;


public class ChatMessage {
 
	private String message;
	private String sender;
	private String recipient;
    private MessageType messageType;

	

	public ChatMessage() {
	}
	
     public ChatMessage(String message, String sender, String recipient, MessageType messageType) {
		
		this.message = message;
		this.sender = sender;
		this.recipient = recipient;
		this.messageType = messageType;
	}

	

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}
	public MessageType getMessageType() {
		return messageType;
	}

	public void setMessageType(MessageType messageType) {
		this.messageType = messageType;
	}
	
	@Override
	public String toString() {
		return "ChatMessage{" +
				"message='" + message + '\'' +
				", sender='" + sender + '\'' +
				", recipient='" + recipient + '\'' +
				", messageType=" + messageType +
				'}';
	}



	
	
	
}

package com.mentbot.mainProject.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.client.WebSocketConnectionManager;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

@Component
public class WebsocketEventListener {

	private SimpMessageSendingOperations sendingOperations;

	public WebsocketEventListener(SimpMessageSendingOperations sendingOperations) {
		this.sendingOperations = sendingOperations;
	}

	@EventListener
	public void handleWebsocketConnection(SessionConnectedEvent connectedEvent) {

	}

	@EventListener
	public void handleWebsocketDisconnect(SessionDisconnectEvent disconnectEvent) {
		StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(disconnectEvent.getMessage());
		String username = (String) headerAccessor.getSessionAttributes().get("username");

	}
}

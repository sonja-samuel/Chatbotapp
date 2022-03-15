package com.mentbot.mainProject.controller;


import javax.servlet.ServletContext;

import com.mentbot.mainProject.constants.MessageType;
import org.alicebot.ab.Bot;
import org.alicebot.ab.Chat;
import org.alicebot.ab.History;
import org.alicebot.ab.MagicBooleans;
import org.alicebot.ab.MagicStrings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.util.HtmlUtils;
import org.apache.commons.lang3.StringUtils;

import com.mentbot.mainProject.chat.ChatMessage;
import com.mentbot.mainProject.chat.Welcome;
import com.mentbot.mainProject.security.services.ChatService;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
//@PreAuthorize("hasRole('ROLE_PATIENT')")

public class ChatController implements ServletContextAware {


    @Autowired
    ChatService chatservice;

    private ServletContext servletContext;

    private static boolean InitFlag = true;
    Bot bot;
    Chat chatSession;

    @MessageMapping("/talktochatbot")
    @SendTo("/topic/client")
    public String welcome(@Payload ChatMessage chatMessage) throws Exception {
        ChatMessage reply = null;
        String response = "";
        try {
            if (InitFlag == true) {

                chatSession = chatservice.initiateBot();
                InitFlag = false;
            }
            String incomingMsg = chatMessage.getMessage();

            if (StringUtils.isEmpty(incomingMsg))
                incomingMsg = MagicStrings.null_input;
            if (chatMessage.getMessageType() == MessageType.DISCONNECT || chatMessage.getMessageType() == MessageType.TERMINATE) {
                bot.writeQuit();
                System.exit(0);
            } else {
                if (MagicBooleans.trace_mode)
                    System.out.println("STATE=NA:THAT=" + ((History) chatSession.thatHistory.get(0)).get(0) + ":TOPIC=" + chatSession.predicates.get("topic"));
                response = chatSession.multisentenceRespond(incomingMsg);
                while (response.contains("&lt;"))
                    response = response.replace("&lt;", "<");
                while (response.contains("&gt;"))
                    response = response.replace("&gt;", ">");


                response = executeDefault(response);
                reply = new ChatMessage(HtmlUtils.htmlEscape(response), chatMessage.getSender(), chatMessage.getRecipient(),chatMessage.getMessageType());


            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        Thread.sleep(1000);
        return reply.getMessage();
    }

    private String executeDefault(String response) {
        if (response.trim().contains("<oob><url>")) {
            response = setOOBUrl(response);
        }
        if (response.trim().contains("<oob><search>")) {
            response = setOOBSearch(response);
        }
        return response;
    }

    private String setOOBUrl(String response) {
        String mytext = StringUtils.substringBetween(response, "<oob><url>", "</url></oob>");
        response = response.replace("<oob><url>", "<a href=\"");
        response = response.replace("</url></oob>", "\" target=\"_blank\">" + mytext + "</a>");
        return response;
    }

    private String setOOBSearch(String response) {
        String mytext = StringUtils.substringBetween(response, "<oob><search>", "</search></oob>");
        response = response.replace("<oob><search>", "<br/><a href=\"https://www.google.com/search?q=");
        response = response.replace("</search></oob>", "\" target=\"_blank\"><i>Click Here to View Result for " + mytext + ".</i></a>");
        return response;
    }


    @Override
    public void setServletContext(ServletContext servletContext) {
        // TODO Auto-generated method stub
        this.servletContext = servletContext;

    }


}
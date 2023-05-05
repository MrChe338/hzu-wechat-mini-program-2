package com.zzm.controller;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zzm.pojo.User;
import com.zzm.pojo.chat.Messages;
import com.zzm.pojo.chat.UserConversations;
import com.zzm.service.chat.MessagesService;
import com.zzm.service.chat.UserConversationsService;
import com.zzm.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.Date;


public class MyWebSocketHandler extends TextWebSocketHandler {

    @Autowired
    private MessagesService messagesService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserConversationsService userConversationsService;

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) {
        String jsonContent = message.getPayload(); // 获取消息的内容

        // 解析JSON内容
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode;
        try {
            jsonNode = objectMapper.readTree(jsonContent);
        } catch (JsonParseException e) {
            System.err.println("Failed to parse JSON: " + jsonContent);
            e.printStackTrace();
            return;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return;
        }

        try {
            String content = jsonNode.get("content").asText();
            Long senderId = jsonNode.get("senderId").asLong();
            Long receiverId = jsonNode.get("receiverId").asLong();

            // 获取User和UserConversation对象
            User sender = userService.findById(senderId);

            if (sender == null) {
                throw new IllegalArgumentException("No sender found with id: " + senderId);
            }

            User receiver = userService.findById(receiverId);

            if (receiver == null) {
                throw new IllegalArgumentException("No receiver found with id: " + receiverId);
            }

            UserConversations userConversations = userConversationsService.findOrCreate(sender, receiver);

            // 创建并保存消息
            Messages messages = new Messages();
            messages.setContent(content);
            messages.setSender(sender);
            messages.setMessageType(Messages.MessageType.valueOf("text"));
            messages.setConversation(userConversations);
            messages.setSentAt(new Date());
            messagesService.save(messages); // 保存消息到数据库

        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }
}



//public class MyWebSocketHandler extends TextWebSocketHandler {
//    @Override
//    public void handleTextMessage(WebSocketSession session, TextMessage message) {
//        // 这里你可以处理从客户端接收到的消息，并且可以通过session.sendMessage发送消息到客户端
//    }
//}


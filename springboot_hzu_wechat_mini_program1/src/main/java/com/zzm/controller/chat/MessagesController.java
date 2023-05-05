package com.zzm.controller.chat;

import com.zzm.pojo.chat.Messages;
import com.zzm.service.chat.MessagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class MessagesController {
    @Autowired
    private MessagesService messagesService;
    @GetMapping
    public List<Messages> getAllMessages() {
        return messagesService.findAll();
    }
    @GetMapping("/{id}")
    public Messages getMessage(@PathVariable int id) {
        return messagesService.findById(id);
    }

    @PostMapping
    public Messages createMessage(@RequestBody Messages messages) {
        return messagesService.save(messages);
    }

    @DeleteMapping("/{id}")
    public void deleteMessage(@PathVariable int id) {
        messagesService.deleteById(id);
    }
    @MessageMapping("/sendMessage")
    @SendTo("/topic/messages")
    public Messages sendMessage(@Payload Messages chatMessage) {
        return chatMessage;
    }
    @GetMapping("/conversation/{id}")
    public List<Messages> getMessagesByConversationId(@PathVariable int id) {
        return messagesService.findByConversation_Id(id);
    }

}


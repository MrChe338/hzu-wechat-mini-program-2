package com.zzm.controller.chat;

import com.zzm.pojo.chat.Messages;
import com.zzm.pojo.chat.UserConversations;
import com.zzm.service.chat.UserConversationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/userConversations")
public class UserConversationsController {
    @Autowired
    private UserConversationsService userConversationsService;

    @GetMapping
    public List<UserConversations> getAllUserConversations() {
        return userConversationsService.findAll();
    }

    @GetMapping("/{id}")
    public UserConversations getUserConversations(@PathVariable int id) {
        return userConversationsService.findById(id);
    }

    @PostMapping
    public UserConversations createUserConversations(@RequestBody UserConversations userConversations) {
        return userConversationsService.save(userConversations);
    }

    @DeleteMapping("/{id}")
    public void deleteUserConversations(@PathVariable int id) {
        userConversationsService.deleteById(id);
    }

}


package com.zzm.service.chat;

import com.zzm.pojo.chat.Messages;

import java.util.List;

public interface MessagesService {
    Messages findById(int id);
    List<Messages> findAll();
    Messages save(Messages messages);
    void deleteById(int id);
    List<Messages> findByConversation_Id(int conversationId);

}


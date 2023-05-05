package com.zzm.service.chat;

import com.zzm.dao.chat.MessagesRepository;
import com.zzm.pojo.chat.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessagesServiceImpl implements MessagesService {
    @Autowired
    private MessagesRepository messagesRepository;

    @Override
    public Messages findById(int id) {
        return messagesRepository.findById(id).orElse(null);
    }

    @Override
    public List<Messages> findAll() {
        return messagesRepository.findAll();
    }

    @Override
    public Messages save(Messages messages) {
        return messagesRepository.save(messages);
    }

    @Override
    public void deleteById(int id) {
        messagesRepository.deleteById(id);
    }
    @Override
    public List<Messages> findByConversation_Id(int conversationId) {
        return messagesRepository.findByConversation_Id(conversationId);
    }
}


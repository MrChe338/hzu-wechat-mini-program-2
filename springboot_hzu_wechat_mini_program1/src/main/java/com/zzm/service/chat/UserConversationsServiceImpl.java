package com.zzm.service.chat;

import com.zzm.dao.chat.UserConversationsRepository;
import com.zzm.dao.user.UserDao;
import com.zzm.pojo.User;
import com.zzm.pojo.chat.UserConversations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserConversationsServiceImpl implements UserConversationsService {
    @Autowired
    private UserConversationsRepository userConversationsRepository;

    @Override
    public UserConversations findById(int id) {
        return userConversationsRepository.findById(id).orElse(null);
    }

    @Override
    public List<UserConversations> findAll() {
        return userConversationsRepository.findAll();
    }

    @Override
    public UserConversations save(UserConversations userConversations) {
        return userConversationsRepository.save(userConversations);
    }

    @Override
    public void deleteById(int id) {
        userConversationsRepository.deleteById(id);
    }

    @Override
    public UserConversations findByCreatorAndReceiver(User creator, User receiver) {
        return userConversationsRepository.findByCreatorAndReceiver(creator, receiver);
    }

    @Override
    public UserConversations findOrCreate(User creator, User receiver) {
        UserConversations userConversations = findByCreatorAndReceiver(creator, receiver);
        if (userConversations == null) {
            userConversations = new UserConversations();
            userConversations.setCreator(creator);
            userConversations.setReceiver(receiver);
            userConversations = save(userConversations);
        }
        return userConversations;
    }



}



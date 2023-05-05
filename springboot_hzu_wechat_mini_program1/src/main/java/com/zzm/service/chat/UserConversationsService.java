package com.zzm.service.chat;
import com.zzm.pojo.User;
import com.zzm.pojo.chat.UserConversations;

import java.util.List;
public interface UserConversationsService {
    UserConversations findById(int id);
    List<UserConversations> findAll();
    UserConversations save(UserConversations userConversations);
    void deleteById(int id);
    UserConversations findByCreatorAndReceiver(User creator, User receiver);
    UserConversations findOrCreate(User creator, User receiver);
}



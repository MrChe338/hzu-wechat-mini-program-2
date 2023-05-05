package com.zzm.dao.chat;

import com.zzm.pojo.User;
import com.zzm.pojo.chat.UserConversations;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserConversationsRepository extends JpaRepository<UserConversations, Integer> {
    UserConversations findByCreatorAndReceiver(User creator, User receiver);
}

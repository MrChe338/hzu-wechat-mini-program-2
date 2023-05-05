package com.zzm.dao.chat;

import com.zzm.pojo.chat.Messages;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MessagesRepository extends JpaRepository<Messages, Integer> {
    List<Messages> findByConversation_Id(int conversationId);

//
//    Messages findByConversation_id(int conversation);
}

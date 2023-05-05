package com.zzm.service.forum;

import com.zzm.dao.forum.ForumReplyRepository;
import com.zzm.dao.forum.ForumRepository;
import com.zzm.dao.user.UserDao;
import com.zzm.pojo.Forum.Forum;
import com.zzm.pojo.Forum.ForumReply;
import com.zzm.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ForumReplyService {

    @Autowired
    private ForumRepository forumRepository;

    @Autowired
    private UserDao userRepository;

    @Autowired
    private ForumReplyRepository forumReplyRepository;

    @Transactional
    public ForumReply addReply(ForumReply forumReplyDTO) {
        User user = userRepository.findById(forumReplyDTO.getUser().getId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        Forum forum = forumRepository.findById(forumReplyDTO.getForum().getId())
                .orElseThrow(() -> new RuntimeException("Forum not found"));
        forum.setReply_count(forum.getReply_count()+1);
        forumRepository.save(forum);
        ForumReply newReply = new ForumReply();
        newReply.setUser(user);
        newReply.setForum(forum);
        newReply.setContent(forumReplyDTO.getContent());
        newReply.setCreateTime(Timestamp.valueOf(LocalDateTime.now()));
        newReply.setLikeCount(0);
        return forumReplyRepository.save(newReply);
    }

}

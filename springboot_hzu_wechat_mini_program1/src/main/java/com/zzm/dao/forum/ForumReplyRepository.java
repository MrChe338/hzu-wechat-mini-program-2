package com.zzm.dao.forum;

import com.zzm.pojo.Forum.Forum;
import com.zzm.pojo.Forum.ForumLike;
import com.zzm.pojo.Forum.ForumReply;
import com.zzm.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ForumReplyRepository extends JpaRepository<ForumReply, Integer> {
    List<ForumReply> findByForumOrderByLikeCountDesc(Forum forum);

}

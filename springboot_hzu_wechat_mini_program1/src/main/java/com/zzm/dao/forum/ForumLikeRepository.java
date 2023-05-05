package com.zzm.dao.forum;

import com.zzm.pojo.Forum.Forum;
import com.zzm.pojo.Forum.ForumLike;
import com.zzm.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ForumLikeRepository extends JpaRepository<ForumLike, Integer>{
    ForumLike findByForumAndUser(Forum forum, User user);
}

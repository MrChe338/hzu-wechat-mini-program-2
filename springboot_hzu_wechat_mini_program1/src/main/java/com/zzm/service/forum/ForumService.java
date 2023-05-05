package com.zzm.service.forum;

import com.zzm.pojo.Forum.Forum;

import java.util.List;

public interface ForumService {
    List<Forum> getAllForums();
    List<Forum> getForumsByUserId(Long userId);
    List<Forum> getForumsByIds(List<Integer> ids); // 添加这个方法


    void addFavorite(Integer forumId, Long userId);
    void toggleLike(Integer forumId, Long userId);
}

package com.zzm.service.forum;

import com.zzm.dao.forum.ForumLikeRepository;
import com.zzm.dao.forum.ForumRepository;
import com.zzm.dao.forum.UserFavoriteForumRepository;
import com.zzm.dao.user.UserDao;
import com.zzm.pojo.Forum.Forum;
import com.zzm.pojo.Forum.ForumLike;
import com.zzm.pojo.Forum.ForumReply;
import com.zzm.pojo.Forum.UserFavoriteForum;
import com.zzm.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

// 使用@Service注解，表明这是一个Spring组件，用于提供论坛相关的业务逻辑
@Service
public class ForumServiceImpl implements ForumService {

    // 使用@Autowired注解自动装配ForumRepository实例
    @Autowired
    private ForumRepository forumRepository;
    @Autowired
    private UserDao userRepository;
    @Autowired
    private UserFavoriteForumRepository userFavoriteForumRepository;
    @Autowired
    private ForumLikeRepository forumLikeRepository;
    // 实现ForumService接口中的getAllForums方法，用于获取所有论坛列表

    @Override
    public List<Forum> getAllForums() {
        return forumRepository.findAll();
    }

    // 实现ForumService接口中的getForumsByUserId方法，用于获取指定用户创建的所有论坛列表
    @Override
    public List<Forum> getForumsByUserId(Long userId) {
        return forumRepository.findByUser_Id(userId);
    }

    // 自定义方法，用于根据论坛ID列表获取所有论坛的详细信息
    public List<Forum> getForumsByIds(List<Integer> ids) {
        return forumRepository.findAllById(ids);
    }

    @Override

    public void addFavorite(Integer forumId, Long userId) {
        // 获取论坛帖子
        Forum forum = forumRepository.findById(forumId)
                .orElseThrow(() -> new RuntimeException("Forum not found"));

        // 获取用户
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // 创建并保存UserFavoriteForum实体
        UserFavoriteForum userFavoriteForum = userFavoriteForumRepository.findByForumAndUser(forum, user);

        // 如果用户已经收藏，则取消收藏，否则添加收藏
        if(userFavoriteForum != null){
            // 减少关注数
            forum.setFollow_count(forum.getFollow_count() - 1);

            // 删除收藏记录
            userFavoriteForumRepository.delete(userFavoriteForum);
        } else {
            // 增加关注数
            forum.setFollow_count(forum.getFollow_count() + 1);

            userFavoriteForum = new UserFavoriteForum();
            userFavoriteForum.setUser(user);
            userFavoriteForum.setForum(forum);
            userFavoriteForumRepository.save(userFavoriteForum);
        }

        // 保存论坛帖子
        forumRepository.save(forum);
    }

    @Override
    @Transactional
    public void toggleLike(Integer forumId, Long userId) {
        // 获取论坛帖子
        Forum forum = forumRepository.findById(forumId)
                .orElseThrow(() -> new RuntimeException("Forum not found"));

        // 获取用户
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // 创建并保存ForumLike实体
        ForumLike forumLike = forumLikeRepository.findByForumAndUser(forum, user);

        // 如果用户已经点赞，则取消点赞，否则添加点赞
        if(forumLike != null){
            // 减少点赞数
            forum.setLike_count(forum.getLike_count() - 1);

            // 删除点赞记录
            forumLikeRepository.delete(forumLike);
        } else {
            // 增加点赞数
            forum.setLike_count(forum.getLike_count() + 1);

            forumLike = new ForumLike();
            forumLike.setUser(user);
            forumLike.setForum(forum);
            forumLikeRepository.save(forumLike);
        }

        // 保存论坛帖子
        forumRepository.save(forum);
    }











}

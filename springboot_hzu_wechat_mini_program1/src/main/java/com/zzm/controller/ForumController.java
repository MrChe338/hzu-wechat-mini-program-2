package com.zzm.controller;

import com.zzm.pojo.Forum.Forum;
import com.zzm.pojo.Forum.UserFavoriteForum;
import com.zzm.service.forum.ForumService;
import com.zzm.service.forum.UserFavoriteForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

// 使用@RestController注解，表明这是一个RESTful Web服务的控制器
// 该控制器下的请求路径以"/forum"开头
@RestController
@RequestMapping("/forum")
public class ForumController {

    // 使用@Autowired注解自动装配ForumService实例
    @Autowired
    private ForumService forumService;
    // 使用@Autowired注解自动装配UserFavoriteForumService实例
    @Autowired
    private UserFavoriteForumService userFavoriteForumService;


    // 处理"/forum/user/{userId}/liked"路径上的GET请求，用于获取用户喜欢的论坛列表
    @GetMapping("/user/{userId}/liked")
    public ResponseEntity<List<Forum>> getLikedForumsByUserId(@PathVariable Long userId) {
        // 获取指定用户喜欢的所有论坛
        List<UserFavoriteForum> favoriteForums = userFavoriteForumService.getFavoriteForumsByUserId(userId);
        // 提取所有喜欢的论坛的ID
        List<Integer> forumIds = favoriteForums.stream()
                .map(userFavoriteForum -> userFavoriteForum.getForum().getId())
                .collect(Collectors.toList());

        // 根据ID获取所有喜欢的论坛的详细信息
        List<Forum> likedForums = forumService.getForumsByIds(forumIds);
        // 返回成功的响应，包含论坛列表
        return new ResponseEntity<>(likedForums, HttpStatus.OK);
    }

    // 处理"/forum"路径上的GET请求，用于获取所有论坛列表
    @GetMapping
    public ResponseEntity<List<Forum>> getAllForums() {
        // 获取所有论坛的详细信息
        List<Forum> forums = forumService.getAllForums();
        // 返回成功的响应，包含论坛列表
        return new ResponseEntity<>(forums, HttpStatus.OK);
    }

    // 处理"/forum/{userId}"路径上的GET请求，用于获取指定用户创建的论坛列表
    @GetMapping("/{userId}")
    public ResponseEntity<List<Forum>> getForumsByUserId(@PathVariable Long userId) {
        // 获取指定用户创建的所有论坛的详细信息
        List<Forum> forums = forumService.getForumsByUserId(userId);
        // 返回成功的响应，包含论坛列表
        return new ResponseEntity<>(forums, HttpStatus.OK);
    }

    @PostMapping("/addFavorite/{forumId}/user/{userId}")
    public ResponseEntity<Void> addFavorite(@PathVariable Integer forumId, @PathVariable Long userId) {
        forumService.addFavorite(forumId, userId);
        return ResponseEntity.ok().build();
    }
    @PostMapping("/toggleLike/{forumId}/user/{userId}")
    public ResponseEntity<Void> toggleLike(@PathVariable Integer forumId, @PathVariable Long userId) {
        forumService.toggleLike(forumId, userId);
        return ResponseEntity.ok().build();
    }



}

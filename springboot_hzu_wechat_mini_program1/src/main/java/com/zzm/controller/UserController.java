package com.zzm.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zzm.dao.UserWithoutOpenidProjection;
import com.zzm.pojo.User;
import com.zzm.pojo.project.Project;
import com.zzm.pojo.resume.WxUserResume;
import com.zzm.service.project.UserLikeProjectService;
import com.zzm.service.resume.UserFavoriteResumesService;
import com.zzm.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
//public class UserController {
//
//    @GetMapping("/")
//    public String home() {
//        return "Welcome to my Spring Boot application!";
//    }
//}

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService; // 自动装配UserService实例
    @Autowired
    private UserLikeProjectService userLikeProjectService; // 自动装配UserLikeProjectService实例
    private static final String APP_ID = "wx9f99f55e6350e028"; // 微信APP_ID
    private static final String SECRET = "56949ce24b925f3d9b15a587cf30f5e4"; // 微信SECRET
    @Autowired
    private UserFavoriteResumesService resumeService; // 自动装配UserFavoriteResumesService实例

    @GetMapping("/login") // 映射/login路径上的GET请求
    public User userLogin(@RequestParam("code") String code, // 接收请求参数code
                                                 @RequestParam("userinfo") String userinfoJson) // 接收请求参数userinfoJson
            throws IOException {
        // 构造微信API的URL，包含APP_ID、SECRET和code参数
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid=" + APP_ID + "&secret=" + SECRET + "&js_code=" + code + "&grant_type=authorization_code";
        RestTemplate restTemplate = new RestTemplate(); // 创建RestTemplate实例
        HttpHeaders headers = new HttpHeaders(); // 创建HttpHeaders实例
        HttpEntity<String> entity = new HttpEntity<>(headers); // 创建HttpEntity实例

        // 使用RestTemplate发送GET请求，获取微信API的响应
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        ObjectMapper objectMapper = new ObjectMapper(); // 创建ObjectMapper实例
        // 将响应的JSON字符串转换为Map对象
        Map<String, Object> resultMap = objectMapper.readValue(response.getBody(), Map.class);
        String openid = (String) resultMap.get("openid"); // 从Map中获取openid

        // 解析userinfoJson字符串，将其转换为User对象
        User userInfo = objectMapper.readValue(userinfoJson, User.class);

        User user = userService.findByOpenid(openid); // 根据openid查询数据库中的用户

        // 如果用户不存在，则将用户信息（包括openid）保存到数据库中
        if (user == null) {
            userInfo.setOpenid(openid);
            userService.saveOrUpdate(userInfo);
        } else {
            // 如果用户已存在，则更新用户的昵称、头像和性别等信息
            user.setNickname(userInfo.getNickname());
            user.setAvatarUrl(userInfo.getAvatarUrl());
            user.setGender(userInfo.getGender());
            userService.saveOrUpdate(user);
        }

        // 返回用户信息
        return userService.findByOpenid(openid);
    }

    @GetMapping("/{userId}/favorites/projects")
    public ResponseEntity<List<Project>> getMyProjectFavorites(@PathVariable Long userId) {
        List<Project> favoriteProjects = userLikeProjectService.getUserFavoriteProjects(userId);
        return new ResponseEntity<>(favoriteProjects, HttpStatus.OK);
    }
    @GetMapping("/{userId}/favorites/resumes")
    public ResponseEntity<List<WxUserResume>> getMyResumeFavorites(@PathVariable Long userId) {
        List<WxUserResume> favoriteResumes = resumeService.getUserFavoriteResumes(userId);
        return new ResponseEntity<>(favoriteResumes, HttpStatus.OK);
    }
    @GetMapping("/search")
    public List<User> searchUsers(@RequestParam String query) {
        return userService.searchUsers(query);
    }

}


package com.zzm.service.user;

import com.zzm.dao.UserWithoutOpenidProjection;
import com.zzm.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    User findByOpenid(String openid);
    UserWithoutOpenidProjection findByOpenid1(String openid);
    boolean existsByOpenid(String openid);
    User saveOrUpdate(User user);
    Long findIdByOpenid(String openid);

    UserWithoutOpenidProjection findById1(Long id);
    User findById(Long id);
    List<User> searchUsers(String query);
}

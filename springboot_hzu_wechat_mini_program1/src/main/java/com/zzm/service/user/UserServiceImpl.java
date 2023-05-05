package com.zzm.service.user;

import com.zzm.dao.UserWithoutOpenidProjection;
import com.zzm.dao.user.UserDao;
import com.zzm.pojo.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User findByOpenid(String openid) {
        return userDao.findByOpenid(openid);
    }

    @Override
    public UserWithoutOpenidProjection findByOpenid1(String openid) {
        return userDao.findByOpenid1(openid);
    }

    @Override
    public boolean existsByOpenid(String openid) {
        return userDao.existsByOpenid(openid);
    }

    @Override
    public User saveOrUpdate(User user) {
        return userDao.save(user);
    }

    @Override
    public Long findIdByOpenid(String openid) {
        User user = userDao.findByOpenid(openid);
        return user != null ? user.getId() : null;
    }

    @Override
    public UserWithoutOpenidProjection findById1(Long id) {
        return userDao.findById1(id);
    }


    @Override
    public User findById(Long id) { // 新增的方法
        return userDao.findById(id).orElse(null);
    }
    @Override
    public List<User> searchUsers(String query) {
        List<User> usersById = new ArrayList<>();
        List<User> usersByNickname = userDao.findByNicknameContaining(query);

        try {
            Long id = Long.parseLong(query);
            userDao.findById(id).ifPresent(usersById::add);
        } catch (NumberFormatException e) {
            // query is not a number, ignore
        }

        Set<User> resultSet = new HashSet<>(usersById);
        resultSet.addAll(usersByNickname);

        return new ArrayList<>(resultSet);
    }
}


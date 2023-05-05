package com.zzm.service.forum;

import com.zzm.dao.forum.UserFavoriteForumRepository;
import com.zzm.pojo.Forum.UserFavoriteForum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserFavoriteForumServiceImpl implements UserFavoriteForumService {

    @Autowired
    private UserFavoriteForumRepository userFavoriteForumRepository;

    @Override
    public List<UserFavoriteForum> getFavoriteForumsByUserId(Long userId) {
        return userFavoriteForumRepository.findByUserId(userId);
    }
}
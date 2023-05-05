package com.zzm.service.forum;

// UserFavoriteForumService.java


import com.zzm.pojo.Forum.UserFavoriteForum;

import java.util.List;

public interface UserFavoriteForumService {
    List<UserFavoriteForum> getFavoriteForumsByUserId(Long userId);

}


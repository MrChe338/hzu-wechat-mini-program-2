package com.zzm.dao.forum;

// UserFavoriteForumRepository.java

import com.zzm.pojo.Forum.Forum;
import com.zzm.pojo.Forum.UserFavoriteForum;
import com.zzm.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserFavoriteForumRepository extends JpaRepository<UserFavoriteForum, Integer> {
    List<UserFavoriteForum> findByUserId(Long userId);

    UserFavoriteForum findByForumAndUser(Forum forum, User user);
}

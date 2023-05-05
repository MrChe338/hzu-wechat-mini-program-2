package com.zzm.dao.project;

// UserFavoriteProjectRepository.java


import com.zzm.pojo.project.UserLikeFavoriteProject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserFavoriteProjectRepository extends JpaRepository<UserLikeFavoriteProject, Integer> {
    List<UserLikeFavoriteProject> findByUser_Id(Long userId);
}

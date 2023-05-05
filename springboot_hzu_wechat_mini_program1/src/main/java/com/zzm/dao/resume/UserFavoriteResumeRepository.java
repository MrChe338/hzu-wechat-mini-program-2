package com.zzm.dao.resume;

// UserFavoriteResumeRepository.java

import com.zzm.pojo.resume.UserFavoriteResume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserFavoriteResumeRepository extends JpaRepository<UserFavoriteResume, Integer> {
    List<UserFavoriteResume> findByUser_Id(Long userid);
}


package com.zzm.dao.forum;

import com.zzm.pojo.Forum.Forum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ForumRepository extends JpaRepository<Forum, Integer> {
    List<Forum> findByUser_Id(Long userId);
}


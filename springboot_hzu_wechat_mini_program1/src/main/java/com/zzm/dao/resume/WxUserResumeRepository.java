package com.zzm.dao.resume;

// WxUserResumeRepository.java

import com.zzm.pojo.resume.WxUserResume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WxUserResumeRepository extends JpaRepository<WxUserResume, Integer> {
    List<WxUserResume> findByIdIn(List<Integer> ids);
}


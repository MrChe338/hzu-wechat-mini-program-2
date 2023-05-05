package com.zzm.dao.resume;

// UserResumeRepository.java

import com.zzm.pojo.resume.WxUserResume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserResumeRepository extends JpaRepository<WxUserResume, Integer> {
}


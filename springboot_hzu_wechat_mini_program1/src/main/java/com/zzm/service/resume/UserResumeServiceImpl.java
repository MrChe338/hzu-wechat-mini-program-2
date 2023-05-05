package com.zzm.service.resume;

import com.zzm.dao.resume.UserResumeRepository;
import com.zzm.pojo.resume.WxUserResume;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserResumeServiceImpl implements UserResumeService {

    @Autowired
    private UserResumeRepository userResumeRepository;

    @Override
    public WxUserResume saveUserResume(WxUserResume userResume) {
        System.out.println("userId: " + userResume.getUser());

        return userResumeRepository.save(userResume);
    }
}

package com.zzm.service.resume;

import com.zzm.dao.resume.WxUserResumeRepository;
import com.zzm.pojo.resume.WxUserResume;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WxUserResumeService {

    @Autowired
    private WxUserResumeRepository wxUserResumeRepository;

    public List<WxUserResume> getAllResumes() {
        return wxUserResumeRepository.findAll();
    }
}

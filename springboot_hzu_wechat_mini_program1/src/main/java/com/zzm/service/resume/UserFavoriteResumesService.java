package com.zzm.service.resume;

// UserService.java



import com.zzm.dao.resume.UserFavoriteResumeRepository;
import com.zzm.dao.resume.WxUserResumeRepository;
import com.zzm.pojo.resume.UserFavoriteResume;
import com.zzm.pojo.resume.WxUserResume;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserFavoriteResumesService {

    @Autowired
    private UserFavoriteResumeRepository userFavoriteResumeRepository;

    @Autowired
    private WxUserResumeRepository wxUserResumeRepository;

    public List<WxUserResume> getUserFavoriteResumes(Long userId) {
        List<Integer> resumeIds = userFavoriteResumeRepository.findByUser_Id(userId)
                .stream()
                .map(UserFavoriteResume::getResume_id)
                .collect(Collectors.toList());

        return wxUserResumeRepository.findByIdIn(resumeIds);
    }
}


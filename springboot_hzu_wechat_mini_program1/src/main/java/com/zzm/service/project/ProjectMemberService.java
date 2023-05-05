package com.zzm.service.project;

import com.zzm.dao.project.ProjectMemberRepository;
import com.zzm.pojo.project.ProjectMember;
import org.springframework.stereotype.Service;

@Service
public class ProjectMemberService {

    private ProjectMemberRepository projectMemberRepository;

    public ProjectMember saveProjectMember(ProjectMember member) {
        return projectMemberRepository.save(member);
    }


}


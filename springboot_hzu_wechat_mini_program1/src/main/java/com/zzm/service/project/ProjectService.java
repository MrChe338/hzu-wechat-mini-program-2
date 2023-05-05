package com.zzm.service.project;

import com.zzm.dao.project.ProjectMemberRepository;
import com.zzm.dao.project.ProjectRepository;
import com.zzm.dto.ProjectDto;
import com.zzm.pojo.project.Project;
import com.zzm.pojo.project.ProjectDto1;
import com.zzm.pojo.project.ProjectMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;

import java.util.List;
import java.util.UUID;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private ProjectMemberRepository projectMemberRepository;

    public List<Project> getProjectListWithMembers() {
        List<Project> projects = projectRepository.findAll();
//        List<ProjectDto> projectDtoList = new ArrayList<>();
//
//        for (Project project : projects) {
//            List<ProjectMember> projectMembers = projectMemberRepository.findByProject_Uuid(project.getUuid());
//            ProjectDto projectDto = new ProjectDto(project, projectMembers);
//            projectDtoList.add(projectDto);
//        }

        return projects;
    }

    public Project saveProject(ProjectDto1 projectDto) {
        Project project = projectDto.getProject();
        List<ProjectMember> projectMembers = projectDto.getProjectMembers();
        project.setCreateTime(Timestamp.valueOf(LocalDateTime.now()));
        UUID uuid = UUID.fromString(UUID.randomUUID().toString());
        project.setUuid(uuid);

        // 先保存Project，以便获得持久化的ID和UUID
        project = projectRepository.save(project);

        for (ProjectMember projectMember : projectMembers) {
            projectMember.setProject(project);
        }

        project.setProjectMembers(projectMembers);

        // 现在，ProjectMember对象可以使用Project的ID和UUID了
        projectMemberRepository.saveAll(projectMembers);

        return project;
    }
    public List<Project> searchProjects(String projectName, String nickname) {
        return projectRepository.findByProjectNameContainingOrUser_NicknameContaining(projectName, nickname);
    }

    public List<Project> getProjectsOrderByCreateTime() {
        return projectRepository.findAllByOrderByCreateTimeDesc();
    }
    public List<Project> getProjectsOrderByPopularity() {
        return projectRepository.findAllOrderByPopularity();
    }


}



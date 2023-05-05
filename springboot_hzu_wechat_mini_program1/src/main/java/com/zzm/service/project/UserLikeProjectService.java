package com.zzm.service.project;

// UserService.java


import com.zzm.dao.project.ProjectRepository;
import com.zzm.dao.project.UserFavoriteProjectRepository;
import com.zzm.pojo.project.Project;
import com.zzm.pojo.project.UserLikeFavoriteProject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserLikeProjectService {

    @Autowired
    private UserFavoriteProjectRepository userFavoriteProjectRepository;

    @Autowired
    private ProjectRepository projectLibraryRepository;

    public List<Project> getUserFavoriteProjects(Long userId) {
        List<UserLikeFavoriteProject> favoriteProjects = userFavoriteProjectRepository.findByUser_Id(userId);
        List<Integer> projectIds = favoriteProjects.stream().map(UserLikeFavoriteProject::getProjectId).collect(Collectors.toList());
        return projectLibraryRepository.findByIdIn(projectIds);
    }
}


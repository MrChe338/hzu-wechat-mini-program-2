package com.zzm.dto;



import com.zzm.pojo.project.Project;
import com.zzm.pojo.project.ProjectMember;

import java.util.List;

public class ProjectDto {
    private Project project;
    private List<ProjectMember> projectMembers;

    public ProjectDto(Project project, List<ProjectMember> projectMembers) {
        this.project = project;
        this.projectMembers = projectMembers;
    }

    // Getter 和 Setter
    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public List<ProjectMember> getProjectMembers() {
        return projectMembers;
    }

    public void setProjectMembers(List<ProjectMember> projectMembers) {
        this.projectMembers = projectMembers;
    }
}

package com.zzm.pojo.project;

import java.io.Serializable;
import java.util.List;

public class ProjectDto1 implements Serializable {
    private Project project;
    private List<ProjectMember> projectMembers;

    // Getter 和 Setter...

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

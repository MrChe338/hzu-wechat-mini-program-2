package com.zzm.pojo.project;

import java.util.List;

public class ProjectAndMembers {
    private Project project;
    private List<ProjectMember> members;

    // Getter 和 Setter
    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public List<ProjectMember> getMembers() {
        return members;
    }

    public void setMembers(List<ProjectMember> members) {
        this.members = members;
    }
}

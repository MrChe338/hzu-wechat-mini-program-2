package com.zzm.pojo.project;

// ProjectMember.java
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.zzm.pojo.User;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "project_members")
public class ProjectMember implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String avatar;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "uuid", referencedColumnName = "uuid")
    private Project project;
    public Project getProject() {
        return this.project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
    // Getter 和 Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User userId) {
        this.user = userId;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }


}

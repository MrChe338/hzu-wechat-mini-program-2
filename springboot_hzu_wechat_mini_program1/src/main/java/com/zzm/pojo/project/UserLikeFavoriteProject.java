package com.zzm.pojo.project;

// UserFavoriteProject.java

import com.zzm.pojo.User;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "user_favorite_projects")
public class UserLikeFavoriteProject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "project_id", nullable = false)
    private Integer projectId;

    @Column(name = "created_at", nullable = false)
    private Timestamp createdAt;

    public UserLikeFavoriteProject() {
    }

    public UserLikeFavoriteProject(User userId, Integer projectId, Timestamp createdAt) {
        this.user = userId;
        this.projectId = projectId;
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User userId) {
        this.user = userId;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}


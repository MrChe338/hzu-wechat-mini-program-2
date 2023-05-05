package com.zzm.pojo.project;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.zzm.pojo.User;

import javax.persistence.*;
import java.io.Serializable;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;


@Entity
@Table(name = "project_library")
public class Project implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "project_name")
    private String projectName;
    @Column(name = "college_affiliation")
    private String collegeAffiliation;
    @Column(name = "project_leader")
    private String projectLeader;

    @Enumerated(EnumType.STRING)
    private Status status;
    private String tags;
    @Column(name = "background_img")
    private String backgroundImg;
    @Enumerated(EnumType.STRING)
    @Column(name = "project_type")
    private ProjectType projectType;
    @Column(name = "project_intro")
    private String projectIntro;
    @Column(name = "award_experience")
    private String awardExperience;
    @Column(name = "recruit_requirements")
    private String recruitRequirements;
    private String attachment;
    @ManyToOne
    @JoinColumn(name = "userid")
    private User user;

    @Column(name = "likes")
    private int likes;

    @Column(name = "favorites")
    private int favorites;

    @Column(name = "create_time")
    private Timestamp createTime;

    @Column(name = "uuid")
    private UUID uuid;
    @JsonManagedReference
    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private List<ProjectMember> projectMembers;

    // Getter 和 Setter...
    public List<ProjectMember> getProjectMembers() {
        return this.projectMembers;
    }

    public void setProjectMembers(List<ProjectMember> projectMembers) {
        this.projectMembers = projectMembers;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getCollegeAffiliation() {
        return collegeAffiliation;
    }

    public void setCollegeAffiliation(String collegeAffiliation) {
        this.collegeAffiliation = collegeAffiliation;
    }

    public String getProjectLeader() {
        return projectLeader;
    }

    public void setProjectLeader(String projectLeader) {
        this.projectLeader = projectLeader;
    }



    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getBackgroundImg() {
        return backgroundImg;
    }

    public void setBackgroundImg(String backgroundImg) {
        this.backgroundImg = backgroundImg;
    }

    public ProjectType getProjectType() {
        return projectType;
    }

    public void setProjectType(ProjectType projectType) {
        this.projectType = projectType;
    }

    public String getProjectIntro() {
        return projectIntro;
    }

    public void setProjectIntro(String projectIntro) {
        this.projectIntro = projectIntro;
    }

    public String getAwardExperience() {
        return awardExperience;
    }

    public void setAwardExperience(String awardExperience) {
        this.awardExperience = awardExperience;
    }

    public String getRecruitRequirements() {
        return recruitRequirements;
    }

    public void setRecruitRequirements(String recruitRequirements) {
        this.recruitRequirements = recruitRequirements;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getFavorites() {
        return favorites;
    }

    public void setFavorites(int favorites) {
        this.favorites = favorites;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }


}

enum Status {
    active,
    deleted
}

enum ProjectType {
    老师,
    学生
}




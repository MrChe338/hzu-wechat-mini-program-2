package com.zzm.pojo.resume;

// WxUserResume.java

import com.fasterxml.jackson.annotation.JsonProperty;
import com.zzm.pojo.User;

import javax.persistence.*;



@Entity
@Table(name = "wx_user_resume")
public class WxUserResume {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @ManyToOne
    @JoinColumn(name = "userid")
    private User user;
    @Column(name = "name")
    private String name;

    @Column(name = "gender")
    private Integer gender;

    @Column(name = "grade")
    private String grade;

    @Column(name = "college")
    private String college;

    @Column(name = "major")
    private String major;

    @Column(name = "tags")
    private String tags;

    @Column(name = "background_img")
    private String backgroundImg;

    @Column(name = "introduction")
    private String introduction;

    @Column(name = "skills")
    private String skills;

    @Column(name = "hobbies")
    private String hobbies;

    @Column(name = "projects")
    private String projects;

    @Column(name = "awards")
    private String awards;

    @Column(name = "others")
    private String others;

    @Column(name = "project_intention")
    private String projectIntention;

    @Column(name = "attachments")
    private String attachments;

    @Column(name = "is_into_talent_pool")
    private Integer isIntoTalentPool;

    @Column(name = "likes")
    private Integer likes;

    @Column(name = "favorites")
    private Integer favorites;

    public Integer getId() {
        return id;
    }
    public int getLikes() {
        return likes == null ? 0 : likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public int getFavorites() {
        return favorites == null ? 0 : favorites;
    }

    public void setFavorites(Integer favorites) {
        this.favorites = favorites;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
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

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getHobbies() {
        return hobbies;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }

    public String getProjects() {
        return projects;
    }

    public void setProjects(String projects) {
        this.projects = projects;
    }

    public String getAwards() {
        return awards;
    }

    public void setAwards(String awards) {
        this.awards = awards;
    }

    public String getOthers() {
        return others;
    }

    public void setOthers(String others) {
        this.others = others;
    }

    public String getProjectIntention() {
        return projectIntention;
    }

    public void setProjectIntention(String projectIntention) {
        this.projectIntention = projectIntention;
    }

    public String getAttachments() {
        return attachments;
    }

    public void setAttachments(String attachments) {
        this.attachments = attachments;
    }

    public Integer getIsIntoTalentPool() {
        return isIntoTalentPool;
    }

    public void setIsIntoTalentPool(Integer isIntoTalentPool) {
        this.isIntoTalentPool = isIntoTalentPool;
    }

    @Override
    public String toString() {
        return "WxUserResume{" +
                "id=" + id +
                ", user=" + user +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", grade='" + grade + '\'' +
                ", college='" + college + '\'' +
                ", major='" + major + '\'' +
                ", tags='" + tags + '\'' +
                ", backgroundImg='" + backgroundImg + '\'' +
                ", introduction='" + introduction + '\'' +
                ", skills='" + skills + '\'' +
                ", hobbies='" + hobbies + '\'' +
                ", projects='" + projects + '\'' +
                ", awards='" + awards + '\'' +
                ", others='" + others + '\'' +
                ", projectIntention='" + projectIntention + '\'' +
                ", attachments='" + attachments + '\'' +
                ", isIntoTalentPool=" + isIntoTalentPool +
                '}';
    }
}



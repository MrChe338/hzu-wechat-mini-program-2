package com.zzm.pojo.Forum;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.zzm.pojo.User;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "forum_reply")
public class ForumReply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String content;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "forum_id")
    private Forum forum;

    @Column(name = "create_time")
    private Timestamp createTime;

    @Column(name = "like_count")
    private Integer likeCount;

    // Getter and setter for id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    // Getter and setter for content
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    // Getter and setter for user
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    // Getter and setter for forum
    public Forum getForum() {
        return forum;
    }

    public void setForum(Forum forum) {
        this.forum = forum;
    }

    // Getter and setter for createTime
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    // Getter and setter for likeCount
    public Integer getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }
}


package com.zzm.pojo.Forum;

import com.zzm.pojo.User;


import javax.persistence.*;

@Entity
@Table(name = "forum_likes")
public class ForumLike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//主键跟数据库一一对应
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "forum_id")
    private Forum forum;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // getter and setter for id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    // getter and setter for forum
    public Forum getForum() {
        return forum;
    }

    public void setForum(Forum forum) {
        this.forum = forum;
    }

    // getter and setter for user
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}


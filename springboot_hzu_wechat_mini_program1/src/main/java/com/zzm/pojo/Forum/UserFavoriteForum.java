package com.zzm.pojo.Forum;

// UserFavoriteForum.java

import com.zzm.pojo.User;

import javax.persistence.*;

@Entity
@Table(name = "user_favorite_forum")
public class UserFavoriteForum {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "userid")
    private User user;


    @ManyToOne
    @JoinColumn(name = "forum_id")
    private Forum forum;

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

    public Forum getForum() {
        return forum;
    }

    public void setForum(Forum forum) {
        this.forum = forum;
    }
}

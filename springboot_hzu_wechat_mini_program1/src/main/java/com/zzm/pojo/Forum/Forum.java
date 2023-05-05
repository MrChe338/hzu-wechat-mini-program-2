package com.zzm.pojo.Forum;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.zzm.pojo.User;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "forum")
public class Forum {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;
    private String content;
    @ManyToOne
    @JoinColumn(name = "userid")
    private User user;
    private Integer reply_count;
    private Integer like_count;
    private Integer follow_count;
    private String image;
    private String tags;
    private String invited_wechat_name;
    private String invited_wechat_avatar;
    private Timestamp create_time;
    private Integer is_high_quality;
    @JsonManagedReference
    @OneToMany(mappedBy = "forum", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ForumReply> replies;

    public List<ForumReply> getReplies() {
        return replies;
    }

    public void setReplies(List<ForumReply> replies) {
        this.replies = replies;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User userid) {
        this.user = userid;
    }

    public Integer getReply_count() {
        return reply_count;
    }

    public void setReply_count(Integer reply_count) {
        this.reply_count = reply_count;
    }

    public Integer getLike_count() {
        return like_count;
    }

    public void setLike_count(Integer like_count) {
        this.like_count = like_count;
    }

    public Integer getFollow_count() {
        return follow_count;
    }

    public void setFollow_count(Integer follow_count) {
        this.follow_count = follow_count;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getInvited_wechat_name() {
        return invited_wechat_name;
    }

    public void setInvited_wechat_name(String invited_wechat_name) {
        this.invited_wechat_name = invited_wechat_name;
    }

    public String getInvited_wechat_avatar() {
        return invited_wechat_avatar;
    }

    public void setInvited_wechat_avatar(String invited_wechat_avatar) {
        this.invited_wechat_avatar = invited_wechat_avatar;
    }

    public Timestamp getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Timestamp create_time) {
        this.create_time = create_time;
    }

    public Integer getIs_high_quality() {
        return is_high_quality;
    }

    public void setIs_high_quality(Integer is_high_quality) {
        this.is_high_quality = is_high_quality;
    }
}


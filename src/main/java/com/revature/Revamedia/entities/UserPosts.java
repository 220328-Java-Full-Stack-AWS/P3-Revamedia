package com.revature.Revamedia.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "user_posts", schema = "public")
public class UserPosts implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Integer postId;

    @ManyToOne()
    @JoinColumn(name = "owner_id", referencedColumnName = "user_id")
    private User ownerId;

    @OneToMany(mappedBy = "postId")
    @Column(name = "post_comments")
    private List<UserComments> comments;


    @Column(name ="message", length=500)
    private String message;

    @Column(name ="youtube_link")
    private String youtubeLink;

    @Column(name ="image")
    private String image;

    @Column(name ="likes")
    private int likes;

    @Column(name ="post_lifetime", nullable = true)
    private String postLifetime;

    @Column(name ="date_created")
    private String dateCreated;

    public UserPosts() {
    }

    public UserPosts(Integer postId, User ownerId, List<UserComments> comments, String message, String youtubeLink, String image, int likes, String postLifetime, String dateCreated) {
        this.postId = postId;
        this.ownerId = ownerId;
        this.comments = comments;
        this.message = message;
        this.youtubeLink = youtubeLink;
        this.image = image;
        this.likes = likes;
        this.postLifetime = postLifetime;
        this.dateCreated = dateCreated;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public User getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(User ownerId) {
        this.ownerId = ownerId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getYoutubeLink() {
        return youtubeLink;
    }

    public void setYoutubeLink(String youtubeLink) {
        this.youtubeLink = youtubeLink;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public String getPostLifetime() {
        return postLifetime;
    }

    public void setPostLifetime(String postLifetime) {
        this.postLifetime = postLifetime;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public List<UserComments> getComments() {
        return comments;
    }

    public void setComments(List<UserComments> comments) {
        this.comments = comments;
    }

    private void addComment (UserComments comment){
        this.comments.add(comment);
    }

    private void removeComment (UserComments comment) {
        this.comments.remove(comment);
    }

    @Override
    public String toString() {
        return "UserPosts{" +
                "postId=" + postId +
                ", ownerId=" + ownerId +
                ", comments=" + comments +
                ", message='" + message + '\'' +
                ", youtubeLink='" + youtubeLink + '\'' +
                ", image='" + image + '\'' +
                ", likes=" + likes +
                ", postLifetime='" + postLifetime + '\'' +
                ", dateCreated='" + dateCreated + '\'' +
                '}';
    }
}

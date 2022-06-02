package com.revature.Revamedia.entities;
/**
 * Author(s): @Brandon Le, @Tony Henderson
 * Contributor(s):
 * Purpose:
 */


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "user_comments", schema = _SchemaName.schemaName)
public class UserComments implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Integer commentId;



    @JsonIgnore

    @JsonBackReference

    @ManyToOne()
    @JoinColumn(name = "owner_id", referencedColumnName = "user_id")
    private User ownerId;



    @JsonIgnore
    @JsonBackReference
    @ManyToOne()
    @JoinColumn(name = "post_id", referencedColumnName = "post_id")
    private UserPosts postId;



    @JsonIgnore
    @JsonManagedReference
    @OneToMany(mappedBy = "commentId", cascade = CascadeType.ALL)
    private List<UserReplies> replies;

    @Column(name = "message", length = 500)
    private String message;

    @Column(name = "date_created")
    private String dateCreated;

    public UserComments() {
        this.replies = new ArrayList<>();
    }

    public UserComments(Integer commentId, User ownerId, UserPosts postId, List<UserReplies> replies, String message, String dateCreated) {
        this.commentId = commentId;
        this.ownerId = ownerId;
        this.postId = postId;
        this.replies = replies;
        this.message = message;
        this.dateCreated = dateCreated;

    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public User getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(User ownerId) {
        this.ownerId = ownerId;
    }

    public UserPosts getPostId() {
        return postId;
    }

    public void setPostId(UserPosts postId) {
        this.postId = postId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public List<UserReplies> getReplies() {
        return replies;
    }

    public void setReplies(List<UserReplies> replies) {
        this.replies = replies;
    }

    public void addReply(UserReplies reply) {
        this.replies.add(reply);
    }


    public void removeReply(UserReplies reply) {
        this.replies.remove(reply);
    }

    @Override
    public String toString() {
        return "UserComments{" +
                "commentId=" + commentId +
                ", ownerId=" + ownerId +
                ", replies=" + replies +
                ", message='" + message + '\'' +
                ", dateCreated='" + dateCreated + '\'' +
                '}';
    }
}

package com.niit.JustBlogBackEnd.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Component("comments")
public class Comments {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
     private int commentId;
	 private String commentbody;
	
	 @ManyToOne(cascade=CascadeType.PERSIST)
	 private UserDetails user;
	 @JsonBackReference(value="blogcomment_managing")
	 @ManyToOne(cascade=CascadeType.PERSIST)
	 private Blog blog;
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public String getCommentbody() {
		return commentbody;
	}
	public void setCommentbody(String commentbody) {
		this.commentbody = commentbody;
	}
	public UserDetails getUser() {
		return user;
	}
	public void setUser(UserDetails user) {
		this.user = user;
	}
	public Blog getBlog() {
		return blog;
	}
	public void setBlog(Blog blog) {
		this.blog = blog;
	}
	 
	
}

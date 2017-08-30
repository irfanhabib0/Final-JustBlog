package com.niit.JustBlogBackEnd.model;

import java.sql.Date;
import java.util.ArrayList;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Component("blog")

public class Blog extends BaseDomain {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int blogId;
	private String title;
	private String description;
	// private Date createDate;
	private char status;

	private String reason;
	private int likes;
	private int views;

	@ManyToOne(cascade = CascadeType.PERSIST)
/*	@JsonBackReference(value = "userblog")*/
	private UserDetails user;
	@JsonManagedReference(value = "blogcomment_managing")
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "blog", cascade = CascadeType.ALL)
	private List<Comments> comments = new ArrayList<Comments>();

	public int getBlogId() {
		return blogId;
	}

	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public List<Comments> getComments() {
		return comments;
	}

	public void setComments(List<Comments> comments) {
		this.comments = comments;
	}

	public UserDetails getUser() {
		return user;
	}

	public void setUser(UserDetails user) {
		this.user = user;
	}
//	 public Date getCreateDate() {
//	 return createDate;
//	 }
//	 public void setCreateDate(Date createDate) {
//	 this.createDate = createDate;
//	 }

}

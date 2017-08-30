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
@Component("forumcomments")
public class Forum_comment extends BaseDomain {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int forumcmmntId;
	private String forumcmmntbody;
	@ManyToOne(cascade = CascadeType.PERSIST)
	private UserDetails user;
	@JsonBackReference(value = "forumcomment_managing")
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Forum forum;

	public int getForumcmmntId() {
		return forumcmmntId;
	}

	public void setForumcmmntId(int forumcmmntId) {
		this.forumcmmntId = forumcmmntId;
	}

	public String getForumcmmntbody() {
		return forumcmmntbody;
	}

	public void setForumcmmntbody(String forumcmmntbody) {
		this.forumcmmntbody = forumcmmntbody;
	}

	public UserDetails getUser() {
		return user;
	}

	public void setUser(UserDetails user) {
		this.user = user;
	}

	public Forum getForum() {
		return forum;
	}

	public void setForum(Forum forum) {
		this.forum = forum;
	}

}

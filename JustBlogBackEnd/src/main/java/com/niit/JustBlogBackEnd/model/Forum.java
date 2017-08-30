package com.niit.JustBlogBackEnd.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Component("frum")
public class Forum extends BaseDomain{
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int forumId;
	private String title;
	private String forum_descripton;
	private Date dateTime;
	@ManyToOne(cascade = CascadeType.PERSIST)
	private UserDetails user;
	@JsonManagedReference(value="forumcomment_managing")
	@OneToMany(fetch=FetchType.EAGER,mappedBy="forum",cascade=CascadeType.ALL)
	private List<Forum_comment> forumcmmnts= new ArrayList<Forum_comment>();
	
	public int getForumId() {
		return forumId;
	}
	public void setForumId(int forumId) {
		this.forumId = forumId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getForum_descripton() {
		return forum_descripton;
	}
	public void setForum_descripton(String forum_descripton) {
		this.forum_descripton = forum_descripton;
	}
	public Date getDateTime() {
		return dateTime;
	}
	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}
	public UserDetails getUser() {
		return user;
	}
	public void setUser(UserDetails user) {
		this.user = user;
	}
	
	

}

package com.niit.JustBlog.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Component
@Entity

public class ForumComment {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int forumCommentId;
	
	private String Comment;
	
	private Date postedDate;
	
	public int getForumCommentId() {
		return forumCommentId;
	}

	public void setForumCommentId(int forumCommentId) {
		this.forumCommentId = forumCommentId;
	}

	public String getComment() {
		return Comment;
	}

	public void setComment(String comment) {
		Comment = comment;
	}

	public Date getPostedDate() {
		return postedDate;
	}

	public void setPostedDate(Date postedDate) {
		this.postedDate = postedDate;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	private int userId;
	

}

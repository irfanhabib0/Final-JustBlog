package com.niit.JustBlogBackEnd.Dao;

import java.util.List;

import com.niit.JustBlogBackEnd.model.Comments;

public interface CommentDao {
	public List<Comments> getAllComments();
	public boolean addComment(Comments comments);

}

package com.niit.JustBlog.dao;

import java.util.List;

import com.niit.JustBlog.model.Comment;

public interface commentDao {
	public List<Comment> getall();
	public boolean save(Comment comment);
	public boolean update(Comment comment);
	public Comment getId(int id);


}

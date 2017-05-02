package com.niit.JustBlog.dao;

import java.util.List;

import com.niit.JustBlog.model.Forum;

public interface forumDao {
	public List<Forum> getall();
	public boolean save(Forum forum);
	public boolean update(Forum forum);
	public Forum getId(int id);

}

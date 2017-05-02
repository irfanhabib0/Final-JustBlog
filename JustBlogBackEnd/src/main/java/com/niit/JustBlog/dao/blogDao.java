package com.niit.JustBlog.dao;

import java.util.List;

import com.niit.JustBlog.model.Blog;
import com.niit.JustBlog.model.UserDetails;

public interface blogDao {
	public List<Blog> getall();
	public boolean save(Blog blog);
	public boolean update(Blog blog);
	public Blog getId(int id);

}

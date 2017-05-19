package com.niit.JustBlogBackEnd.Dao;

import java.util.List;

import com.niit.JustBlogBackEnd.model.Blog;




public interface BlogDao {
	public List<Blog> getAll();
	public boolean save(Blog blog);
	public boolean update(Blog blog);
	public boolean deleteBlog(Blog blog);
	public Blog getById(int blogId);
	public List<Blog>  getByUserId(int id);
}

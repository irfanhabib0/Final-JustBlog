package com.niit.JustBlog.dao;

import java.util.List;

import com.niit.JustBlog.model.Job;

public interface jobDao {
	public List<Job> getall();
	public boolean save(Job job);
	public boolean update(Job job);
	public Job getId(int id);


}

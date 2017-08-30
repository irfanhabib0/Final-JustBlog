package com.niit.JustBlogBackEnd.Dao;

import java.util.List;


import com.niit.JustBlogBackEnd.model.Job;

public interface JobDao {
	public List<Job> getAllJob();
	public boolean save (Job job);
	public boolean update(Job job);
	public boolean deleteJob(Job job);
	public Job getByjobId(int jobId);
	

}

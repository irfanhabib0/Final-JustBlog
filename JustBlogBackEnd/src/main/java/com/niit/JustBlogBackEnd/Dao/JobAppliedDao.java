package com.niit.JustBlogBackEnd.Dao;

import java.util.List;


import com.niit.JustBlogBackEnd.model.JobApplied;

public interface JobAppliedDao {
	public List<JobApplied> getAllappliedJob();
	public boolean save (JobApplied jobapp);
	public boolean update(JobApplied jobapp);
	public boolean deleteJob(JobApplied jobapp);
	public JobApplied getByjobappId(int jobAppliedId);
	

}

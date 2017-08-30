package com.niit.JustBlogBackEnd;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.JustBlogBackEnd.Dao.JobAppliedDao;
import com.niit.JustBlogBackEnd.Dao.JobDao;
import com.niit.JustBlogBackEnd.Dao.UserDao;
import com.niit.JustBlogBackEnd.model.Job;
import com.niit.JustBlogBackEnd.model.JobApplied;

public class JobAppliedDaoTestCase {
	private static Job job;
	private static JobDao jobDao;
	private static JobApplied jobapp;
	private static JobAppliedDao jobappDao;
	private static UserDao usd;
	
	@BeforeClass
	public static void init()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
        context.refresh();
        
        job=(Job) context.getBean("job");
        jobDao=(JobDao) context.getBean("jobDao");
        jobapp=(JobApplied) context.getBean("jobapp");
        jobappDao=(JobAppliedDao) context.getBean("jobappDao");
        usd=(UserDao) context.getBean("usd");
	}
	@Test
	public void createJobAppliedDaoTestCase()
	{
		jobapp.setStatus('A');
		jobapp.setRemarks("all jobs are about kolkata and bangalore");
		
		jobapp.setAppliedDate(new Date());
		jobapp.setJob(jobDao.getByjobId(343));	
		jobapp.setUser(usd.getId(121));
		boolean flag=jobappDao.save(jobapp);
		assertEquals("createJobAppliedDaoTestCase",true,flag);
		
	}
	
//	@Test
//	public void listJobAppliedDaoTestCase()	{
//	 List<JobApplied> jp=	jobappDao.getAllappliedJob();
//	 assertEquals("listJobAppliedDaoTestCase",1,jp.size());
//	}


}

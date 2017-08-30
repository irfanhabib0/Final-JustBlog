package com.niit.JustBlogBackEnd;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.niit.JustBlogBackEnd.Dao.JobDao;
import com.niit.JustBlogBackEnd.Dao.UserDao;
import com.niit.JustBlogBackEnd.model.Job;

public class JobDaoTestCase {
	private static Job job;
	private static JobDao jobDao;
	private static UserDao usd;
	
	@BeforeClass
	public static void init()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
        context.refresh();
        
        job=(Job) context.getBean("job");
        jobDao=(JobDao) context.getBean("jobDao");
        usd=(UserDao) context.getBean("usd");
	}
	
//	@Test
//	public void createBlogDaoTestCase()
//	{
//		job.setJob_title("Database Manegar");
//		job.setJob_description("database management through bigdata");
//		
//		job.setDateTime(new Date());
//		job.setQualification(" good knowledge in SQL,BigData Hadoop");		
//		job.setStatus('A');
//		
//		
//		boolean flag=jobDao.save(job);
//		assertEquals("createJobDaoTestCase",true,flag);
//	}

}

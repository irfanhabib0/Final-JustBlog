package com.niit.JustBlogBackEnd;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.JustBlogBackEnd.Dao.BlogDao;
import com.niit.JustBlogBackEnd.Dao.ForumDao;
import com.niit.JustBlogBackEnd.Dao.UserDao;
import com.niit.JustBlogBackEnd.model.Blog;
import com.niit.JustBlogBackEnd.model.Forum;

public class ForumDaoTestCase {
	private static Forum frum;
	private static UserDao usd;
	private static ForumDao forumDao;
	@BeforeClass
	public static void init()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
				context.scan("com.niit");
		        context.refresh();
		        
		        frum=(Forum) context.getBean("frum");
		        forumDao=(ForumDao) context.getBean("forumDao");
		        usd=(UserDao) context.getBean("usd");
		       // context.close();
	}
	
	@Test
	public void createForumDaoTestCase()
	{
		frum.setTitle("selection of president");
		frum.setForum_descripton("upcoming president selection");
		frum.setUser(usd.getId(587));
		
		
		
		boolean flag=forumDao.saveForum(frum);
		assertEquals("createForumDaoTestCase",true,flag);
	}

}

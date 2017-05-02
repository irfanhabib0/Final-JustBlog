package com.niit.JustBlog;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.JustBlog.dao.Userdao;
import com.niit.JustBlog.dao.blogDao;
import com.niit.JustBlog.model.Blog;
import com.niit.JustBlog.model.UserDetails;

public class blogDaoTestCase {
	@Autowired
	private static Blog blog;
	@Autowired
	private static blogDao blogdao;
	
	@BeforeClass
	public static void init()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
				context.scan("com.niit");
		        context.refresh();
		        
		        blog=(Blog) context.getBean("blog");
		        blogdao=(blogDao) context.getBean("blogdao");
	}
	
	@Test
	public void UserDaoTestCase()
	{
		blog.setDescription("our recrutment process");
		user.setPassword("pass");
		user.setAddress("barasat");
		user.setEmail("irf@yahoo.com");
		user.setMobile(45673);
		user.setRole("user");
		user.setStatus('c');
		
		boolean flag=userdao.save(user);
		assertEquals("UserDaoTestCase",true,flag);
	}

}

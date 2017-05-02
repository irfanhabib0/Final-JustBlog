package com.niit.JustBlog;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.JustBlog.dao.Userdao;
import com.niit.JustBlog.model.UserDetails;

public class UserDaoTestCase {

	@Autowired
	private static UserDetails user;
	@Autowired
	private static Userdao userdao;
	
	@BeforeClass
	public static void init()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
				context.scan("com.niit");
		        context.refresh();
		        
		        user=(UserDetails) context.getBean("user");
		        userdao=(Userdao) context.getBean("userdao");
	}
	
	@Test
	public void UserDaoTestCase()
	{
		user.setName("irfan");
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

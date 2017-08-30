package com.niit.JustBlogBackEnd;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.JustBlogBackEnd.Dao.UserDao;
import com.niit.JustBlogBackEnd.model.UserDetails;

public class UserDaoTestCase {
	
	private static UserDetails user;
	
	private static UserDao usd;
	@BeforeClass
	public static void init()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
				context.scan("com.niit");
		        context.refresh();
		        
		        user=(UserDetails) context.getBean("user");
		        usd=(UserDao) context.getBean("usd");
		       // context.close();
	}
	
//	@Test
//	public void UserDaoTestCase()
//	{
//		user.setName("shabnam");
//		user.setPassword("pass");
//		user.setAddress("Bardwan");
//		user.setEmail("shabnams07gmail.com");
//		user.setMobile(7654);
//		user.setRole("user");
//		user.setStatus('c');
//		
//		boolean flag=usd.save(user);
//		assertEquals("UserDaoTestCase",true,flag);
//	}
	
	
/*@Test
	public void listUserDaoTestCase()	{
	 List<UserDetails> us=	usd.getAll();
	 assertEquals("listUserDaoTestCase",2,us.size());
	}
	
*/
}

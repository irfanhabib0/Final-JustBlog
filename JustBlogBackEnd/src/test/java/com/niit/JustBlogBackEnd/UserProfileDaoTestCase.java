//package com.niit.JustBlogBackEnd;
//
//import static org.junit.Assert.*;
//
//import org.junit.BeforeClass;
//import org.junit.Test;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//
//import com.niit.JustBlogBackEnd.Dao.UserDao;
//import com.niit.JustBlogBackEnd.Dao.UserProfileDao;
//import com.niit.JustBlogBackEnd.model.UserDetails;
//import com.niit.JustBlogBackEnd.model.UserProfile;
//
//public class UserProfileDaoTestCase {
// private static UserProfile usrpf;
// private static UserProfileDao usrproff;
// @BeforeClass
//	public static void init()
//	{
//		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
//				context.scan("com.niit");
//		        context.refresh();
//		        
//		        usrpf=(UserProfile) context.getBean("usrpf");
//		        usrproff=(UserProfileDao) context.getBean("usrproff");
//		       // context.close();
//	}
// 
//	@Test
//	public void UserProfileDaoTestCase()
//	{
//		usrpf.getWork_experience("fouryears");
//		usrpf.getQualification("btech in EE");
//		usrpf.getUser();
//		usrpf.getCity();
//		
//		
//		
//		boolean flag=usrproff.addProfile(usrpf);
//		assertEquals("UserProfileDaoTestCase",true,flag);
//	}
//}

package com.niit.JustBlogBackEnd;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.JustBlogBackEnd.Dao.BlogDao;
import com.niit.JustBlogBackEnd.Dao.UserDao;
import com.niit.JustBlogBackEnd.model.Blog;
import com.niit.JustBlogBackEnd.model.UserDetails;

public class BlogDaoTestCase {
private static Blog blog;
private static UserDao usd;
	
	private static BlogDao blogDao;
	@BeforeClass
	public static void init()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
				context.scan("com.niit");
		        context.refresh();
		        
		        blog=(Blog) context.getBean("blog");
		        blogDao=(BlogDao) context.getBean("blogDao");
		        usd=(UserDao) context.getBean("usd");
		       // context.close();
	}
	
//	@Test
//	public void BlogDaoTestCase()
//	{
//		blog.setTitle("Automation in India");
//		blog.setDescription(" reduces panIndia Recruitment");
//		//blog.setDateTime(2016-11-16);
//		blog.setReason("for fastsoeed");
//		blog.setLikes(45);
//		blog.setViews(76);
//		blog.setStatus('c');
//		blog.setUsers(usd.getId(121));
//		
//		boolean flag=blogDao.save(blog);
//		assertEquals("BlogDaoTestCase",true,flag);
//	}
//	
	@Test
	public void listBlogDaoTestCase()	{
	 List<Blog> bg=	blogDao.getAll();
	 assertEquals("listBlogDaoTestCase",5,bg.size());
	}

//	@Test
//	public void updationBlogDaoTestCase()	{
//	 Blog ub=	 blogDao.getById(67);
//	 boolean flag=blogDao.update(ub);
//		assertEquals("BlogDaoTestCase",true,flag);
//	}
	
//	@Test
//	public void deletionBlogDaoTestCase(){
//		Blog db=blogDao.getById(67);
//		boolean flag=blogDao.deleteBlog(db);
//		assertEquals("BlogDaoTestCase",true,flag);
//	}
}
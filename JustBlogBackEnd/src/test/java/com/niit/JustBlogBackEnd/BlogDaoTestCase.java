package com.niit.JustBlogBackEnd;

import static org.junit.Assert.*;

import java.util.Date;
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
//	public void createBlogDaoTestCase()
//	{
//		blog.setTitle("Make  in India project");
//		blog.setDescription(" increases panIndia Recruitment and revenue");
//		
//		blog.setCreateDate(new java.sql.Date(System.currentTimeMillis()));
//		blog.setReason("for fastsoeed");
//		blog.setLikes(50);
//		blog.setViews(76);
//		blog.setStatus('c');
//		blog.setUser(usd.getId(121));
//		
//		boolean flag=blogDao.save(blog);
//		assertEquals("createBlogDaoTestCase",true,flag);
//	}
/*//	
	@Test
	public void listBlogDaoTestCase()	{
	 List<Blog> bg=	blogDao.getAll();
	 assertEquals("listBlogDaoTestCase",5,bg.size());
	}
*/
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

package com.niit.JustBlogBackEnd;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.JustBlogBackEnd.Dao.BlogDao;
import com.niit.JustBlogBackEnd.Dao.CommentDao;
import com.niit.JustBlogBackEnd.Dao.UserDao;
import com.niit.JustBlogBackEnd.model.Blog;
import com.niit.JustBlogBackEnd.model.Comments;

public class CommentDaoTestCase {
	private static Comments comments;
	private static UserDao usd;
	private static BlogDao blogDao;

	private static CommentDao commentDao;

	@BeforeClass
	public static void init() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.JustBlogBackEnd");
		context.refresh();

		comments = (Comments) context.getBean("comments");
		commentDao = (CommentDao) context.getBean("commentDao");
		usd = (UserDao) context.getBean("usd");
		blogDao=(BlogDao) context.getBean("blogDao");
		// context.close();
	}

//	@Test
//	public void CommentDaoTestCase() {
//		comments.setCommentbody("good");
//		comments.setBlog(blogDao.getById(104));
//		comments.setUser(usd.getId(1));
//		boolean flag = commentDao.addComment(comments);
//		assertEquals("CommentDaoTestCase", true, flag);
//	}

}

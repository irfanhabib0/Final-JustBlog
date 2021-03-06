package com.niit.JustBlogBackEnd.DaoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.query.Query;
import com.niit.JustBlogBackEnd.Dao.BlogDao;
import com.niit.JustBlogBackEnd.model.Blog;

@Repository("blogDao")
@Transactional

public class BlogDaoImpl implements BlogDao  {
	
	@Autowired
	private SessionFactory sessionFactory;

	public List<Blog> getAll() {
		return sessionFactory.getCurrentSession().createQuery("from Blog").getResultList();
	}

	public boolean save(Blog blog) {
		try{
			 sessionFactory.getCurrentSession().save(blog);
			 return true;
		}
			catch(HibernateException e){
				e.printStackTrace();
				return false;
			}
	}

	public boolean update(Blog blog) {
		try{
			 sessionFactory.getCurrentSession().update(blog);
			 return true;
		}
			catch(HibernateException e){
				e.printStackTrace();
				return false;
			}
	}

	public boolean deleteBlog(Blog blog) {
		try{
			 sessionFactory.getCurrentSession().delete(blog);
			 return true;
		}
			catch(HibernateException e){
				e.printStackTrace();
				return false;
			}
	}

	public Blog getById(int blogId) {
		return sessionFactory.getCurrentSession().get(Blog.class, blogId);
	}

	public List<Blog> getByUserId(int id) {
		return (List<Blog>) sessionFactory.getCurrentSession().createQuery("from Blog where user.id="+id).getResultList();
	}

}

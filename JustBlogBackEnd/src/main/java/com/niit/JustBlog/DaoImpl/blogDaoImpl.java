package com.niit.JustBlog.DaoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.JustBlog.dao.blogDao;
import com.niit.JustBlog.model.Blog;
import com.niit.JustBlog.model.UserDetails;

@Repository("blogDao")
@Transactional

public class blogDaoImpl implements blogDao {
    @Autowired
    private SessionFactory sessionFactory;
	@Override
	public List<Blog> getall() {
		
		return sessionFactory.getCurrentSession().createQuery("from Blog").list();
	}

	@Override
	public boolean save(Blog blog) {
		try{
			sessionFactory.getCurrentSession().save(blog);
			return true;
			}
			catch(Exception e){
				return false;
			}
	}

	@Override
	public boolean update(Blog blog) {
		try{
			sessionFactory.getCurrentSession().update(blog);;
			return true;
			}
			catch(Exception e){
				return false;
			}
	}

	@Override
	public Blog getId(int id) {
		return (Blog) sessionFactory.getCurrentSession().get(Blog.class, id);
	}

}

package com.niit.JustBlog.DaoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.JustBlog.dao.forumDao;
import com.niit.JustBlog.model.Event;
import com.niit.JustBlog.model.Forum;

@Repository("forumDao")
@Transactional
public class forumDaoImpl implements forumDao {
	 @Autowired
	    private SessionFactory sessionFactory;

	@Override
	public List<Forum> getall() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean save(Forum forum) {
		try{
			sessionFactory.getCurrentSession().save(forum);
			return true;
			}
			catch(Exception e){
				return false;
			}
	}

	@Override
	public boolean update(Forum forum) {
		try{
			sessionFactory.getCurrentSession().update(forum);;
			return true;
			}
			catch(Exception e){
				return false;
			}
	}

	@Override
	public Forum getId(int id) {
		return (Forum) sessionFactory.getCurrentSession().get(Forum.class, id);
	}
	

}

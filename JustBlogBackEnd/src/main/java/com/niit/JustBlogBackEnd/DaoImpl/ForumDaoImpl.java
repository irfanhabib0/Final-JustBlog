package com.niit.JustBlogBackEnd.DaoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.JustBlogBackEnd.Dao.ForumDao;
import com.niit.JustBlogBackEnd.model.Forum;

@Repository("forumDao")
@Transactional
public class ForumDaoImpl implements ForumDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	public List<Forum> getAllforums() {
		return sessionFactory.getCurrentSession().createQuery("from Forum").getResultList();
	}

	public boolean saveForum(Forum frum) {
		try{
			 sessionFactory.getCurrentSession().save(frum);
			 return true;
		}
			catch(HibernateException e){
				e.printStackTrace();
				return false;
			}
	}
	

	public boolean updateForum(Forum frum) {
		try{
			 sessionFactory.getCurrentSession().update(frum);
			 return true;
		}
			catch(HibernateException e){
				e.printStackTrace();
				return false;
			}
	}

	public boolean deleteForum(Forum frum) {
		try{
			 sessionFactory.getCurrentSession().delete(frum);
			 return true;
		}
			catch(HibernateException e){
				e.printStackTrace();
				return false;
			}
	}

}

package com.niit.JustBlogBackEnd.DaoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.JustBlogBackEnd.Dao.CommentDao;
import com.niit.JustBlogBackEnd.model.Comments;

@Repository("commentDao")
@Transactional
public class CommentDaoImpl implements CommentDao {
	@Autowired
	private SessionFactory sessionFactory;

	public List<Comments> getAllComments() {
		return sessionFactory.getCurrentSession().createQuery("from Comments").getResultList();
	}

	public boolean addComment(Comments comments) {
		try{
			 sessionFactory.getCurrentSession().save(comments);
			 return true;
		}
			catch(HibernateException e){
				e.printStackTrace();
				return false;
			}
	}

}

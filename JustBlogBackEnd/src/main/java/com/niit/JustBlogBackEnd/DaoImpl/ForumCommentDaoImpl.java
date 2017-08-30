package com.niit.JustBlogBackEnd.DaoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.JustBlogBackEnd.Dao.ForumCommentDao;
import com.niit.JustBlogBackEnd.model.Forum_comment;

@Repository("forumcommentDao")
@Transactional
public class ForumCommentDaoImpl implements ForumCommentDao {
	@Autowired
	private SessionFactory sessionFactory;

	public List<Forum_comment> getAllforumComments() {
		return sessionFactory.getCurrentSession().createQuery("from Forum_comment").getResultList();
	}

	public boolean addForumComment(Forum_comment forum_cmmnt) {
		try{
			 sessionFactory.getCurrentSession().save(forum_cmmnt);
			 return true;
		}
			catch(HibernateException e){
				e.printStackTrace();
				return false;
			}
	}

}

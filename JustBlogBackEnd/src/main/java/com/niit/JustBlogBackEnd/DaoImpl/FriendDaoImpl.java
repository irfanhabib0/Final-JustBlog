package com.niit.JustBlogBackEnd.DaoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.JustBlogBackEnd.Dao.FriendDao;
import com.niit.JustBlogBackEnd.model.Blog;
import com.niit.JustBlogBackEnd.model.Friends;

@Repository("friendDao")
@Transactional
public class FriendDaoImpl implements FriendDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	public boolean addFriend(Friends friend) {
		try{
			 sessionFactory.getCurrentSession().save(friend);
			 return true;
		}
			catch(HibernateException e){
				e.printStackTrace();
				return false;
			}
	}

	public boolean updateFriend(Friends f) {
		try{
			 sessionFactory.getCurrentSession().update(f);
			 return true;
		}
			catch(HibernateException e){
				e.printStackTrace();
				return false;
			}
	}

	public Friends alterFrndids(int frndid, int id) {
		return (Friends) sessionFactory.getCurrentSession().createQuery("from Friends where user.id='"+frndid+"' and friend.id='"+id+"'" ).uniqueResult();
	}

	public List<Friends> getAllMyfrnds(int id) {
		return sessionFactory.getCurrentSession().createQuery("from Friends where friend.id='"+id+"' and status='confirm'" ).list();
	}

	public List<Friends> viewAllFriendRequest(int id) {
		return sessionFactory.getCurrentSession().createQuery("from Friends where user.id='"+id+"' and status='new' and initiater='1'").list();
	}

	public List<Friends> viewAllFriendRequestCallToMe(int id) {
		return sessionFactory.getCurrentSession().createQuery("from Friends where user.id='"+id+"' and status='new' and initiater='0'").list();
	}

	

	
	
	

}

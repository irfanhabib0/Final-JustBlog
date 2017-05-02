package com.niit.JustBlog.DaoImpl;

import java.util.List;



import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.JustBlog.dao.Userdao;
import com.niit.JustBlog.model.UserDetails;



@Repository("userdao")
@Transactional
public class UserdaoImpl implements Userdao{
	@Autowired
	private SessionFactory sessionFactory;

	public List<UserDetails> getall() {
		
		return sessionFactory.getCurrentSession().createQuery("from UserDetails").list();
	}

	public boolean save(UserDetails user) {
		try{
		sessionFactory.getCurrentSession().save(user);
		return true;
		}
		catch(Exception e){
			return false;
		}
	}

	public boolean update(UserDetails user) {
		try{
			sessionFactory.getCurrentSession().update(user);;
			return true;
			}
			catch(Exception e){
				return false;
			}
	}

	public UserDetails getId(int id) {
		// TODO Auto-generated method stub
		return (UserDetails) sessionFactory.getCurrentSession().get(UserDetails.class, id);
	}

}

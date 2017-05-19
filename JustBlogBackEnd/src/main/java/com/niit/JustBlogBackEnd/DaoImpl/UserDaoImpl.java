package com.niit.JustBlogBackEnd.DaoImpl;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.JustBlogBackEnd.Dao.UserDao;
import com.niit.JustBlogBackEnd.model.UserDetails;

@Repository("usd")
@Transactional
public class UserDaoImpl implements UserDao {
	@Autowired
	private SessionFactory sessionFactory;


	public List<UserDetails> getAll() {
		return sessionFactory.getCurrentSession().createQuery("from UserDetails").getResultList();
	}

	public boolean save(UserDetails user) {
		try {
			sessionFactory.getCurrentSession().save(user);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean update(UserDetails user) {
		try {
			sessionFactory.getCurrentSession().update(user);
			;
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public UserDetails getId(int id) {
		return (UserDetails) sessionFactory.getCurrentSession().get(UserDetails.class, id);
	}

	public boolean deleteUser(UserDetails user) {
		try {
			sessionFactory.getCurrentSession().delete(user);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean validate(String email, String password) {
		Query query=sessionFactory.getCurrentSession().createQuery("from UserDetails where email=? and password=?");
		query.setString(0, email);
		query.setString(1, password);
		
		if(query.uniqueResult()==null){
			return false;
		}
		else{
			return true;
		}
	}

	public UserDetails getByEmail(String email) {
		UserDetails user;
		try
		{
			Query query= sessionFactory.getCurrentSession().createQuery("from UserDetails where email=?");
			query.setParameter(0, email);
			user=(UserDetails) query.uniqueResult();
			
		}
		catch(NoResultException e)
		{
			user=null;
		}
		return user;
	}

	

}

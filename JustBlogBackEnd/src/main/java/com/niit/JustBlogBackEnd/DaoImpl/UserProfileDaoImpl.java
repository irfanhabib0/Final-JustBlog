package com.niit.JustBlogBackEnd.DaoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.JustBlogBackEnd.Dao.UserProfileDao;
import com.niit.JustBlogBackEnd.model.Blog;
import com.niit.JustBlogBackEnd.model.UserProfile;

@Repository("usrproff")
@Transactional
public class UserProfileDaoImpl implements UserProfileDao {
	@Autowired
	private SessionFactory sessionFactory;

	public boolean addProfile(UserProfile usrpf) {
		try {
			sessionFactory.getCurrentSession().save(usrpf);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public List<UserProfile> getAlluserProfile() {
		return sessionFactory.getCurrentSession().createQuery("from UserProfile").getResultList();
	}

	public List<UserProfile> getuserProfileByUserId(int id) {
		return (List<UserProfile>) sessionFactory.getCurrentSession().createQuery("from UserProfile where user.id="+id).getResultList();
	}

}

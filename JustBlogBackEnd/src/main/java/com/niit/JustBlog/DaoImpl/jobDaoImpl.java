package com.niit.JustBlog.DaoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.JustBlog.dao.jobDao;
import com.niit.JustBlog.model.Job;
import com.niit.JustBlog.model.UserDetails;

@Repository("jobDao")
@Transactional
public class jobDaoImpl implements jobDao {
	 @Autowired
	    private SessionFactory sessionFactory;
	@Override
	public List<Job> getall() {
		return sessionFactory.getCurrentSession().createQuery("from Job").list();
	}

	@Override
	public boolean save(Job job) {
		try{
			sessionFactory.getCurrentSession().save(job);
			return true;
			}
			catch(Exception e){
				return false;
			}
	}

	@Override
	public boolean update(Job job) {
		try{
			sessionFactory.getCurrentSession().update(job);;
			return true;
			}
			catch(Exception e){
				return false;
			}
	}

	@Override
	public Job getId(int id) {
		return (Job) sessionFactory.getCurrentSession().get(Job.class, id);
	}

}

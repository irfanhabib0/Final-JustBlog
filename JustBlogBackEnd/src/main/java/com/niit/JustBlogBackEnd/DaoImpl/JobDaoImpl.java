package com.niit.JustBlogBackEnd.DaoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.JustBlogBackEnd.Dao.JobDao;

import com.niit.JustBlogBackEnd.model.Job;
@Repository("jobDao")
@Transactional
public class JobDaoImpl implements JobDao {
	
	@Autowired
	private SessionFactory sessionFactory;


	public List<Job> getAllJob() {
		return sessionFactory.getCurrentSession().createQuery("from Job").getResultList();
	}

	public boolean save(Job job) {
		try{
			 sessionFactory.getCurrentSession().save(job);
			 return true;
		}
			catch(HibernateException e){
				e.printStackTrace();
				return false;
			}
	}

	public boolean update(Job job) {
		try{
			 sessionFactory.getCurrentSession().update(job);
			 return true;
		}
			catch(HibernateException e){
				e.printStackTrace();
				return false;
			}
	}

	public boolean deleteJob(Job job) {
		try{
			 sessionFactory.getCurrentSession().delete(job);
			 return true;
		}
			catch(HibernateException e){
				e.printStackTrace();
				return false;
			}
	}
	

	public Job getByjobId(int jobId) {
		return sessionFactory.getCurrentSession().get(Job.class, jobId);
	}

}

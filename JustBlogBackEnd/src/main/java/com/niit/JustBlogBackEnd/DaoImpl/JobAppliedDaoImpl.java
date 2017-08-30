package com.niit.JustBlogBackEnd.DaoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.JustBlogBackEnd.Dao.JobAppliedDao;
import com.niit.JustBlogBackEnd.model.Job;
import com.niit.JustBlogBackEnd.model.JobApplied;
@Repository("jobappDao")
@Transactional
public class JobAppliedDaoImpl implements JobAppliedDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	public List<JobApplied> getAllappliedJob() {
		return sessionFactory.getCurrentSession().createQuery("from JobApplied").getResultList();
	}

	public boolean save(JobApplied jobapp) {
		try{
			 sessionFactory.getCurrentSession().save(jobapp);
			 return true;
		}
			catch(HibernateException e){
				e.printStackTrace();
				return false;
			}
	}

	public boolean update(JobApplied jobapp) {
		try{
			 sessionFactory.getCurrentSession().update(jobapp);
			 return true;
		}
			catch(HibernateException e){
				e.printStackTrace();
				return false;
			}
	}

	public boolean deleteJob(JobApplied jobapp) {
		try{
			 sessionFactory.getCurrentSession().delete(jobapp);
			 return true;
		}
			catch(HibernateException e){
				e.printStackTrace();
				return false;
			}
	}

	public JobApplied getByjobappId(int jobAppliedId) {
		return sessionFactory.getCurrentSession().get(JobApplied.class, jobAppliedId);
	}

}

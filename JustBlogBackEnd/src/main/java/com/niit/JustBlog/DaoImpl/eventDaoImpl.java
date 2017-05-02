package com.niit.JustBlog.DaoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.JustBlog.dao.eventDao;
import com.niit.JustBlog.model.Event;
import com.niit.JustBlog.model.Job;
@Repository("eventDao")
@Transactional
public class eventDaoImpl implements eventDao{
	 @Autowired
	    private SessionFactory sessionFactory;

	@Override
	public List<Event> getall() {
		return sessionFactory.getCurrentSession().createQuery("from Event").list();
	}

	@Override
	public boolean save(Event event) {
		try{
			sessionFactory.getCurrentSession().save(event);
			return true;
			}
			catch(Exception e){
				return false;
			}
	}

	@Override
	public boolean update(Event event) {
		try{
			sessionFactory.getCurrentSession().update(event);;
			return true;
			}
			catch(Exception e){
				return false;
			}
	}

	@Override
	public Event getId(int id) {
		return (Event) sessionFactory.getCurrentSession().get(Event.class, id);
	}

}

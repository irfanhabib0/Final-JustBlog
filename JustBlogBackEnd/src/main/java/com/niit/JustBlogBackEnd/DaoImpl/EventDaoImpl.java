package com.niit.JustBlogBackEnd.DaoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.JustBlogBackEnd.Dao.EventDao;
import com.niit.JustBlogBackEnd.model.Event;

@Repository("evntDao")
@Transactional
public class EventDaoImpl implements EventDao {

	@Autowired
	private SessionFactory sessionFactory;

	public List<Event> getAllevents() {
		return sessionFactory.getCurrentSession().createQuery("from Event").getResultList();
	}

	public boolean saveEvent(Event event) {
		try{
			 sessionFactory.getCurrentSession().save(event);
			 return true;
		}
			catch(HibernateException e){
				e.printStackTrace();
				return false;
			}
	}

}

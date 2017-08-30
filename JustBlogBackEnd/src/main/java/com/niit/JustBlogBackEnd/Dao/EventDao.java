package com.niit.JustBlogBackEnd.Dao;

import java.util.List;

import com.niit.JustBlogBackEnd.model.Event;


public interface EventDao {
	public List<Event> getAllevents();
	public boolean saveEvent(Event event);

}

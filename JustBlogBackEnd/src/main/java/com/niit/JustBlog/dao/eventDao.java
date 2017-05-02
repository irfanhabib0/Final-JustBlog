package com.niit.JustBlog.dao;

import java.util.List;

import com.niit.JustBlog.model.Event;

public interface eventDao {
	public List<Event> getall();
	public boolean save(Event event);
	public boolean update(Event event);
	public Event getId(int id);

}

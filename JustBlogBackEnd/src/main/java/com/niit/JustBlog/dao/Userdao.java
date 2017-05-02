package com.niit.JustBlog.dao;

import java.util.List;

import com.niit.JustBlog.model.UserDetails;

public interface Userdao {
	
	
	public List<UserDetails> getall();
	public boolean save(UserDetails user);
	public boolean update(UserDetails user);
	public UserDetails getId(int id);

}

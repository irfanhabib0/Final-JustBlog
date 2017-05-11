package com.niit.JustBlogBackEnd.Dao;

import java.util.List;

import com.niit.JustBlogBackEnd.model.UserDetails;

public interface UserDao {
	public List<UserDetails> getAll();
	public boolean save(UserDetails user);
	public boolean update(UserDetails user);
	public UserDetails getId(int id);
	public boolean deleteUser(UserDetails user);
	public boolean validate(int id,String password);
	public UserDetails getByEmail(String email);
	

}
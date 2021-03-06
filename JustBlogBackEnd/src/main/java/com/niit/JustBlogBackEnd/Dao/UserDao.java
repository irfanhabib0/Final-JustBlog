package com.niit.JustBlogBackEnd.Dao;

import java.util.List;

import com.niit.JustBlogBackEnd.model.UserDetails;

public interface UserDao {
	public List<UserDetails> getAll();
	public boolean save(UserDetails user);
	public boolean update(UserDetails user);
	public UserDetails getId(int id);
	public boolean deleteUser(UserDetails user);
	public boolean validate(String email,String password);
	public UserDetails getByEmail(String email);
	public void isOnline(int id);
	

}

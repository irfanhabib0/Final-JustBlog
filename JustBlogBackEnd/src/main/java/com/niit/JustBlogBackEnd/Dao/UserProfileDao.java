package com.niit.JustBlogBackEnd.Dao;

import java.util.List;

import com.niit.JustBlogBackEnd.model.Blog;
import com.niit.JustBlogBackEnd.model.UserProfile;

public interface UserProfileDao {
	public boolean addProfile(UserProfile usrpf);
	public List<UserProfile> getAlluserProfile();
	public List<UserProfile>  getuserProfileByUserId(int id);
}

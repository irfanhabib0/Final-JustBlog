package com.niit.JustBlogBackEnd.Dao;

import java.util.List;

import com.niit.JustBlogBackEnd.model.Friends;

public interface FriendDao {
	public boolean addFriend(Friends friend);
	public boolean updateFriend(Friends f);
	public Friends alterFrndids(int frndid,int userrid);
	public List<Friends> getAllMyfrnds( int userid);
	public List<Friends> viewAllFriendRequest(int userid);
	public List<Friends> viewAllFriendRequestCallToMe(int userid);
	
}

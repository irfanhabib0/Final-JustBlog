package com.niit.JustBlogBackEnd.Dao;

import java.util.List;


import com.niit.JustBlogBackEnd.model.Forum;

public interface ForumDao {
	public List<Forum> getAllforums();
	public boolean saveForum(Forum frum);
	public boolean updateForum(Forum frum);
	public boolean deleteForum(Forum frum);
	

}

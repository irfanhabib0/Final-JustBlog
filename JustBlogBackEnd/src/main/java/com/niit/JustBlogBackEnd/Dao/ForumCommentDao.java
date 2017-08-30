package com.niit.JustBlogBackEnd.Dao;

import java.util.List;


import com.niit.JustBlogBackEnd.model.Forum_comment;

public interface ForumCommentDao {
	public List<Forum_comment> getAllforumComments();
	public boolean addForumComment(Forum_comment forum_cmmnt);

}

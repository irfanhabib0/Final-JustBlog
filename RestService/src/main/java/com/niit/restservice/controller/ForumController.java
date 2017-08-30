package com.niit.restservice.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.niit.JustBlogBackEnd.Dao.ForumCommentDao;
import com.niit.JustBlogBackEnd.Dao.ForumDao;
import com.niit.JustBlogBackEnd.model.Blog;
import com.niit.JustBlogBackEnd.model.Forum;
import com.niit.JustBlogBackEnd.model.Forum_comment;


@RestController
public class ForumController {
     @Autowired
     ForumDao forumDao;
     @Autowired
     Forum frum;
     @Autowired
     ForumCommentDao forumcommentDao;
     @Autowired
     Forum_comment forumcomments;
     @Autowired
 	HttpSession session;
     
     @PostMapping("/showtheforumpost")
 	public ResponseEntity<Forum> addtheforumInfop(@RequestBody Forum frum){
    	 frum.setDateTime(new Date());
 	forumDao.saveForum(frum);
 	return new ResponseEntity<Forum>(frum, HttpStatus.OK);

 }
     
     @GetMapping("/getallforum")
 	public ResponseEntity <List<Forum>> getAllforum(){
 		List<Forum> getallforums=forumDao.getAllforums();
// 		blog.setErrorCode("200");
// 		blog.setErrorMessage("All blogs retrieved");
 		return new ResponseEntity<List<Forum>>(getallforums,HttpStatus.OK);
 	}
     
     @PostMapping("/insertForumcomment")
  	public ResponseEntity<Forum_comment> addtheforumComments(@RequestBody Forum_comment forumcomments){
  		forumcommentDao.addForumComment(forumcomments);	
  	
  	return new ResponseEntity<Forum_comment>(forumcomments, HttpStatus.OK);

  }
     
}

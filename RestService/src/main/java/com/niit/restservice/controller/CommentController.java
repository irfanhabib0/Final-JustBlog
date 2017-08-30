package com.niit.restservice.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.niit.JustBlogBackEnd.Dao.CommentDao;

import com.niit.JustBlogBackEnd.model.Comments;

@RestController
public class CommentController {
	@Autowired
	CommentDao commentDao;
	@Autowired
	Comments comments;
	@Autowired
	HttpSession session;
	
	@PostMapping("/addcomments")
	public ResponseEntity<Comments> addBlogComment(@RequestBody Comments comments){
		
		 commentDao.addComment(comments);		
		return new ResponseEntity<Comments>(comments,HttpStatus.OK);
	}
	
	@GetMapping("/getallcomments")
	public ResponseEntity <List<Comments>> getAllComments(){
		List<Comments> getallcomments=commentDao.getAllComments();
		return new ResponseEntity<List<Comments>>(getallcomments,HttpStatus.OK);
	}
	
}

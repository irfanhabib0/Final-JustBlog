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

import com.niit.JustBlogBackEnd.Dao.JobAppliedDao;

import com.niit.JustBlogBackEnd.model.JobApplied;

@RestController
public class jobAppliedController {
	@Autowired
	JobAppliedDao jobappDao;
	@Autowired
	JobApplied jobapp;
	@Autowired
	HttpSession session;
	
	@PostMapping("/addjobapplied")
	public ResponseEntity<JobApplied> addjobApplied(@RequestBody JobApplied jobapp){
		jobapp.setAppliedDate(new Date());
		jobappDao.save(jobapp);
		return new ResponseEntity<JobApplied>(jobapp,HttpStatus.OK);
	}
	
	@GetMapping("/getallappliedjob")
	public ResponseEntity <List<JobApplied>> getAllappliedJobPosted(){
		List<JobApplied> getallappliedjobs=jobappDao.getAllappliedJob();
//		blog.setErrorCode("200");
//		blog.setErrorMessage("All blogs retrieved");
		return new ResponseEntity<List<JobApplied>>(getallappliedjobs,HttpStatus.OK);
	}
	
	

}

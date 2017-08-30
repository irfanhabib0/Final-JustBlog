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

import com.niit.JustBlogBackEnd.Dao.JobDao;

import com.niit.JustBlogBackEnd.model.Job;


@RestController
public class JobController {
	@Autowired
	JobDao jobDao;
	@Autowired
	Job job;
	@Autowired
	HttpSession session;
	
	@PostMapping("/addjob")
	public ResponseEntity<Job> addJob(@RequestBody Job job){
		job.setDateTime(new Date());
		 jobDao.save(job);
		return new ResponseEntity<Job>(job,HttpStatus.OK);
	}
	
	@GetMapping("/getalljob")
	public ResponseEntity <List<Job>> getAllJobPosted(){
		List<Job> getalljobs=jobDao.getAllJob();
//		blog.setErrorCode("200");
//		blog.setErrorMessage("All blogs retrieved");
		return new ResponseEntity<List<Job>>(getalljobs,HttpStatus.OK);
	}
	

}

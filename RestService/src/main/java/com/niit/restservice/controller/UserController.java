package com.niit.restservice.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.niit.JustBlogBackEnd.Dao.UserDao;
import com.niit.JustBlogBackEnd.model.UserDetails;

@RestController
public class UserController {
	@Autowired
	UserDao usd;

	@Autowired
	UserDetails userdetails;

	@Autowired
	HttpSession session;

	@GetMapping("/allusers")
	public ResponseEntity<List<UserDetails>> getall() {
		List<UserDetails> user = usd.getAll();

		return new ResponseEntity<List<UserDetails>>(user, HttpStatus.OK);

	}

	@GetMapping("/hello")
	public String sayHello() {
		System.out.println("hello called");
		return "index";
	}
	
	@PostMapping("/registerUser")
	public ResponseEntity<UserDetails> addUser(@RequestBody UserDetails user)
	{
//		user=usd.getByEmail(email);
//		if(user==null){
			usd.save(user);
//			user.setErrorCode("200");
//			user.setErrorMessage("Thanks for registration");
//		}else{
//			user.setErrorCode("800");
//			user.setErrorMessage("Please choose another email ");
//		}
		return new ResponseEntity<UserDetails>(user,HttpStatus.OK);
		
	}
	
	@GetMapping("/login/{id}/{password}")
	public UserDetails checkValidation(@PathVariable("id")int id,@PathVariable("password")String password){
		
		if(usd.validate(id, password)==true){
			userdetails=usd.getId(id);
			userdetails.setErrorCode("200");
			userdetails.setErrorMessage("You have logged in successfully");
			return userdetails;
		}else{
			UserDetails usr=new UserDetails();
			usr.setErrorCode("404");
			usr.setErrorMessage("Invalid Credentials..");
			return usr;
		}
		
	}
	
		
	

}

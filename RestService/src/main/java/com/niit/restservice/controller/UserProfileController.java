package com.niit.restservice.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.niit.JustBlogBackEnd.Dao.UserDao;
import com.niit.JustBlogBackEnd.Dao.UserProfileDao;
import com.niit.JustBlogBackEnd.model.Blog;
import com.niit.JustBlogBackEnd.model.UserDetails;
import com.niit.JustBlogBackEnd.model.UserProfile;

@RestController
public class UserProfileController {
	@Autowired
	UserProfileDao usrproff;

	@Autowired
	UserProfile usrpf;

	@Autowired
	HttpSession session;
	
	@PostMapping("/showtotheprofile")
	public ResponseEntity<UserProfile> addtheuserInfo(@RequestBody UserProfile usrpf){
	
	usrproff.addProfile(usrpf);
	return new ResponseEntity<UserProfile>(usrpf, HttpStatus.OK);

}
	
@GetMapping("/getallprofiles")
public ResponseEntity <List<UserProfile>> getAlluserProfile(){
	List<UserProfile> getalluserprofyls=usrproff.getAlluserProfile();
//	blog.setErrorCode("200");
//	blog.setErrorMessage("All blogs retrieved");
	return new ResponseEntity<List<UserProfile>>(getalluserprofyls,HttpStatus.OK);
}

@GetMapping("/getuserProfilesuserid/{id}")
public ResponseEntity <List<UserProfile>> getUserprofylByUserID(@PathVariable("id")int id){
	List<UserProfile> usrpofyl=usrproff.getuserProfileByUserId(id);
	session.getAttribute("id");
	
	return new ResponseEntity<List<UserProfile>>(usrpofyl,HttpStatus.OK);	
		
	}
	
}

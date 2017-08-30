package com.niit.restservice.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.niit.JustBlogBackEnd.Dao.BlogDao;
import com.niit.JustBlogBackEnd.Dao.FriendDao;
import com.niit.JustBlogBackEnd.model.Blog;
import com.niit.JustBlogBackEnd.model.Friends;

@RestController
public class FriendController {
	@Autowired
	FriendDao friendDao;
	@Autowired
	Friends friend;
	@Autowired
	Friends frndzz;
	@Autowired
	HttpSession session;

	@PostMapping("/send/request/addthefriend")
	public ResponseEntity<Void> makeFriendz(@RequestBody Friends friend) {

		if (friendDao.addFriend(friend)) {

			Friends friend1 = new Friends();
			friend1.setUser(friend.getFriend());
			friend1.setFriend(friend.getUser());
			friend1.setStatus("new");
			friend1.setInitiater(0);
			friendDao.addFriend(friend1);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}

		else
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);

	}

	@PostMapping("/acceptFrnd")
	public ResponseEntity<Void> acceptFriend(@RequestBody Friends f) {
		if (friendDao.updateFriend(f)==true) {
			int frndid = f.getFriend().getId();
			int id = f.getUser().getId();
			frndzz = friendDao.alterFrndids(frndid, id);
			frndzz.setStatus(f.getStatus());
			if(friendDao.updateFriend(frndzz))			
			return new ResponseEntity<Void>(HttpStatus.OK);
			else
				return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
				
		}

		else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	
	}
	
	
	@GetMapping("/getfrnduserid/{id}")
	public ResponseEntity<List<Friends>> gettingAllSelfFrnds(@PathVariable("id")int id){
		List<Friends> getallfriends=friendDao.getAllMyfrnds(id);
		return new ResponseEntity<List<Friends>>(getallfriends,HttpStatus.OK);
		
	}
	
	@GetMapping("/getthesendfrndz/{id}")
	public ResponseEntity<List<Friends>> viewallSendRequest(@PathVariable("id")int id){
		List<Friends> gettheRequestedFrnds=friendDao.viewAllFriendRequest(id);
		return new ResponseEntity<List<Friends>>(gettheRequestedFrnds,HttpStatus.OK);
		
	}
	
	@GetMapping("/gettherequestedFrnds/{Id}")
	public ResponseEntity<List<Friends>> seeRequestJustSendToMe(@PathVariable("Id")int id){
		List<Friends> getallfriendsSendme=friendDao.viewAllFriendRequestCallToMe(id);
		return new ResponseEntity<List<Friends>>(getallfriendsSendme,HttpStatus.OK);
	}

}

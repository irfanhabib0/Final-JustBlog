package com.niit.JustBlogBackEnd.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

@Entity
@Component("frnd")
public class Friends extends BaseDomain {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int friendId;
	@OneToOne
	UserDetails user;
	@OneToOne
	UserDetails friend;
	private int initiater;
	private String status;
	public int getFriendId() {
		return friendId;
	}
	public void setFriendId(int friendId) {
		this.friendId = friendId;
	}
	public UserDetails getUser() {
		return user;
	}
	public void setUser(UserDetails user) {
		this.user = user;
	}
	public UserDetails getFriend() {
		return friend;
	}
	public void setFriend(UserDetails friend) {
		this.friend = friend;
	}
	
	public int getInitiater() {
		return initiater;
	}
	public void setInitiater(int initiater) {
		this.initiater = initiater;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	

}

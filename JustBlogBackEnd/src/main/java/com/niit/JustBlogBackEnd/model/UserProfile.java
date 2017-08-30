package com.niit.JustBlogBackEnd.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

@Entity
@Component("usrprofi")
public class UserProfile extends BaseDomain {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int userProfileId;
	private String city;
	@Lob
	private String qualification;
	private String work_experience;
	@OneToOne(cascade=CascadeType.PERSIST)
	private UserDetails user;
	public int getUserProfileId() {
		return userProfileId;
	}
	public void setUserProfileId(int userProfileId) {
		this.userProfileId = userProfileId;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getWork_experience() {
		return work_experience;
	}
	public void setWork_experience(String work_experience) {
		this.work_experience = work_experience;
	}
	public UserDetails getUser() {
		return user;
	}
	public void setUser(UserDetails user) {
		this.user = user;
	}
	
	

}

package com.niit.JustBlog.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Generated;
import org.springframework.stereotype.Component;

@Entity
@Component("user")
public class UserDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id;
	private String name;
	private String address;
	private String role;
	private String email;
	private String password;
	
	private char status;
	private long mobile;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public char getStatus() {
		return status;
	}
	public void setStatus(char status) {
		this.status = status;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	
	
	
	
	
}

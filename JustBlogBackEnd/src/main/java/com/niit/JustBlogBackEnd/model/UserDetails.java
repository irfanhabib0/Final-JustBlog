package com.niit.JustBlogBackEnd.model;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Component("user")
public class UserDetails extends BaseDomain {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	
	private int id;
	private String fullname;
	private String address;
	private String role;
	@Column(unique=true)
	private String email;
	private String password;
	@Column(unique=true)
	private String username;
	
	private char status;
	private String isonline;
	public String getIsonline() {
		return isonline;
	}
	public void setIsonline(String isonline) {
		this.isonline = isonline;
	}
	private long mobile;
	/*@JsonManagedReference(value="userblog")
	@OneToMany(fetch=FetchType.EAGER,mappedBy="user",cascade=CascadeType.ALL)
	private Set<Blog> blogs=new HashSet<Blog>();*/
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	/*public Set<Blog> getBlogs() {
		return blogs;
	}
	public void setBlogs(Set<Blog> blogs) {
		this.blogs = blogs;
	}*/
	
	public String getAddress() {
		return address;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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


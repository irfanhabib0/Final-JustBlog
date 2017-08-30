package com.niit.JustBlogBackEnd.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;


@Entity
@Component("jobapp")

public class JobApplied extends BaseDomain {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int jobAppliedId;
	public int getJobAppliedId() {
		return jobAppliedId;
	}
	public void setJobAppliedId(int jobAppliedId) {
		this.jobAppliedId = jobAppliedId;
	}
	
	public char getStatus() {
		return status;
	}
	public void setStatus(char status) {
		this.status = status;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public Date getAppliedDate() {
		return appliedDate;
	}
	public void setAppliedDate(Date appliedDate) {
		this.appliedDate = appliedDate;
	}
	public UserDetails getUser() {
		return user;
	}
	public void setUser(UserDetails user) {
		this.user = user;
	}
	public Job getJob() {
		return job;
	}
	public void setJob(Job job) {
		this.job = job;
	}
	
	private char status;
	private String remarks;
	private Date appliedDate;
	@ManyToOne(cascade = CascadeType.PERSIST)
	private UserDetails user;
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Job job;
	
	

}

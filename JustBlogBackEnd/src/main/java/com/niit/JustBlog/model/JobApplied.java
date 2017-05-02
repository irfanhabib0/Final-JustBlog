package com.niit.JustBlog.model;

import java.sql.Date;

import javax.persistence.Entity;

import org.springframework.stereotype.Component;

@Component
@Entity
public class JobApplied {
	
private int jobId;
	
	private int userId;
	
	private char status;
	
	private String remarks;
	
	private Date appliedDate;

	public int getJobId() {
		return jobId;
	}

	public void setJobId(int jobId) {
		this.jobId = jobId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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
	

}

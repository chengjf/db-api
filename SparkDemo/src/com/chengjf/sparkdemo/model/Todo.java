package com.chengjf.sparkdemo.model;

import java.util.Date;

/**
 * Todo POJO
 * 
 * @author sharp
 * @date 2015-08-29
 *
 */
public class Todo {

	private String id;
	
	private String content;
	
	private boolean isCompleted;
	
	private Date createdDate;
	
	private Date completedDate;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean isCompleted() {
		return isCompleted;
	}

	public void setCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getCompletedDate() {
		return completedDate;
	}

	public void setCompletedDate(Date completedDate) {
		this.completedDate = completedDate;
	}

	
}

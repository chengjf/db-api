package com.chengjf.sparkdemo.module.todo.model;

import java.util.Date;

import com.chengjf.sparkdemo.model.IModel;

/**
 * Todo Model
 * 
 * @author sharp
 * @date 2015-08-29
 *
 */
public class Todo implements IModel {

	private String id;

	private String content;

	private boolean completed;

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
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
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

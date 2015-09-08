package com.chengjf.sparkdemo.module.wiki.model;

import java.util.Date;

/**
 * 修订版本
 * 
 * @author CHENGJIANFENG100
 * @date 2015-09-08
 */
public class Revision {

	private String id;
	private String page_id;
	private String text_id;
	private String comment;
	private String user_id;
	private Date timestamp;
	private boolean is_deleted;
	private String parent_id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPage_id() {
		return page_id;
	}

	public void setPage_id(String page_id) {
		this.page_id = page_id;
	}

	public String getText_id() {
		return text_id;
	}

	public void setText_id(String text_id) {
		this.text_id = text_id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public boolean isIs_deleted() {
		return is_deleted;
	}

	public void setIs_deleted(boolean is_deleted) {
		this.is_deleted = is_deleted;
	}

	public String getParent_id() {
		return parent_id;
	}

	public void setParent_id(String parent_id) {
		this.parent_id = parent_id;
	}

}

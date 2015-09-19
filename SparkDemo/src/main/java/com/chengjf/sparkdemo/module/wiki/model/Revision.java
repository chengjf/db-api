package com.chengjf.sparkdemo.module.wiki.model;

import java.util.Date;

import com.chengjf.sparkdemo.model.IModel;
import com.j256.ormlite.field.DatabaseField;

/**
 * 修订版本
 * 
 * @author CHENGJIANFENG100
 * @date 2015-09-08
 */
public class Revision implements IModel {

	@DatabaseField(columnName = "revision_id", canBeNull = false, id = true)
	private String revisionId;

	@DatabaseField(canBeNull = false, columnName = "page_id")
	private String pageId;

	@DatabaseField(canBeNull = false, foreign = true, columnName = "text_id", foreignAutoRefresh = true)
	private Text text;

	@DatabaseField(columnName = "comment", canBeNull = true)
	private String comment;

	@DatabaseField(columnName = "userId", canBeNull = true)
	private String userId;

	@DatabaseField(columnName = "timestamp", canBeNull = true)
	private Date timestamp;

	@DatabaseField(columnName = "deleted", canBeNull = true)
	private boolean deleted;

	@DatabaseField(columnName = "parent_id", canBeNull = true)
	private String parentId;

	@DatabaseField(columnName = "latest", canBeNull = true)
	private boolean latest;

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public boolean isLatest() {
		return latest;
	}

	public void setLatest(boolean latest) {
		this.latest = latest;
	}

	public Text getText() {
		return text;
	}

	public void setText(Text text) {
		this.text = text;
	}

	public String getRevisionId() {
		return revisionId;
	}

	public void setRevisionId(String revisionId) {
		this.revisionId = revisionId;
	}

	public String getPageId() {
		return pageId;
	}

	public void setPageId(String pageId) {
		this.pageId = pageId;
	}

}

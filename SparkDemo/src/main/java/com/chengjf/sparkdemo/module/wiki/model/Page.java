package com.chengjf.sparkdemo.module.wiki.model;

import java.util.Date;

import com.chengjf.sparkdemo.model.IModel;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * 页面
 * 
 * @author CHENGJIANFENG100
 * @date 2015-09-08
 */

@DatabaseTable(tableName = "page")
public class Page implements IModel {

	@DatabaseField(columnName = "page_id", canBeNull = false, id = true)
	private String pageId;

	@DatabaseField(columnName = "namespace", canBeNull = false)
	private String namespace;

	@DatabaseField(columnName = "title", canBeNull = false)
	private String title;

	@DatabaseField(columnName = "comment", canBeNull = true)
	private String comment;

	@DatabaseField(columnName = "counter", canBeNull = false)
	private int counter;

	@DatabaseField(columnName = "created_date", canBeNull = false)
	private Date createdDate;

	@DatabaseField(canBeNull = false, foreign = true, columnName = "revision_id", foreignAutoRefresh = true)
	private Revision revision;

	public String getNamespace() {
		return namespace;
	}

	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getPageId() {
		return pageId;
	}

	public void setPageId(String pageId) {
		this.pageId = pageId;
	}

	public Revision getRevision() {
		return revision;
	}

	public void setRevision(Revision revision) {
		this.revision = revision;
	}

}

package com.chengjf.sparkdemo.module.wiki.model;

import com.chengjf.sparkdemo.model.IModel;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Wiki内容
 * 
 * @author CHENGJIANFENG100
 * @date 2015-09-08
 */

@DatabaseTable(tableName = "text")
public class Text implements IModel {

	@DatabaseField(columnName = "text_id", canBeNull = false, id = true, index = true)
	private String textId;

	@DatabaseField(columnName = "text", canBeNull = false, dataType = DataType.LONG_STRING)
	private String text;

	@DatabaseField(columnName = "type", canBeNull = true)
	private String type;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTextId() {
		return textId;
	}

	public void setTextId(String textId) {
		this.textId = textId;
	}

}

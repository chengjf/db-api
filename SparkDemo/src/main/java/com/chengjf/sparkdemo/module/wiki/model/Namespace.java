package com.chengjf.sparkdemo.module.wiki.model;

import com.chengjf.sparkdemo.model.IModel;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * @author CHENGJIANFENG100
 * @date 2015-9-23
 */

@DatabaseTable(tableName = "namespace")
public class Namespace implements IModel {

	@DatabaseField(columnName = "key", canBeNull = false, id = true, index = true)
	private String key;

	@DatabaseField(columnName = "value", canBeNull = false)
	private String value;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}

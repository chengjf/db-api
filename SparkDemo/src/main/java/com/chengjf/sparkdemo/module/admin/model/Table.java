package com.chengjf.sparkdemo.module.admin.model;

import com.chengjf.sparkdemo.model.IModel;
import com.j256.ormlite.field.FieldType;

/**
 * 表结构
 * 
 * @author CHENGJIANFENG100
 * @param <IModel>
 * 
 */
public class Table {

	private String tableName;
	private long rowNumber;
	private FieldType[] fieldTypes;
	private Class<IModel> dataClass;

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public long getRowNumber() {
		return rowNumber;
	}

	public void setRowNumber(long rowNumber) {
		this.rowNumber = rowNumber;
	}

	public FieldType[] getFieldTypes() {
		return fieldTypes;
	}

	public void setFieldTypes(FieldType[] fieldTypes) {
		this.fieldTypes = fieldTypes;
	}

	public Class<IModel> getDataClass() {
		return dataClass;
	}

	public void setDataClass(Class<IModel> dataClass) {
		this.dataClass = dataClass;
	}

}

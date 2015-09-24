package com.chengjf.sparkdemo.module.admin.model;

import com.j256.ormlite.field.FieldType;

/**
 * @author CHENGJIANFENG100
 * @param <T>
 *
 */
public class Table<T> {

	private String tableName;
	private long rowNumber;
	private FieldType[] fieldTypes;
	private Class<T> dataClass;
	
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

	public Class<T> getDataClass() {
		return dataClass;
	}

	public void setDataClass(Class<T> dataClass) {
		this.dataClass = dataClass;
	}
	
}

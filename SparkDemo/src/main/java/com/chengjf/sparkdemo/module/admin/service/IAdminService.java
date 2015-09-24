package com.chengjf.sparkdemo.module.admin.service;

import java.util.List;

import com.chengjf.sparkdemo.module.admin.model.Table;

/**
 * @author CHENGJIANFENG100
 * @date 2015-9-24
 */
public interface IAdminService {

	@SuppressWarnings("rawtypes")
	public List<Table> getAllTables();

	@SuppressWarnings("rawtypes")
	public <T> Table getTableByTableClassName(String tableClass);

}

package com.chengjf.sparkdemo.module.admin.service;

import java.util.List;

import com.chengjf.sparkdemo.model.IModel;
import com.chengjf.sparkdemo.module.admin.model.Table;

/**
 * 后台服务接口
 * 
 * @author CHENGJIANFENG100
 * @date 2015-9-24
 */
public interface IAdminService {

	public List<Table> getAllTables();

	public Table getTableByTableClassName(String tableClass);

	public List<IModel> getTableData(Table table);

}

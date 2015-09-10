package com.chengjf.sparkdemo.storage;

import org.apache.ibatis.datasource.unpooled.UnpooledDataSourceFactory;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * C3P0数据源适配
 * 
 * @author CHENGJIANFENG100
 * @date 2015-09-10
 */
public class C3P0DataSourceFactory extends UnpooledDataSourceFactory {

	public C3P0DataSourceFactory() {
		this.dataSource = new ComboPooledDataSource();
	}
}
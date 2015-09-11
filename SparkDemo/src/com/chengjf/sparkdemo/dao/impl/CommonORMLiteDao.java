package com.chengjf.sparkdemo.dao.impl;

import com.chengjf.sparkdemo.dao.ICommonDao;
import com.google.inject.Inject;
import com.j256.ormlite.support.ConnectionSource;

/**
 * ORMLite实现类
 * 
 * @author CHENGJIANFENG100
 * @date 2015-09-11
 */
public abstract class CommonORMLiteDao implements ICommonDao {

	protected ConnectionSource connectionSource;

	@Inject
	public CommonORMLiteDao(ConnectionSource connectionSource) {
		this.connectionSource = connectionSource;
	}

	public ConnectionSource getConnectionSource() {
		return connectionSource;
	}

}

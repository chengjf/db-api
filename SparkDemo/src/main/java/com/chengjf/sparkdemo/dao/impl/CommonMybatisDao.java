package com.chengjf.sparkdemo.dao.impl;

import org.apache.ibatis.session.SqlSessionFactory;

import com.chengjf.sparkdemo.dao.ICommonDao;
import com.google.inject.Inject;

/**
 * 公共Mybatis类，抽取了SqlSessionfactory供子类使用
 * 
 * @author sharp
 * @date 2015-08-29
 * 
 */
public abstract class CommonMybatisDao implements ICommonDao {

	/**
	 * 该factory用来统一注入SqlSessionFactory
	 */
	protected SqlSessionFactory factory;

	public SqlSessionFactory getFactory() {
		return factory;
	}

	@Inject
	public void setFactory(SqlSessionFactory factory) {
		this.factory = factory;
	}

}

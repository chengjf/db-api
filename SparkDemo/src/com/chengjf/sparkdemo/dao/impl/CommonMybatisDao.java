package com.chengjf.sparkdemo.dao.impl;

import org.apache.ibatis.session.SqlSessionFactory;

import com.chengjf.sparkdemo.storage.MyStorage;

/**
 * 公共Mybatis类，抽取了SqlSessionfactory供子类使用
 * 
 * @author sharp
 * @date 2015-08-29
 *
 */
public abstract class CommonMybatisDao {

	protected SqlSessionFactory factory;

	public CommonMybatisDao() {
		this.factory = MyStorage.getInstance().getFactory();
	}
}

package com.chengjf.sparkdemo.dao.impl;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.chengjf.sparkdemo.dao.ICommonDao;

/**
 * 公共Mybatis类，抽取了SqlSessionfactory供子类使用
 * 
 * @author sharp
 * @date 2015-08-29
 *
 */
public abstract class CommonMybatisDao extends SqlSessionDaoSupport implements
		ICommonDao {

}

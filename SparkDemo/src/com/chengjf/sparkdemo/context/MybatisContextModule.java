package com.chengjf.sparkdemo.context;

import org.apache.ibatis.session.SqlSessionFactory;

import com.chengjf.sparkdemo.context.provider.SqlSessionFactoryProvider;
import com.google.inject.AbstractModule;

/**
 * Mybatis配置
 * 
 * @author CHENGJIANFENG100
 * @date 2015-09-09
 */
public class MybatisContextModule extends AbstractModule {

	@Override
	protected void configure() {
		// TODO Auto-generated method stub
		bind(SqlSessionFactory.class).toProvider(
				SqlSessionFactoryProvider.class);
	}

}

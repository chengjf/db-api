package com.chengjf.sparkdemo.context.provider;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chengjf.sparkdemo.constants.DatabaseConstants;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.name.Named;

/**
 * Mybatis的SqlSessionFactory获取Provider
 * 
 * @author CHENGJIANFENG100
 * @date 2015-09-10
 */
public class SqlSessionFactoryProvider implements Provider<SqlSessionFactory> {

	private static final Logger logger = LoggerFactory
			.getLogger(SqlSessionFactoryProvider.class);

	private String configFilePath;

	@Inject
	public void setConfigFilePath(
			@Named(DatabaseConstants.MYBATIS_CONFIG_FILE) String path) {
		this.configFilePath = path;
	}

	@Override
	public SqlSessionFactory get() {
		InputStream inputStream = null;
		SqlSessionFactory factory = null;
		try {
			inputStream = Resources.getResourceAsStream(this.configFilePath);
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
			factory = builder.build(inputStream);
		} catch (IOException e) {
			logger.error("mybatis-config.xml配置文件读取出错！", e);
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					logger.error("mybatis-config.xml文件流关闭出错！", e);
				}
			}
		}
		return factory;
	}

}

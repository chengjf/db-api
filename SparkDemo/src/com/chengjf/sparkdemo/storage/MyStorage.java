package com.chengjf.sparkdemo.storage;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import com.chengjf.sparkdemo.config.Configuration;
import com.chengjf.sparkdemo.constants.DatabaseConstants;
import com.chengjf.sparkdemo.context.MyContext;

/**
 * 存储类，初始化Mybatis
 * 
 * @author sharp
 * @date 2015-08-29
 *
 */
public class MyStorage {

	private static MyStorage instance;

	private SqlSessionFactory factory;

	private static final Logger logger = LoggerFactory
			.getLogger(MyStorage.class);

	private MyStorage() {
		init();
	}

	public static MyStorage getInstance() {
		if (instance == null) {
			synchronized (MyStorage.class) {
				if (instance == null) {
					instance = new MyStorage();
				}
			}
		}
		return instance;
	}

	public SqlSessionFactory getFactory() {
		return this.factory;
	}

	private void init() {
		ApplicationContext context = MyContext.getContext();
		Configuration configuration = context.getBean(Configuration.class);

		String resource = configuration
				.getProperty(DatabaseConstants.CONFIG_MYBATIS_CONFIG_FILE);
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
			this.factory = builder.build(inputStream);
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
	}
}

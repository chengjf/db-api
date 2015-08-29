package com.chengjf.sparkdemo.storage;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

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
		String resource = "mybatis-config.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
			this.factory = builder.build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

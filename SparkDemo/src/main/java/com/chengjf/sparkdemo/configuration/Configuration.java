package com.chengjf.sparkdemo.configuration;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.ibatis.io.Resources;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 配置管理，使用Guice进行配置管理还是太弱
 * 
 * @author CHENGJIANFENG100
 * @date 22015-09-17
 */
public class Configuration {

	private static final Logger logger = LoggerFactory
			.getLogger(Configuration.class);

	public Properties config;

	public Configuration() {
		config = new Properties();
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream("config.properties");
			config.load(inputStream);
		} catch (IOException e) {
			logger.error("config.properties配置文件读取出错！", e);
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					logger.error("config.properties文件流关闭出错！", e);
				}
			}
		}
	}

	public String getConfig(String key) {
		return this.config.getProperty(key);
	}

	public void setConfig(String key, String value) {
		this.config.setProperty(key, value);
	}
}

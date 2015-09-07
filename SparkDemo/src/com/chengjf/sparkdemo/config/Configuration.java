package com.chengjf.sparkdemo.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.ibatis.io.Resources;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 配置类
 * 
 * @author CHENGJIANFENG100
 * @date 201509-07
 */
public class Configuration extends Properties {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6174226354596802043L;

	private static final Logger logger = LoggerFactory
			.getLogger(Configuration.class);

	public Configuration(String path) {

		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(path);
			this.load(inputStream);
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
}

package com.chengjf.sparkdemo.context;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.chengjf.sparkdemo.constants.SpringConstants;

/**
 * 上下文解析提供
 * 
 * @author sharp
 * @date 2015-9-3
 *
 */
public class MyContext {
	private static ApplicationContext context;

	private static final Logger logger = LoggerFactory
			.getLogger(MyContext.class);

	/*
	 * 使用类静态方法加载，此处的文件路径也是唯一的写在代码里的路径，其他文件路径均通过配置文件配置
	 */
	static {
		try {
			context = new GenericXmlApplicationContext(
					SpringConstants.CONFIG_FILE_PATH);
		} catch (Exception e) {
			logger.error("核心配置文件" + SpringConstants.CONFIG_FILE_PATH + "初始化失败",
					e);
		}
	}

	public static ApplicationContext getContext() {
		return context;
	}
}

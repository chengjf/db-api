package com.chengjf.sparkdemo.context;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * 上下文解析提供
 * 
 * @author sharp
 * @date 2015-9-3
 *
 */
public class MyContext {
	private static ApplicationContext context;

	private static final Logger logger = LoggerFactory.getLogger(MyContext.class);

	static {
		try {
			context = new GenericXmlApplicationContext("core/context.xml");
		} catch (Exception e) {
			logger.error("核心配置文件core/context.xml初始化失败", e);
		}
	}

	public static ApplicationContext getContext() {
		return context;
	}
}

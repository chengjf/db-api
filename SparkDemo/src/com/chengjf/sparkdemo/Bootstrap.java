package com.chengjf.sparkdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chengjf.sparkdemo.constants.FilterConstants;
import com.chengjf.sparkdemo.context.MyContext;
import com.chengjf.sparkdemo.filter.MyFilter;

/**
 * 系统启动初始化配置
 * 
 * @author sharp
 * @date 2015-9-3
 *
 */
public class Bootstrap {

	private static final Logger logger = LoggerFactory.getLogger(Bootstrap.class);

	public static void boot() {
		logger.debug("boot start...");
		MyContext context = new MyContext();

		initFilter();
		logger.debug("boot end...");

	}

	public static void initFilter() {

		MyFilter beforeFilter = MyContext.getContext().getBean(FilterConstants.BEFORE_FILTER, MyFilter.class);
		beforeFilter.start();

		MyFilter afterFilter = MyContext.getContext().getBean(FilterConstants.AFTER_FILTER, MyFilter.class);
		afterFilter.start();
	}
}

package com.chengjf.sparkdemo;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chengjf.sparkdemo.context.MyContext;
import com.chengjf.sparkdemo.filter.MyFilter;
import com.chengjf.sparkdemo.route.MyUrlHandler;

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

		initFilter();
		initUrl();

		logger.debug("boot end...");
	}

	public static void initFilter() {
		Map<String, MyFilter> allMyFilters = MyContext.getContext().getBeansOfType(MyFilter.class);
		Set<Entry<String, MyFilter>> set = allMyFilters.entrySet();
		for (Entry<String, MyFilter> entry : set) {
			entry.getValue().start();
		}
	}

	public static void initUrl() {
		Map<String, MyUrlHandler> allMyHandlers = MyContext.getContext().getBeansOfType(MyUrlHandler.class);
		Set<Entry<String, MyUrlHandler>> set = allMyHandlers.entrySet();
		for (Entry<String, MyUrlHandler> entry : set) {
			entry.getValue().start();
		}
	}
}

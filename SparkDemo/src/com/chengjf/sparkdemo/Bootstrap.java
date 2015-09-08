package com.chengjf.sparkdemo;

import static spark.Spark.staticFileLocation;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import com.chengjf.sparkdemo.config.Configuration;
import com.chengjf.sparkdemo.constants.WebConstants;
import com.chengjf.sparkdemo.context.MyContext;
import com.chengjf.sparkdemo.filter.MyFilter;
import com.chengjf.sparkdemo.route.IController;

/**
 * 系统启动初始化配置
 * 
 * @author sharp
 * @date 2015-9-3
 *
 */
public class Bootstrap {

	private static final Logger logger = LoggerFactory
			.getLogger(Bootstrap.class);

	private static final ApplicationContext context = MyContext.getContext();

	public static void boot() {
		logger.debug("boot start...");

		initWeb();

		initFilter();

		initUrl();

		logger.debug("boot end...");
	}

	private static void initWeb() {
		Configuration configuration = context.getBean(Configuration.class);
		String path = configuration.getProperty(WebConstants.STATIC_FILE_PATH);

		// 设置静态文件路径
		staticFileLocation(path);
	}

	private static void initFilter() {
		Map<String, MyFilter> allMyFilters = context
				.getBeansOfType(MyFilter.class);
		Set<Entry<String, MyFilter>> set = allMyFilters.entrySet();
		for (Entry<String, MyFilter> entry : set) {
			entry.getValue().start();
		}
	}

	private static void initUrl() {
		Map<String, IController> allMyHandlers = context
				.getBeansOfType(IController.class);
		Set<Entry<String, IController>> set = allMyHandlers.entrySet();
		for (Entry<String, IController> entry : set) {
			entry.getValue().start();
		}
	}
}

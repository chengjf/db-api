package com.chengjf.sparkdemo;

import static spark.Spark.staticFileLocation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chengjf.sparkdemo.constants.WebConstants;
import com.google.inject.Inject;
import com.google.inject.name.Named;

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

	// private static final ApplicationContext context = MyContext.getContext();

	public Bootstrap() {
		logger.debug("init......");
	}

	public void boot() {
		logger.debug("boot start...");

		// initUrl();

		logger.debug("boot end...");
	}

	/**
	 * 设置静态文件路径
	 * 
	 * @param path
	 */
	@Inject
	private void initStaticFileLocation(
			@Named(WebConstants.STATIC_FILE_PATH) String path) {
		logger.debug("initStaticFileLocation");
		staticFileLocation(path);
	}

	// private static void initUrl() {
	// Map<String, IController> allMyHandlers = context
	// .getBeansOfType(IController.class);
	// Set<Entry<String, IController>> set = allMyHandlers.entrySet();
	// for (Entry<String, IController> entry : set) {
	// entry.getValue().start();
	// }
	// }
}

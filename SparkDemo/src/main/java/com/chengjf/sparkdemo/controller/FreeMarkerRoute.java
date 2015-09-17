package com.chengjf.sparkdemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chengjf.sparkdemo.constants.WebConstants;
import com.chengjf.sparkdemo.context.MyContext;

import freemarker.cache.ClassTemplateLoader;
import freemarker.template.Configuration;

/**
 * 自定义FreeMarkerRoute类，指定了模板路径
 * 
 * @author chengjf
 * @date 2015-8-27
 */
public abstract class FreeMarkerRoute extends
		spark.template.freemarker.FreeMarkerRoute {

	private static final Logger logger = LoggerFactory
			.getLogger(FreeMarkerRoute.class);

	private static Configuration configuration = new Configuration();

	static {
		try {

			com.chengjf.sparkdemo.configuration.Configuration config = MyContext.context
					.getInstance(com.chengjf.sparkdemo.configuration.Configuration.class);
			String templatePath = config.getConfig(WebConstants.TEMPLATE_PATH);

			configuration.setTemplateLoader(new ClassTemplateLoader(
					FreeMarkerRoute.class, templatePath));
			// 设置编码，防止输出乱码
			configuration.setDefaultEncoding("UTF-8");

		} catch (Exception e) {
			logger.error("FreeMarker设置template路径出错！", e);
			System.exit(1);
		}
	}

	protected FreeMarkerRoute(String path) {
		super(path);
		this.setConfiguration(configuration);
	}

}

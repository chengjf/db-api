package com.chengjf.sparkdemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chengjf.sparkdemo.configuration.ConfigurationBean;
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

			ConfigurationBean config = MyContext.context
					.getInstance(ConfigurationBean.class);
			String templatePath = config.templatePath;

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

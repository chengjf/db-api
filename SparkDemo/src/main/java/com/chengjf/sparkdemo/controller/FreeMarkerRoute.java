package com.chengjf.sparkdemo.controller;

import java.io.File;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
			configuration.setDirectoryForTemplateLoading(new File("resource"));
		} catch (IOException e) {
			logger.error("FreeMarker设置template路径出错！", e);
		}
	}

	protected FreeMarkerRoute(String path) {
		super(path);
		this.setConfiguration(configuration);
	}

}

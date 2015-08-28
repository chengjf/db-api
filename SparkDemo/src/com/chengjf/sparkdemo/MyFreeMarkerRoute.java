package com.chengjf.sparkdemo;

import java.io.File;
import java.io.IOException;

import spark.template.freemarker.FreeMarkerRoute;
import freemarker.template.Configuration;
import freemarker.template.Version;

/**
 * 自定义FreeMarkerRoute类，指定了模板路径
 * 
 * @author chengjf
 * @date 2015-8-27
 */
public abstract class MyFreeMarkerRoute extends FreeMarkerRoute {

	private static Configuration configuration = new Configuration(new Version(
			"2.3.0"));
	static {
		try {
			configuration.setDirectoryForTemplateLoading(new File("resource"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected MyFreeMarkerRoute(String path) {
		super(path);
		this.setConfiguration(configuration);
	}

}

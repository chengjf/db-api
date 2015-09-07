package com.chengjf.sparkdemo.route;

import java.io.File;
import java.io.IOException;

import freemarker.template.Configuration;
import freemarker.template.Version;

/**
 * 自定义FreeMarkerRoute类，指定了模板路径
 * 
 * @author chengjf
 * @date 2015-8-27
 */
public abstract class FreeMarkerRoute extends spark.template.freemarker.FreeMarkerRoute {

	private static Configuration configuration = new Configuration(new Version(
			"2.3.0"));

	static {
		try {
			configuration.setDirectoryForTemplateLoading(new File("resource"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected FreeMarkerRoute(String path) {
		super(path);
		this.setConfiguration(configuration);
	}

}

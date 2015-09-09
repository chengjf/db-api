package com.chengjf.sparkdemo.resource;

import static spark.Spark.staticFileLocation;

import com.chengjf.sparkdemo.constants.WebConstants;
import com.google.inject.Inject;
import com.google.inject.name.Named;

/**
 * 静态资源配置
 * 
 * @author CHENGJIANFENG100
 * @date 2015-09-09
 */
public class StaticResource {

	private String path;

	@Inject
	public StaticResource(@Named(WebConstants.STATIC_FILE_PATH) String path) {
		this.path = path;
	}

	public void execute() {
		staticFileLocation(this.path);
	}
}

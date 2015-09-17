package com.chengjf.sparkdemo.resource;

import static spark.Spark.externalStaticFileLocation;
import static spark.Spark.staticFileLocation;

import com.chengjf.sparkdemo.configuration.Configuration;
import com.chengjf.sparkdemo.constants.WebConstants;
import com.chengjf.sparkdemo.context.MyContext;
import com.google.inject.Inject;

/**
 * 静态资源配置
 * 
 * @author CHENGJIANFENG100
 * @date 2015-09-09
 */
public class StaticResource {

	private String staticFileLocation;
	private String externalStaticFileLocation;

	@Inject
	public StaticResource() {
		this.staticFileLocation = MyContext.context.getInstance(
				Configuration.class).getConfig(
				WebConstants.STATIC_FILE_LOCATION);
		this.externalStaticFileLocation = MyContext.context.getInstance(
				Configuration.class).getConfig(
				WebConstants.EXTERNAL_STATIC_FILE_LOCATION);
	}

	public void execute() {
		staticFileLocation(this.staticFileLocation);
		externalStaticFileLocation(this.externalStaticFileLocation);
	}
}

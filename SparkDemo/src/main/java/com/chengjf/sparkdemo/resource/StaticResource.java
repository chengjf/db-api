package com.chengjf.sparkdemo.resource;

import static spark.Spark.externalStaticFileLocation;
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

	private String staticFileLocation;
	private String externalStaticFileLocation;

	@Inject
	public StaticResource(
			@Named(WebConstants.STATIC_FILE_LOCATION) String staticFileLocation,
			@Named(WebConstants.EXTERNAL_STATIC_FILE_LOCATION) String externalStaticFileLocation) {
		this.staticFileLocation = staticFileLocation;
		this.externalStaticFileLocation = externalStaticFileLocation;
	}

	public void execute() {
		staticFileLocation(this.staticFileLocation);
		externalStaticFileLocation(this.externalStaticFileLocation);
	}
}

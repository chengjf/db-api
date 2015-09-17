package com.chengjf.sparkdemo;

import static spark.Spark.externalStaticFileLocation;
import static spark.Spark.staticFileLocation;

import org.eclipse.jetty.util.resource.Resource;

import spark.servlet.SparkFilter;

public class HelloFilter extends SparkFilter {

	public HelloFilter() {
		// Bootstrap bootstrap = new Bootstrap();
		// bootstrap.initResource();
		super();
		// spark要求静态资源初始化必须在应用初始化之前
		staticFileLocation("static");
		externalStaticFileLocation("D:\\Code\\db-api\\SparkDemo\\src\\main\\webapp\\static");

		try {
			Resource resource = Resource.newResource("static");
			System.err.println(resource);
		} catch (Exception e) {

		}

	}
}

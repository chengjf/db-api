package com.chengjf.sparkdemo;

import static spark.Spark.staticFileLocation;
import spark.servlet.SparkFilter;

public class HelloFilter extends SparkFilter {

	public HelloFilter() {
		// Bootstrap bootstrap = new Bootstrap();
		// bootstrap.initResource();
		super();
		staticFileLocation("static");
	}
}

package com.chengjf.sparkdemo;

import com.chengjf.sparkdemo.configuration.Configuration;

import spark.servlet.SparkApplication;

/**
 * 用于Servlet启动
 * 
 * @author CHENGJIANFENG100
 * @date 2015-09-17
 */
public class HelloApplication implements SparkApplication {

	private Bootstrap bootstrap;

	public HelloApplication() {
		Configuration.isDev = false;
		this.bootstrap = new Bootstrap();
	}

	@Override
	public void init() {

		this.bootstrap.boot();
	}

}

package com.chengjf.sparkdemo;

import spark.servlet.SparkApplication;

import com.chengjf.sparkdemo.context.ConfigurationModule;

/**
 * 用于Servlet启动
 * 
 * @author CHENGJIANFENG100
 * @date 2015-09-17
 */
public class HelloApplication implements SparkApplication {

	private Bootstrap bootstrap;

	public HelloApplication() {
		ConfigurationModule.isDev = false;
		this.bootstrap = new Bootstrap();
	}

	@Override
	public void init() {

		this.bootstrap.boot();
	}

}

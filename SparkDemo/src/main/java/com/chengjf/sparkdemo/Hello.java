package com.chengjf.sparkdemo;

import com.chengjf.sparkdemo.context.ConfigurationModule;

/**
 * 系统入口
 * 
 * @author chengjf
 * @date 2015-08-27
 */
public class Hello {

	public static void main(String[] args) {

		ConfigurationModule.isDev = true;

		Bootstrap bootstrap = new Bootstrap();
		// 静态资源初始化
		bootstrap.initResource();

		bootstrap.boot();

	}
}
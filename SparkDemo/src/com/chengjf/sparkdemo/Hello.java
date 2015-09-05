package com.chengjf.sparkdemo;

import static spark.Spark.staticFileLocation;

/**
 * 系统入口
 * 
 * @author chengjf
 * @date 2015-08-27
 */
public class Hello {

	public static void main(String[] args) {

		// 设置静态文件路径
		staticFileLocation("/static");

		Bootstrap.boot();
	}
}
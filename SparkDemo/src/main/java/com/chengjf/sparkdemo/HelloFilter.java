package com.chengjf.sparkdemo;

import static spark.Spark.externalStaticFileLocation;

import java.io.IOException;
import java.net.MalformedURLException;

import org.eclipse.jetty.util.resource.Resource;

import spark.servlet.SparkFilter;

public class HelloFilter extends SparkFilter {

	public HelloFilter() {
		// Bootstrap bootstrap = new Bootstrap();
		// bootstrap.initResource();
		super();
		// spark要求静态资源初始化必须在应用初始化之前
		System.err
				.println("D:\\Code\\db-api\\SparkDemo\\src\\main\\webapp\\static\\");
		Resource resource;
		try {
			resource = Resource
					.newResource("D:\\Code\\db-api\\SparkDemo\\src\\main\\webapp\\static\\");
			System.err.println(resource);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		externalStaticFileLocation("D:\\Code\\db-api\\SparkDemo\\src\\main\\webapp\\static\\");

	}
}

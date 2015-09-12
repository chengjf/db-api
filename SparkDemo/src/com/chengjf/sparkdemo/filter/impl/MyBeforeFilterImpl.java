package com.chengjf.sparkdemo.filter.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import spark.Filter;
import spark.Request;
import spark.Response;

/**
 * 前置过滤器实现
 * 
 * @author sharp
 * @date 2015-9-3
 * 
 */
public class MyBeforeFilterImpl extends Filter {

	private static final Logger logger = LoggerFactory
			.getLogger(MyBeforeFilterImpl.class);

	@Override
	public void handle(Request req, Response res) {
		logger.debug("req: " + req.pathInfo());
	}

}

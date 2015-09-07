package com.chengjf.sparkdemo.module.index.handler;

import com.chengjf.sparkdemo.route.MyDefaultUrlHandler;

import spark.Request;
import spark.Response;

/**
 * 首页展示
 * 
 * @author sharp
 * @date 2015-9-3
 *
 */
public class IndexUrlHandler extends MyDefaultUrlHandler {

	public IndexUrlHandler(String url) {
		super(url);
	}

	@Override
	public Object get(Request req, Response res) {
		res.redirect("/todo");
		return res;
	}

}

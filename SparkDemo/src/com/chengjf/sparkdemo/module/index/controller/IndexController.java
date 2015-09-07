package com.chengjf.sparkdemo.module.index.controller;

import com.chengjf.sparkdemo.route.DefaultController;

import spark.Request;
import spark.Response;

/**
 * 首页展示
 * 
 * @author sharp
 * @date 2015-9-3
 *
 */
public class IndexController extends DefaultController {

	public IndexController(String url) {
		super(url);
	}

	@Override
	public Object get(Request req, Response res) {
		res.redirect("/todo");
		return res;
	}

}

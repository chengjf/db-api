package com.chengjf.sparkdemo.module.index.controller;

import spark.Request;
import spark.Response;

import com.chengjf.sparkdemo.annotation.Controller;
import com.chengjf.sparkdemo.controller.DefaultController;

/**
 * 首页展示
 * 
 * @author sharp
 * @date 2015-9-3
 *
 */

@Controller(url = "/")
public class IndexController extends DefaultController {

	@Override
	public Object get(Request req, Response res) {
		res.redirect("/todo");
		return res;
	}

}

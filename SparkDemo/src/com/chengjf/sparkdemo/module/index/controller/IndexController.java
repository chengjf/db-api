package com.chengjf.sparkdemo.module.index.controller;

import spark.ModelAndView;
import spark.Request;
import spark.Response;

import com.chengjf.sparkdemo.annotation.Controller;
import com.chengjf.sparkdemo.controller.FreeMarkerController;

/**
 * 首页展示
 * 
 * @author sharp
 * @date 2015-9-3
 *
 */

@Controller(url = "/")
public class IndexController extends FreeMarkerController {

	@Override
	public ModelAndView get(Request req, Response res) {
		res.redirect("/todo");
		return null;
	}

}

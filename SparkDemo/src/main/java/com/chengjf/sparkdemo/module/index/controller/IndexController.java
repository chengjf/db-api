package com.chengjf.sparkdemo.module.index.controller;

import spark.Request;
import spark.Response;

import com.chengjf.sparkdemo.annotation.Controller;
import com.chengjf.sparkdemo.annotation.Get;
import com.chengjf.sparkdemo.annotation.TemplateEngine;
import com.chengjf.sparkdemo.controller.ControllerHelper;
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

	@Get(templateEngine = TemplateEngine.DEFAULT)
	public Object get(Request req, Response res) {
		res.redirect(ControllerHelper.getRedirectUrl("/wiki"));
		return res;
	}

}

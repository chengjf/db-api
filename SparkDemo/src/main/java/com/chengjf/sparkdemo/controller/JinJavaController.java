package com.chengjf.sparkdemo.controller;

import spark.ModelAndView;

public class JinJavaController extends CommonController {

	protected ModelAndView modelAndView(Object model, String view) {
		ModelAndView mv = new ModelAndView(model, view);
		return mv;
	}
}

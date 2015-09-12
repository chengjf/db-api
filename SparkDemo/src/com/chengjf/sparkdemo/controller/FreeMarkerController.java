package com.chengjf.sparkdemo.controller;

import spark.ModelAndView;

/**
 * URL的FreeMarker处理类
 * 
 * @author sharp
 * @date 2015-9-3
 * 
 */
public abstract class FreeMarkerController extends CommonController {

	protected String template;

	public FreeMarkerController() {
	}

	protected ModelAndView modelAndView(Object model, String view) {
		ModelAndView mv = new ModelAndView(model, view);
		return mv;
	}

}

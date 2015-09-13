package com.chengjf.sparkdemo.controller;

import spark.ModelAndView;

/**
 * 
 * 提供Controller需要的方法，比如FreeMarker需要的ModelAndView方法
 * 
 * @author sharp
 * @date 2015-9-13
 * 
 */
public class ControllerHelper {

	public static ModelAndView modelAndView(Object model, String view) {
		ModelAndView mv = new ModelAndView(model, view);
		return mv;
	}

}

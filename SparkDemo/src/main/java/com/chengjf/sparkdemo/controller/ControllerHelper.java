package com.chengjf.sparkdemo.controller;

import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;

import com.chengjf.sparkdemo.configuration.Configuration;
import com.chengjf.sparkdemo.constants.WebConstants;
import com.chengjf.sparkdemo.context.MyContext;

/**
 * 
 * 提供Controller需要的方法，比如FreeMarker需要的ModelAndView方法
 * 
 * @author sharp
 * @date 2015-9-13
 * 
 */
public class ControllerHelper {

	public static ModelAndView modelAndView(Map<String, Object> model,
			String view) {
		if (model == null) {
			model = new HashMap<String, Object>();
		}

		Configuration configuration = MyContext.context
				.getInstance(Configuration.class);
		String baseUrl = configuration.getConfig(WebConstants.BASE_URL);

		model.put("baseUrl", baseUrl);

		String staticFilePath = configuration
				.getConfig(WebConstants.STATIC_FILE_PATH);
		model.put("staticFilePath", baseUrl + staticFilePath);
		ModelAndView mv = new ModelAndView(model, view);
		return mv;
	}

	public static String getRedirectUrl(String url) {
		Configuration configuration = MyContext.context
				.getInstance(Configuration.class);
		String baseUrl = configuration.getConfig(WebConstants.BASE_URL);
		return baseUrl + url;
	}

}

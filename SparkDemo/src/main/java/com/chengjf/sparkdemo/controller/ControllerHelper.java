package com.chengjf.sparkdemo.controller;

import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;

import com.chengjf.sparkdemo.configuration.ConfigurationBean;
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

		ConfigurationBean configuration = MyContext.context
				.getInstance(ConfigurationBean.class);

		String baseUrl = configuration.baseUrl;
		model.put("baseUrl", baseUrl);

		String baseStaticFileUrl = configuration.baseStaticFileUrl;
		model.put("baseStaticFileUrl", baseUrl + baseStaticFileUrl);

		ModelAndView mv = new ModelAndView(model, view);
		return mv;
	}

	public static String getRedirectUrl(String url) {
		ConfigurationBean configuration = MyContext.context
				.getInstance(ConfigurationBean.class);
		String baseUrl = configuration.baseUrl;
		return baseUrl + url;
	}

}

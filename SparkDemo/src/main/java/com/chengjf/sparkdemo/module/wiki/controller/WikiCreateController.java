package com.chengjf.sparkdemo.module.wiki.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import spark.ModelAndView;
import spark.Request;
import spark.Response;

import com.chengjf.sparkdemo.annotation.Controller;
import com.chengjf.sparkdemo.annotation.Get;
import com.chengjf.sparkdemo.annotation.Post;
import com.chengjf.sparkdemo.annotation.TemplateEngine;
import com.chengjf.sparkdemo.controller.CommonController;
import com.chengjf.sparkdemo.controller.ControllerHelper;

/**
 * 
 * @author sharp
 * @date 2015-9-19
 * 
 */
@Controller(url = "/wiki/create")
public class WikiCreateController extends CommonController {

	private static final Logger logger = LoggerFactory.getLogger(WikiCreateController.class);
	
	@Get(templateEngine = TemplateEngine.JINJAVA)
	public ModelAndView get(Request req, Response res) {
		return ControllerHelper.modelAndView(null, "template/wiki/create.html");
	}

	@Post(templateEngine = TemplateEngine.DEFAULT)
	public Object post(Request req, Response res) {
		String url = req.queryParams("url");
		try {
			url = URLDecoder.decode(url, "UTF-8");
			url = URLEncoder.encode(url, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			logger.error("URL参数解码失败！", e);
		}
		// redirect到查看页
		res.redirect(ControllerHelper.getRedirectUrl("/wiki/edit/" + url));
		return res;
	}
}

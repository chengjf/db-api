package com.chengjf.sparkdemo.module.wiki.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import spark.ModelAndView;
import spark.Request;
import spark.Response;

import com.chengjf.sparkdemo.annotation.Controller;
import com.chengjf.sparkdemo.annotation.Get;
import com.chengjf.sparkdemo.annotation.Post;
import com.chengjf.sparkdemo.annotation.TemplateEngine;
import com.chengjf.sparkdemo.constants.WikiConstants;
import com.chengjf.sparkdemo.context.MyContext;
import com.chengjf.sparkdemo.controller.CommonController;
import com.chengjf.sparkdemo.controller.ControllerHelper;
import com.chengjf.sparkdemo.module.wiki.service.IWikiService;

/**
 * 添加wiki
 * 
 * @author sharp
 * @date 2015-9-13
 * 
 */

@Controller(url = "/wiki/")
public class WikiAddController extends CommonController {

	private static final Logger logger = LoggerFactory
			.getLogger(WikiAddController.class);

	@Get(templateEngine = TemplateEngine.FREEMARKER)
	public ModelAndView get(Request req, Response res) {
		return ControllerHelper.modelAndView(null, "template/wiki/addWiki.ftl");
	}

	@Post(templateEngine = TemplateEngine.DEFAULT)
	public Object post(Request req, Response res) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		// 需要的参数
		// content
		String content = req.queryParams("content");
		// type
		String type = req.queryParams("type");
		// namespace
		String namespace = req.queryParams("namespace");
		// title
		String title = req.queryParams("title");
		// page_comment
		String comment = req.queryParams("comment");
		// user id
		String userId = req.session().attribute(WikiConstants.CURRENT_USER);

		parameters.put("content", content);
		parameters.put("type", type);
		parameters.put("namespace", namespace);
		parameters.put("title", title);
		parameters.put("comment", comment);
		parameters.put("userId", userId);

		IWikiService wikiService = MyContext.context
				.getInstance(IWikiService.class);
		if (wikiService == null) {
			logger.error("未获取到" + IWikiService.class);
		} else {
			wikiService.addNewWiki(parameters);
		}

		// redirect到查看页
		res.redirect(ControllerHelper.getRedirectUrl("/wiki"));
		return res;
	}
}

package com.chengjf.sparkdemo.module.wiki.controller;

import java.util.Map;

import spark.ModelAndView;
import spark.Request;
import spark.Response;

import com.chengjf.sparkdemo.annotation.Controller;
import com.chengjf.sparkdemo.annotation.Get;
import com.chengjf.sparkdemo.annotation.TemplateEngine;
import com.chengjf.sparkdemo.context.MyContext;
import com.chengjf.sparkdemo.controller.CommonController;
import com.chengjf.sparkdemo.controller.ControllerHelper;
import com.chengjf.sparkdemo.module.wiki.service.IWikiService;

/**
 * 单个wiki展示
 * 
 * @author sharp
 * @date 2015-9-13
 * 
 */

@Controller(url = "/wiki/show/:id")
public class WikiShowController extends CommonController {

	@Get(templateEngine = TemplateEngine.FREEMARKER)
	public ModelAndView showPage(Request req, Response res) {
		String id = req.params(":id");

		IWikiService wikiService = MyContext.context
				.getInstance(IWikiService.class);
		wikiService.addClickCount(id);
		Map<String, Object> model = wikiService.getWikiByRevisionId(id);
		return ControllerHelper.modelAndView(model,
				"/template/wiki/showWiki.ftl");
	}
}

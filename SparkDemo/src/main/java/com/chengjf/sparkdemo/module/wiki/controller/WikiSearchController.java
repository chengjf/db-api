package com.chengjf.sparkdemo.module.wiki.controller;

import java.util.ArrayList;
import java.util.List;
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
import com.chengjf.sparkdemo.context.MyContext;
import com.chengjf.sparkdemo.controller.CommonController;
import com.chengjf.sparkdemo.controller.ControllerHelper;
import com.chengjf.sparkdemo.module.wiki.model.Page;
import com.chengjf.sparkdemo.module.wiki.model.Page.PageAttr;
import com.chengjf.sparkdemo.module.wiki.service.IWikiService;

/**
 * 
 * @author sharp
 * @date 2015-9-20
 * 
 */
@Controller(url = "/wiki/search")
public class WikiSearchController extends CommonController {

	private static final Logger logger = LoggerFactory
			.getLogger(WikiSearchController.class);

	@Get(templateEngine = TemplateEngine.JINJAVA)
	public ModelAndView get(Request req, Response res) {
		return ControllerHelper.modelAndView(null, "template/wiki/search.html");
	}

	@Post(templateEngine = TemplateEngine.JINJAVA)
	public Object post(Request req, Response res) {
		Map<String, Object> model = getModel(req, res);
		// 需要的参数
		// content
		String term = req.queryParams("term");
		model.put("search", term);

		IWikiService wikiService = MyContext.context
				.getInstance(IWikiService.class);
		if (wikiService == null) {
			logger.error("未获取到" + IWikiService.class);
		} else {
			List<Page.PageAttr> attrs = new ArrayList<Page.PageAttr>();
			attrs.add(PageAttr.TITLE);
			attrs.add(PageAttr.TAGS);
			attrs.add(PageAttr.CONTENT);
			List<Page> pages = wikiService.searchPage(term, attrs);
			model.put("results", pages);
		}

		return ControllerHelper.modelAndView(model, "template/wiki/search.html");
	}
}

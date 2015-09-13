package com.chengjf.sparkdemo.module.wiki.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import spark.ModelAndView;
import spark.Request;
import spark.Response;

import com.chengjf.sparkdemo.annotation.Controller;
import com.chengjf.sparkdemo.annotation.Get;
import com.chengjf.sparkdemo.annotation.TemplateEngine;
import com.chengjf.sparkdemo.context.MyContext;
import com.chengjf.sparkdemo.controller.CommonController;
import com.chengjf.sparkdemo.controller.ControllerHelper;
import com.chengjf.sparkdemo.module.todo.service.ITodoService;
import com.chengjf.sparkdemo.module.wiki.model.Page;
import com.chengjf.sparkdemo.module.wiki.service.IWikiService;

/**
 * 所有的wiki列表
 * 
 * @author sharp
 * @date 2015-9-13
 * 
 */

@Controller(url = "/wiki")
public class WikiListController extends CommonController {

	private static final Logger logger = LoggerFactory
			.getLogger(WikiListController.class);

	@Get(templateEngine = TemplateEngine.FREEMARKER)
	public ModelAndView showAllWikis(Request req, Response res) {
		Map<String, Object> model = new HashMap<String, Object>();
		IWikiService todoService = MyContext.context
				.getInstance(IWikiService.class);
		if (todoService == null) {
			logger.error("未获取到" + ITodoService.class);
		} else {
			try {
				List<Page> pages = todoService.getAllPages();
				model.put("pageList", pages);
			} catch (Exception e) {
				logger.error("获取所有Page出错！", e);
			}
		}
		return ControllerHelper.modelAndView(model,
				"template/wiki/pageList.ftl");
	}
}

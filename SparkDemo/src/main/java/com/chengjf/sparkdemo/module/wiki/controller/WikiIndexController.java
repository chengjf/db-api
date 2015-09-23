package com.chengjf.sparkdemo.module.wiki.controller;

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
import com.chengjf.sparkdemo.module.wiki.model.Page;
import com.chengjf.sparkdemo.module.wiki.service.IWikiService;

/**
 * 
 * Wiki索引页面
 * 
 * @author sharp
 * @date 2015-9-20
 * 
 */
@Controller(url = "/wiki/index")
public class WikiIndexController extends CommonController {

	private static final Logger logger = LoggerFactory
			.getLogger(WikiIndexController.class);

	@Get(templateEngine = TemplateEngine.JINJAVA)
	public ModelAndView index(Request req, Response res) {
		Map<String, Object> model = getModel(req, res);
		IWikiService wikiService = MyContext.context
				.getInstance(IWikiService.class);
		if (wikiService == null) {
			logger.error("未获取到" + IWikiService.class);
		} else {
			try {
				List<Page> pages = wikiService.getAllPages();

				model.put("pages", pages);
			} catch (Exception e) {
				logger.error("获取所有Page出错！", e);
			}
		}
		return ControllerHelper.modelAndView(model, "template/wiki/index.html");
	}

}

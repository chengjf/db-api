package com.chengjf.sparkdemo.module.wiki.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import spark.ModelAndView;
import spark.Request;
import spark.Response;

import com.chengjf.sparkdemo.annotation.Controller;
import com.chengjf.sparkdemo.annotation.Get;
import com.chengjf.sparkdemo.annotation.TemplateEngine;
import com.chengjf.sparkdemo.constants.WikiConstants;
import com.chengjf.sparkdemo.context.MyContext;
import com.chengjf.sparkdemo.controller.CommonController;
import com.chengjf.sparkdemo.controller.ControllerHelper;
import com.chengjf.sparkdemo.module.wiki.model.Page;
import com.chengjf.sparkdemo.module.wiki.service.IWikiService;

/**
 * Wiki的Home页
 * 
 * @author sharp
 * @date 2015-9-19
 * 
 */

@Controller(url = "/wiki")
public class WikiHomeController extends CommonController {

	private static final Logger logger = LoggerFactory
			.getLogger(WikiHomeController.class);

	@Get(templateEngine = TemplateEngine.JINJAVA)
	public ModelAndView home(Request req, Response res) {
		Map<String, Object> model = getModel(req, res);
		IWikiService wikiService = MyContext.context
				.getInstance(IWikiService.class);
		if (wikiService == null) {
			logger.error("未获取到" + IWikiService.class);
		} else {
			try {
				Page page = wikiService.getPageByName(WikiConstants.HOME_PAGE);
				if (page == null) {
					return ControllerHelper.modelAndView(model,
							"template/wiki/home.html");
				} else {
					model.put("page", page);
				}
			} catch (Exception e) {
				logger.error("获取所有Page出错！", e);
			}
		}
		return ControllerHelper.modelAndView(model, "template/wiki/page.html");
	}
}

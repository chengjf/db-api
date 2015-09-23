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
import com.chengjf.sparkdemo.context.MyContext;
import com.chengjf.sparkdemo.controller.CommonController;
import com.chengjf.sparkdemo.controller.ControllerHelper;
import com.chengjf.sparkdemo.module.wiki.model.Page;
import com.chengjf.sparkdemo.module.wiki.service.IWikiService;

/**
 * 
 * Wiki查看
 * 
 * @author sharp
 * @date 2015-9-20
 * 
 */
@Controller(url = "/wiki/display/:id")
public class WikiDisplayController extends CommonController {

	private static final Logger logger = LoggerFactory
			.getLogger(WikiDisplayController.class);

	@Get(templateEngine = TemplateEngine.JINJAVA)
	public ModelAndView showPage(Request req, Response res) {
		Map<String, Object> model = getModel(req, res);

		String id = req.params(":id");

		IWikiService wikiService = MyContext.context
				.getInstance(IWikiService.class);
		if (wikiService == null) {
			logger.error("未获取到" + IWikiService.class);
		} else {
			try {
				Page page = wikiService.getPageById(id);
				if (page == null) {
					page = wikiService.getPageByName(id);
				}
				if (page == null) {
					return ControllerHelper.modelAndView(model,
							"template/wiki/create.html");
				} else {
					wikiService.addClickCount(page.getPageId());
					model.put("page", page);
				}
			} catch (Exception e) {
				logger.error("获取Page出错！", e);
			}
		}
		return ControllerHelper.modelAndView(model, "template/wiki/page.html");
	}
}
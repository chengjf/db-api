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
 * @author CHENGJIANFENG100
 * @date 2015-9-24
 */

@Controller(url = "/wiki/namespace/:id")
public class WikiNamespaceController extends CommonController {
	private static final Logger logger = LoggerFactory
			.getLogger(WikiNamespaceController.class);

	@Get(templateEngine = TemplateEngine.JINJAVA)
	public ModelAndView getNamespace(Request req, Response res) {
		Map<String, Object> model = getModel(req, res);
		String namespace = req.params(":id");
		IWikiService wikiService = MyContext.context
				.getInstance(IWikiService.class);
		if (wikiService == null) {
			logger.error("未获取到" + IWikiService.class);
		} else {
			try {
				List<Page> pages = wikiService.getPagesByNamespace(namespace);
				model.put("pages", pages);
			} catch (Exception e) {
				logger.error("获取所有Page出错！", e);
			}
		}
		return ControllerHelper.modelAndView(model, "template/wiki/index.html");
	}
}

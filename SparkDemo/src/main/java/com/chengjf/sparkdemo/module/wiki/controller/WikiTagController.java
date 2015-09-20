package com.chengjf.sparkdemo.module.wiki.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
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
 * @author sharp
 * @date 2015-9-20
 * 
 */
@Controller(url = "/wiki/tag/:tag")
public class WikiTagController extends CommonController {

	private static final Logger logger = LoggerFactory
			.getLogger(WikiTagController.class);

	@Get(templateEngine = TemplateEngine.JINJAVA)
	public ModelAndView showTag(Request req, Response res) {
		Map<String, Object> model = getModel(req, res);
		String tag = req.params(":tag");

		try {
			tag = URLDecoder.decode(tag, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			logger.error("URL参数解码失败！", e);
		}

		model.put("tag", tag);
		IWikiService wikiService = MyContext.context
				.getInstance(IWikiService.class);
		if (wikiService == null) {
			logger.error("未获取到" + IWikiService.class);
		} else {
			try {
				List<Page> pages = wikiService.getPagesByTag(tag);
				model.put("pages", pages);
			} catch (Exception e) {
				logger.error("获取所有Page出错！", e);
			}
		}
		return ControllerHelper.modelAndView(model, "template/wiki/tag.html");
	}
}
package com.chengjf.sparkdemo.module.wiki.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
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
 * Wiki删除
 * 
 * @author sharp
 * @date 2015-9-19
 * 
 */
@Controller(url = "/wiki/delete/:id")
public class WikiDeleteController extends CommonController {

	private static final Logger logger = LoggerFactory
			.getLogger(WikiDeleteController.class);

	@Get(templateEngine = TemplateEngine.JINJAVA)
	public ModelAndView get(Request req, Response res) {
		Map<String, Object> model = getModel(req, res);

		String id = req.params(":id");
		try {
			id = URLDecoder.decode(id, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			logger.error("URL参数解码失败！", e);
		}
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
					model.put("message", "删除失败，没有找到该页面！");
				} else {
					model.put("page", page);
					if (wikiService.deletePage(page)) {
						model.put("message", "刪除成功！");
					}
				}
			} catch (Exception e) {
				logger.error("删除Page出错！", e);
			}
		}
		return ControllerHelper
				.modelAndView(model, "template/wiki/delete.html");
	}
}

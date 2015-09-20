package com.chengjf.sparkdemo.module.wiki.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
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
import com.chengjf.sparkdemo.module.wiki.model.Page;
import com.chengjf.sparkdemo.module.wiki.service.IWikiService;

/**
 * 
 * @author sharp
 * @date 2015-9-19
 * 
 */
@Controller(url = "/wiki/edit/:url")
public class WikiEditController extends CommonController {
	private static final Logger logger = LoggerFactory
			.getLogger(WikiEditController.class);

	@Get(templateEngine = TemplateEngine.JINJAVA)
	public ModelAndView editGet(Request req, Response res) {
		Map<String, Object> model = getModel(req, res);

		String url = req.params(":url");
		try {
			url = URLDecoder.decode(url, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			logger.error("URL参数解码失败！", e);
		}

		IWikiService wikiService = MyContext.context
				.getInstance(IWikiService.class);
		if (wikiService == null) {
			logger.error("未获取到" + IWikiService.class);
		} else {
			try {
				Page page = wikiService.getPageById(url);
				if (page == null) {
					page = wikiService.getPageByName(url);
				}
				if (page == null) {
					page = new Page();
					page.setTitle(url);
				}
				model.put("page", page);
			} catch (Exception e) {
				logger.error("获取所有Page出错！", e);
			}
		}

		return ControllerHelper
				.modelAndView(model, "template/wiki/editor.html");
	}

	@Post(templateEngine = TemplateEngine.DEFAULT)
	public Object editPost(Request req, Response res) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		// 需要的参数
		String pageId = req.queryParams("pageId");
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

		parameters.put("pageId", pageId);
		parameters.put("content", content);
		parameters.put("type", type);
		parameters.put("namespace", namespace);
		parameters.put("title", title);
		parameters.put("comment", comment);
		parameters.put("userId", userId);

		IWikiService wikiService = MyContext.context
				.getInstance(IWikiService.class);
		Page page = null;
		if (wikiService == null) {
			logger.error("未获取到" + IWikiService.class);
		} else {
			if ("".equals(pageId)) {
				page = wikiService.addNewWiki(parameters);
			} else {
				page = wikiService.updatePage(parameters);
			}
		}
		if (page == null) {
			logger.error("编辑失败！");
		} else {
			String pageIID = page.getPageId();

			// redirect到查看页
			String redirectUrl = ControllerHelper
					.getRedirectUrl("/wiki/display/" + pageIID);
			res.redirect(redirectUrl);
		}
		return res;
	}
}

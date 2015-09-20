package com.chengjf.sparkdemo.module.wiki.controller;

import java.util.ArrayList;
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
import com.chengjf.sparkdemo.module.wiki.model.Page;
import com.chengjf.sparkdemo.module.wiki.service.IWikiService;

/**
 * 
 * @author sharp
 * @date 2015-9-20
 * 
 */
@Controller(url = "/wiki/tags")
public class WikiTagsController extends CommonController {

	private static final Logger logger = LoggerFactory
			.getLogger(WikiTagsController.class);

	@Get(templateEngine = TemplateEngine.JINJAVA)
	public ModelAndView showAllTags(Request req, Response res) {
		Map<String, Object> model = getModel(req, res);
		IWikiService wikiService = MyContext.context
				.getInstance(IWikiService.class);
		if (wikiService == null) {
			logger.error("未获取到" + IWikiService.class);
		} else {
			try {

				Map<String, List<Page>> tags = new HashMap<String, List<Page>>();
				List<Page> pages = wikiService.getAllPages();
				for (Page page : pages) {
					String[] pageTags = page.getComment().split(",");
					for (String tag : pageTags) {
						tag = tag.trim();
						if ("".equals(tag)) {
							continue;
						} else if (tags.get(tag) != null) {
							tags.get(tag).add(page);
						} else {
							List<Page> pageList = new ArrayList<Page>();
							pageList.add(page);
							tags.put(tag, pageList);
						}
					}
				}
				model.put("tags", tags);
				logger.debug("所有的Tags为 ", tags);
			} catch (Exception e) {
				logger.error("获取所有Tags出错！", e);
			}
		}
		return ControllerHelper.modelAndView(model, "template/wiki/tags.html");
	}
}
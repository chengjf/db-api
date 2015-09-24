package com.chengjf.sparkdemo.module.admin.controller;

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
import com.chengjf.sparkdemo.module.admin.model.Table;
import com.chengjf.sparkdemo.module.admin.service.IAdminService;
import com.chengjf.sparkdemo.module.wiki.service.IWikiService;

/**
 * @author CHENGJIANFENG100
 * @date 2015-9-24
 */

@Controller(url = "/admin")
public class AdminIndexController extends CommonController {

	private static final Logger logger = LoggerFactory
			.getLogger(AdminIndexController.class);

	@SuppressWarnings("rawtypes")
	@Get(templateEngine = TemplateEngine.JINJAVA)
	public ModelAndView getAllTables(Request req, Response res) {
		Map<String, Object> model = getModel(req, res);
		IAdminService adminService = MyContext.context
				.getInstance(IAdminService.class);
		if (adminService == null) {
			logger.error("未获取到" + IWikiService.class);
		} else {
			try {
				List<Table> tables = adminService.getAllTables();
				model.put("tables", tables);
			} catch (Exception e) {
				logger.error("获取所有Page出错！", e);
			}
		}
		return ControllerHelper
				.modelAndView(model, "template/admin/index.html");
	}
}

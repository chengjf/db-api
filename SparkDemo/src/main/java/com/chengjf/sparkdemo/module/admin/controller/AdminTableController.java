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
import com.chengjf.sparkdemo.model.IModel;
import com.chengjf.sparkdemo.module.admin.model.Table;
import com.chengjf.sparkdemo.module.admin.service.IAdminService;
import com.chengjf.sparkdemo.module.wiki.service.IWikiService;

/**
 * 后台管理table列表
 * 
 * @author CHENGJIANFENG100
 * @date 2015-9-24
 */

@Controller(url = "/admin/:id")
public class AdminTableController extends CommonController {

	private static final Logger logger = LoggerFactory
			.getLogger(AdminTableController.class);

	@Get(templateEngine = TemplateEngine.JINJAVA)
	public ModelAndView getTable(Request req, Response res) {
		Map<String, Object> model = getModel(req, res);

		String tableClass = req.params(":id");

		IAdminService adminService = MyContext.context
				.getInstance(IAdminService.class);
		if (adminService == null) {
			logger.error("未获取到" + IWikiService.class);
		} else {
			try {
				Table table = adminService.getTableByTableClassName(tableClass);

				List<IModel> list = adminService.getTableData(table);

				model.put("table", table);
				model.put("data", list);
			} catch (Exception e) {
				logger.error("获取所有Page出错！", e);
			}
		}
		return ControllerHelper
				.modelAndView(model, "template/admin/table.html");
	}
}

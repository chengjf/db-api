package com.chengjf.sparkdemo.module.todo.controller;

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
import com.chengjf.sparkdemo.module.todo.model.Todo;
import com.chengjf.sparkdemo.module.todo.service.ITodoService;
import com.google.inject.Inject;

/**
 * Todo展示
 * 
 * @author sharp
 * @date 2015-9-3
 * 
 */

@Controller(url = "/todo")
public class TodoController extends CommonController {

	private static final Logger logger = LoggerFactory
			.getLogger(TodoController.class);

	@Inject
	public TodoController() {
	}

	@Get(templateEngine = TemplateEngine.FREEMARKER)
	public ModelAndView index(Request req, Response res) {

		Map<String, Object> model = new HashMap<String, Object>();
		ITodoService todoService = MyContext.context
				.getInstance(ITodoService.class);
		if (todoService == null) {
			logger.error("未获取到" + ITodoService.class);
		} else {
			try {
				List<Todo> todos = todoService.getAllTodos();
				model.put("todoList", todos);
			} catch (Exception e) {
				logger.error("获取所有Todo出错！", e);
			}
		}
		return ControllerHelper.modelAndView(model,
				"template/todo/todoList.ftl");
	}

}

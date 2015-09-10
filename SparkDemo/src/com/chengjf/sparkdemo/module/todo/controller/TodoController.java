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
import com.chengjf.sparkdemo.controller.FreeMarkerController;
import com.chengjf.sparkdemo.module.todo.dao.TodoDao;
import com.chengjf.sparkdemo.module.todo.model.Todo;
import com.google.inject.Inject;

/**
 * Todo展示
 * 
 * @author sharp
 * @date 2015-9-3
 *
 */

@Controller(template = "template/todo/todoList.ftl", url = "/todo")
public class TodoController extends FreeMarkerController {

	private static final Logger logger = LoggerFactory
			.getLogger(TodoController.class);

	@Inject
	public TodoController() {
	}

	@Override
	public ModelAndView get(Request req, Response res) {
		Map<String, Object> model = new HashMap<String, Object>();
		if (this.dao == null) {
			logger.error("未获取到" + TodoDao.class);
		} else {
			try {
				List<Todo> todos = this.dao.getAllTodos();
				model.put("todoList", todos);
			} catch (Exception e) {
				logger.error("获取所有Todo出错！", e);
			}

		}
		return modelAndView(model, this.template);
	}

}

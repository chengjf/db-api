package com.chengjf.sparkdemo.module.todo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import spark.ModelAndView;
import spark.Request;
import spark.Response;

import com.chengjf.sparkdemo.context.MyContext;
import com.chengjf.sparkdemo.module.todo.dao.TodoDao;
import com.chengjf.sparkdemo.module.todo.model.Todo;
import com.chengjf.sparkdemo.route.FreeMarkerController;

/**
 * Todo展示
 * 
 * @author sharp
 * @date 2015-9-3
 *
 */
public class TodoController extends FreeMarkerController {

	private static final Logger logger = LoggerFactory
			.getLogger(TodoController.class);

	public TodoController(String url) {
		super(url);
	}

	@Override
	public ModelAndView get(Request req, Response res) {
		Map<String, Object> model = new HashMap<String, Object>();
		TodoDao dao = MyContext.getContext().getBean(TodoDao.class);
		if (dao == null) {
			logger.error("未获取到" + TodoDao.class);
		} else {
			try {
				List<Todo> todos = dao.getAllTodos();
				model.put("todoList", todos);
			} catch (Exception e) {
				logger.error("获取所有Todo出错！", e);
			}

		}
		return modelAndView(model, "template/todoList.ftl");
	}

}

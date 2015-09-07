package com.chengjf.sparkdemo.module.todo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.chengjf.sparkdemo.dao.DaoFactory;
import com.chengjf.sparkdemo.module.todo.model.Todo;
import com.chengjf.sparkdemo.route.FreeMarkerController;

import spark.ModelAndView;
import spark.Request;
import spark.Response;

/**
 * Todo展示
 * 
 * @author sharp
 * @date 2015-9-3
 *
 */
public class TodoController extends FreeMarkerController {

	public TodoController(String url) {
		super(url);
	}

	@Override
	public ModelAndView get(Request req, Response res) {
		List<Todo> todos = DaoFactory.getInstance().getTodoDao().getAllTodos();
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("todoList", todos);
		return modelAndView(model, "template/todoList.ftl");
	}

}

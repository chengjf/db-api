package com.chengjf.sparkdemo.module.todo.controller;

import java.util.Date;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import spark.ModelAndView;
import spark.Request;
import spark.Response;

import com.chengjf.sparkdemo.constants.WebConstants;
import com.chengjf.sparkdemo.module.todo.dao.TodoDao;
import com.chengjf.sparkdemo.module.todo.model.Todo;
import com.chengjf.sparkdemo.route.FreeMarkerController;
import com.google.inject.Inject;
import com.google.inject.name.Named;

public class TodoAddController extends FreeMarkerController {

	private static final Logger logger = LoggerFactory
			.getLogger(TodoAddController.class);

	@Inject
	public TodoAddController(@Named(WebConstants.TODO_ADD_URL) String url,
			@Named(WebConstants.TODO_ADD_TEMPLATE) String template) {
		this.setUrl(url);
		this.setTemplate(template);
	}

	@Override
	public ModelAndView get(Request req, Response res) {

		return modelAndView(null, this.template);
	}

	@Override
	public ModelAndView post(Request req, Response res) {
		String content = req.queryParams("content");

		Todo todo = new Todo();
		UUID uuid = UUID.randomUUID();
		todo.setId(uuid.toString());
		todo.setContent(content);
		todo.setCompleted(false);
		todo.setCreatedDate(new Date());
		if (dao == null) {
			logger.error("未获取到" + TodoDao.class);
		} else {
			dao.addTodo(todo);
		}

		// redirect到查看页
		res.redirect("/todo");
		return null;
	}
}

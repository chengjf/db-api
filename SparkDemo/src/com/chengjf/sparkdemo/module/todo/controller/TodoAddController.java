package com.chengjf.sparkdemo.module.todo.controller;

import java.util.Date;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import spark.ModelAndView;
import spark.Request;
import spark.Response;

import com.chengjf.sparkdemo.annotation.Controller;
import com.chengjf.sparkdemo.module.todo.dao.TodoDao;
import com.chengjf.sparkdemo.module.todo.model.Todo;
import com.chengjf.sparkdemo.route.FreeMarkerController;

@Controller(template = "template/todo/addTodo.ftl", url = "/todo/add")
public class TodoAddController extends FreeMarkerController {

	private static final Logger logger = LoggerFactory
			.getLogger(TodoAddController.class);

	public TodoAddController() {
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

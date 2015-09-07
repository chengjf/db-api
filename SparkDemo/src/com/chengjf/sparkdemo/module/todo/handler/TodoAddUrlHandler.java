package com.chengjf.sparkdemo.module.todo.handler;

import java.util.Date;
import java.util.UUID;

import com.chengjf.sparkdemo.dao.DaoFactory;
import com.chengjf.sparkdemo.module.todo.model.Todo;
import com.chengjf.sparkdemo.route.MyFreeMarkerUrlHandler;

import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class TodoAddUrlHandler extends MyFreeMarkerUrlHandler {

	public TodoAddUrlHandler(String url) {
		super(url);
	}

	@Override
	public ModelAndView get(Request req, Response res) {

		return modelAndView(null, "template/addTodo.ftl");
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
		DaoFactory.getInstance().getTodoDao().addTodo(todo);

		// redirect到查看页
		res.redirect("/todo");
		return null;
	}
}

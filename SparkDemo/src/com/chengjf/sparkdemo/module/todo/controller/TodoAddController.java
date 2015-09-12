package com.chengjf.sparkdemo.module.todo.controller;

import java.util.Date;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import spark.ModelAndView;
import spark.Request;
import spark.Response;

import com.chengjf.sparkdemo.annotation.Controller;
import com.chengjf.sparkdemo.annotation.Get;
import com.chengjf.sparkdemo.annotation.Post;
import com.chengjf.sparkdemo.annotation.TemplateEngine;
import com.chengjf.sparkdemo.context.MyContext;
import com.chengjf.sparkdemo.controller.FreeMarkerController;
import com.chengjf.sparkdemo.module.todo.model.Todo;
import com.chengjf.sparkdemo.module.todo.service.ITodoService;

/**
 * 增加一条Todo
 * 
 * @author CHENGJIANFENG100
 * @date 2015-09-10
 */
@Controller(url = "/todo/add")
public class TodoAddController extends FreeMarkerController {

	private static final Logger logger = LoggerFactory
			.getLogger(TodoAddController.class);

	public TodoAddController() {
	}

	@Get(templateEngine = TemplateEngine.FREEMARKER)
	public ModelAndView get(Request req, Response res) {

		return modelAndView(null, "template/todo/addTodo.ftl");
	}

	@Post(templateEngine = TemplateEngine.DEFAULT)
	public Object post(Request req, Response res) {
		String content = req.queryParams("content");

		Todo todo = new Todo();
		UUID uuid = UUID.randomUUID();
		todo.setId(uuid.toString());
		todo.setContent(content);
		todo.setCompleted(false);
		todo.setCreatedDate(new Date());
		ITodoService todoService = MyContext.context
				.getInstance(ITodoService.class);
		if (todoService == null) {
			logger.error("未获取到" + ITodoService.class);
		} else {
			todoService.addTodo(todo);
		}

		// redirect到查看页
		res.redirect("/todo");
		return res;
	}
}

package com.chengjf.sparkdemo;

import static spark.Spark.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import spark.Filter;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Route;

/**
 * @author chengjf
 * @date 2015-8-27
 */
public class Hello {

	private static List<String> todoList = new ArrayList<String>();

	private static final Logger logger = LoggerFactory.getLogger(Hello.class);

	public static void main(String[] args) {

		before(new Filter() {

			@Override
			public void handle(Request req, Response res) {
				logger.debug("req: " + req.pathInfo());
			}
		});
		
		after(new Filter() {
			
			@Override
			public void handle(Request req, Response res) {
				logger.debug("res: " + res.body());
				
			}
		});

		get(new Route("/") {

			@Override
			public Object handle(Request req, Response res) {
				return "Welcome!";
			}
		});

		get(new Route("/hello/:name") {

			@Override
			public Object handle(Request req, Response res) {
				String name = req.params(":name");
				return "hello, " + name;
			}
		});

		get(new MyFreeMarkerRoute("/todo") {

			@Override
			public ModelAndView handle(Request arg0, Response arg1) {

				Map<String, Object> model = new HashMap<String, Object>();
				model.put("todoList", todoList);
				return modelAndView(model, "template/todoList.ftl");
			}
		});

		post(new Route("/todo/add") {

			@Override
			public Object handle(Request req, Response res) {
				String todo = req.queryParams("content");
				todoList.add(todo);
				Map<String, Object> model = new HashMap<String, Object>();
				model.put("todoList", todoList);
				// redirect到查看页
				res.redirect("/todo");
				return null;
			}
		});

		get(new MyFreeMarkerRoute("/todo/add") {

			@Override
			public ModelAndView handle(Request arg0, Response arg1) {

				return modelAndView(null, "template/addTodo.ftl");
			}

		});

	}
}
package com.chengjf.sparkdemo;

import static spark.Spark.get;
import static spark.Spark.post;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	public static void main(String[] args) {
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

		post(new MyFreeMarkerRoute("/todo/add") {
			@Override
			public Object handle(Request res, Response rep) {
				String todo = res.queryParams("content");
				todoList.add(todo);
				Map<String, Object> model = new HashMap<String, Object>();
				model.put("todoList", todoList);
				return modelAndView(model, "template/todoList.ftl");
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
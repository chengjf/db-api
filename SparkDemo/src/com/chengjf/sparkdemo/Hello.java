package com.chengjf.sparkdemo;

import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.staticFileLocation;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chengjf.sparkdemo.dao.DaoFactory;
import com.chengjf.sparkdemo.model.Todo;
import com.chengjf.sparkdemo.route.MyFreeMarkerRoute;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Route;

/**
 * @author chengjf
 * @date 2015-08-27
 */
public class Hello {

	private static final Logger logger = LoggerFactory.getLogger(Hello.class);

	public static void main(String[] args) {

		// 设置静态文件路径
		staticFileLocation("/static");

		Bootstrap.boot();

		get(new Route("/") {

			@Override
			public Object handle(Request req, Response res) {
				res.redirect("/todo");
				return null;
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

				List<Todo> todos = DaoFactory.getInstance().getTodoDao().getAllTodos();
				Map<String, Object> model = new HashMap<String, Object>();
				model.put("todoList", todos);
				return modelAndView(model, "template/todoList.ftl");
			}
		});

		post(new Route("/todo/add") {

			@Override
			public Object handle(Request req, Response res) {
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
		});

		get(new MyFreeMarkerRoute("/todo/add") {

			@Override
			public ModelAndView handle(Request arg0, Response arg1) {

				return modelAndView(null, "template/addTodo.ftl");
			}

		});

	}
}
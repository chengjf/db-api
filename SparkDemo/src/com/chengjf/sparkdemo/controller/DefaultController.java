package com.chengjf.sparkdemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import spark.Request;
import spark.Response;
import spark.Route;

import com.chengjf.sparkdemo.annotation.Controller;

/**
 * URL默认处理类
 * 
 * @author sharp
 * @date 2015-9-3
 *
 */
public abstract class DefaultController implements IController {

	private static final Logger logger = LoggerFactory
			.getLogger(DefaultController.class);

	protected String url;

	public DefaultController() {
	}

	@Override
	public void start() {
		parseAnnotationForURL();
		spark.Spark.get(new Route(this.url) {

			@Override
			public Object handle(Request req, Response res) {
				return DefaultController.this.get(req, res);
			}
		});

		spark.Spark.post(new Route(this.url) {

			@Override
			public Object handle(Request req, Response res) {
				return DefaultController.this.post(req, res);
			}
		});

		spark.Spark.put(new Route(this.url) {

			@Override
			public Object handle(Request req, Response res) {
				return DefaultController.this.put(req, res);
			}
		});

		spark.Spark.patch(new Route(this.url) {

			@Override
			public Object handle(Request req, Response res) {
				return DefaultController.this.patch(req, res);
			}
		});

		spark.Spark.delete(new Route(this.url) {

			@Override
			public Object handle(Request req, Response res) {
				return DefaultController.this.delete(req, res);
			}
		});

		spark.Spark.head(new Route(this.url) {

			@Override
			public Object handle(Request req, Response res) {
				return DefaultController.this.head(req, res);
			}
		});

		spark.Spark.connect(new Route(this.url) {

			@Override
			public Object handle(Request req, Response res) {
				return DefaultController.this.connect(req, res);
			}
		});

		spark.Spark.options(new Route(this.url) {

			@Override
			public Object handle(Request req, Response res) {
				return DefaultController.this.options(req, res);
			}
		});
	}

	public Object get(Request req, Response res) {
		return null;
	};

	public Object post(Request req, Response res) {
		return null;
	};

	public Object put(Request req, Response res) {
		return null;
	};

	public Object patch(Request req, Response res) {
		return null;
	};

	public Object delete(Request req, Response res) {
		return null;
	};

	public Object head(Request req, Response res) {
		return null;
	};

	public Object trace(Request req, Response res) {
		return null;
	};

	public Object connect(Request req, Response res) {
		return null;
	};

	public Object options(Request req, Response res) {
		return null;
	};

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * 解析Annotation，获取URL
	 */
	protected void parseAnnotationForURL() {
		try {
			if (this.getClass().isAnnotationPresent(Controller.class)) {
				Controller controller = this.getClass().getAnnotation(
						Controller.class);
				this.url = controller.url();
			}
		} catch (SecurityException e) {
			logger.error("获取IController的Controller注解出错！", e);
		}
	}
}

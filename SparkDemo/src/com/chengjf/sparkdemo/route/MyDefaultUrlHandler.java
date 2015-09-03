package com.chengjf.sparkdemo.route;

import spark.Request;
import spark.Response;
import spark.Route;

/**
 * URL默认处理类
 * 
 * @author sharp
 * @date 2015-9-3
 *
 */
public abstract class MyDefaultUrlHandler {

	private String url;

	public MyDefaultUrlHandler(String url) {
		this.url = url;
	}

	public final void start() {
		spark.Spark.get(new Route("/") {

			@Override
			public Object handle(Request req, Response res) {
				return MyDefaultUrlHandler.this.get(req, res);
			}
		});

		spark.Spark.post(new Route("/") {

			@Override
			public Object handle(Request req, Response res) {
				return MyDefaultUrlHandler.this.post(req, res);
			}
		});

		spark.Spark.put(new Route("/") {

			@Override
			public Object handle(Request req, Response res) {
				return MyDefaultUrlHandler.this.put(req, res);
			}
		});

		spark.Spark.patch(new Route("/") {

			@Override
			public Object handle(Request req, Response res) {
				return MyDefaultUrlHandler.this.patch(req, res);
			}
		});

		spark.Spark.delete(new Route("/") {

			@Override
			public Object handle(Request req, Response res) {
				return MyDefaultUrlHandler.this.delete(req, res);
			}
		});

		spark.Spark.head(new Route("/") {

			@Override
			public Object handle(Request req, Response res) {
				return MyDefaultUrlHandler.this.head(req, res);
			}
		});

		spark.Spark.connect(new Route("/") {

			@Override
			public Object handle(Request req, Response res) {
				return MyDefaultUrlHandler.this.connect(req, res);
			}
		});

		spark.Spark.options(new Route("/") {

			@Override
			public Object handle(Request req, Response res) {
				return MyDefaultUrlHandler.this.options(req, res);
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

}

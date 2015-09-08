package com.chengjf.sparkdemo.route;

import spark.ModelAndView;
import spark.Request;
import spark.Response;

/**
 * URL的FreeMarker处理类
 * 
 * @author sharp
 * @date 2015-9-3
 *
 */
public abstract class FreeMarkerController implements IController {

	private String url;
	protected String template;

	public FreeMarkerController(String url) {
		this.url = url;
	}

	protected ModelAndView modelAndView(Object model, String view) {
		ModelAndView mv = new ModelAndView(model, view);
		return mv;
	}

	@Override
	public final void start() {

		spark.Spark.get(new FreeMarkerRoute(this.url) {

			@Override
			public ModelAndView handle(Request req, Response res) {
				return FreeMarkerController.this.get(req, res);
			}
		});

		spark.Spark.post(new FreeMarkerRoute(this.url) {

			@Override
			public ModelAndView handle(Request req, Response res) {
				return FreeMarkerController.this.post(req, res);
			}
		});

		spark.Spark.put(new FreeMarkerRoute(this.url) {

			@Override
			public ModelAndView handle(Request req, Response res) {
				return FreeMarkerController.this.put(req, res);
			}
		});

		spark.Spark.patch(new FreeMarkerRoute(this.url) {

			@Override
			public ModelAndView handle(Request req, Response res) {
				return FreeMarkerController.this.patch(req, res);
			}
		});

		spark.Spark.delete(new FreeMarkerRoute(this.url) {

			@Override
			public ModelAndView handle(Request req, Response res) {
				return FreeMarkerController.this.delete(req, res);
			}
		});

		spark.Spark.head(new FreeMarkerRoute(this.url) {

			@Override
			public ModelAndView handle(Request req, Response res) {
				return FreeMarkerController.this.head(req, res);
			}
		});

		spark.Spark.connect(new FreeMarkerRoute(this.url) {

			@Override
			public ModelAndView handle(Request req, Response res) {
				return FreeMarkerController.this.connect(req, res);
			}
		});

		spark.Spark.options(new FreeMarkerRoute(this.url) {

			@Override
			public ModelAndView handle(Request req, Response res) {
				return FreeMarkerController.this.options(req, res);
			}
		});
	}

	public ModelAndView get(Request req, Response res) {
		return null;
	};

	public ModelAndView post(Request req, Response res) {
		return null;
	};

	public ModelAndView put(Request req, Response res) {
		return null;
	};

	public ModelAndView patch(Request req, Response res) {
		return null;
	};

	public ModelAndView delete(Request req, Response res) {
		return null;
	};

	public ModelAndView head(Request req, Response res) {
		return null;
	};

	public ModelAndView trace(Request req, Response res) {
		return null;
	};

	public ModelAndView connect(Request req, Response res) {
		return null;
	};

	public ModelAndView options(Request req, Response res) {
		return null;
	};

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

}

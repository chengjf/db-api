package com.chengjf.sparkdemo.controller;

import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import spark.ModelAndView;
import spark.Request;
import spark.Response;

import com.chengjf.sparkdemo.annotation.Controller;

/**
 * URL的FreeMarker处理类
 * 
 * @author sharp
 * @date 2015-9-3
 *
 */
public abstract class FreeMarkerController extends DefaultController implements
		IController {

	private static final Logger logger = LoggerFactory
			.getLogger(FreeMarkerController.class);

	protected String template;

	public FreeMarkerController() {
	}

	protected ModelAndView modelAndView(Object model, String view) {
		ModelAndView mv = new ModelAndView(model, view);
		return mv;
	}

	@Override
	public final void start() {

		parseAnnotationForURL();
		parseAnnotationForTemplate();

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

	/**
	 * 解析Annotation，获取Template
	 */
	private void parseAnnotationForTemplate() {
		try {
			if (this.getClass().isAnnotationPresent(Controller.class)) {
				Controller controller = this.getClass().getAnnotation(
						Controller.class);
				this.template = controller.template();
			}
		} catch (SecurityException e) {
			logger.error("获取IController的Controller注解出错！", e);
		}
	}

	@SuppressWarnings("unused")
	private boolean isFreeMarkerController(String methodName) {
		boolean result = true;
		try {
			Method method = this.getClass().getMethod(methodName,
					Request.class, Response.class);
			@SuppressWarnings("rawtypes")
			Class clazz = method.getReturnType();
			if (clazz.equals(ModelAndView.class)) {
				result = true;
			} else {
				result = false;
			}
		} catch (NoSuchMethodException e) {
			logger.error("", e);
		} catch (SecurityException e) {
			logger.error("", e);
		}
		return result;
	}
}

package com.chengjf.sparkdemo.controller;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Route;

import com.chengjf.sparkdemo.annotation.Connect;
import com.chengjf.sparkdemo.annotation.Controller;
import com.chengjf.sparkdemo.annotation.Delete;
import com.chengjf.sparkdemo.annotation.Get;
import com.chengjf.sparkdemo.annotation.Head;
import com.chengjf.sparkdemo.annotation.Options;
import com.chengjf.sparkdemo.annotation.Patch;
import com.chengjf.sparkdemo.annotation.Post;
import com.chengjf.sparkdemo.annotation.Put;
import com.chengjf.sparkdemo.annotation.TemplateEngine;
import com.chengjf.sparkdemo.annotation.Trace;
import com.chengjf.sparkdemo.constants.WikiConstants;
import com.chengjf.sparkdemo.template.jinjava.JinJavaRoute;

/**
 * 
 * @author sharp
 * @date 2015-9-12
 * 
 */
public abstract class CommonController implements IController {

	private static final Logger logger = LoggerFactory
			.getLogger(CommonController.class);

	protected String url;

	/**
	 * 解析Annotation，获取URL
	 */
	protected final void parseAnnotationForURL() {
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

	protected final void parseAnnotationForMethod() {
		try {
			Method[] methods = this.getClass().getMethods();
			for (final Method method : methods) {
				Annotation[] annotations = method.getAnnotations();
				for (Annotation annotation : annotations) {
					httpMehodHandle(method, annotation);
				}
			}

			if (this.getClass().isAnnotationPresent(Controller.class)) {
				Controller controller = this.getClass().getAnnotation(
						Controller.class);
				this.url = controller.url();
			}
		} catch (SecurityException e) {
			logger.error("获取IController的Controller注解出错！", e);
		}
	}

	@Override
	public final void start() {
		parseAnnotationForURL();
		parseAnnotationForMethod();
	}

	private void httpMehodHandle(final Method method, Annotation annotation) {

		if (annotation.annotationType().equals(Get.class)) {
			getMethodHandle(method);
		} else if (annotation.annotationType().equals(Post.class)) {
			postMethodHandle(method);
		} else if (annotation.annotationType().equals(Put.class)) {
			putMethodHandle(method);
		} else if (annotation.annotationType().equals(Patch.class)) {
			patchMethodHandle(method);
		} else if (annotation.annotationType().equals(Delete.class)) {
			deleteMethodHandle(method);
		} else if (annotation.annotationType().equals(Head.class)) {
			headMethodHandle(method);
		} else if (annotation.annotationType().equals(Trace.class)) {
			traceMethodHandle(method);
		} else if (annotation.annotationType().equals(Connect.class)) {
			connectMethodHandle(method);
		} else if (annotation.annotationType().equals(Options.class)) {
			optionsMethodHandle(method);
		}

	}

	private void getMethodHandle(final Method method) {
		Get get = method.getAnnotation(Get.class);
		TemplateEngine engine = get.templateEngine();
		switch (engine) {
		case FREEMARKER:
			spark.Spark.get(new FreeMarkerRoute(this.url) {

				@Override
				public ModelAndView handle(Request req, Response res) {
					ModelAndView modelAndView = null;
					modelAndView = methodInvoke(method, ModelAndView.class,
							req, res);
					return modelAndView;
				}
			});
			break;
		case JINJAVA:
			spark.Spark.get(new JinJavaRoute(this.url) {

				@Override
				public ModelAndView handle(Request req, Response res) {
					ModelAndView modelAndView = null;
					modelAndView = methodInvoke(method, ModelAndView.class,
							req, res);
					return modelAndView;
				}
			});
			break;
		default:
			spark.Spark.get(new Route(this.url) {

				@Override
				public Object handle(Request req, Response res) {
					Object object = null;
					object = methodInvoke(method, Object.class, req, res);
					return object;
				}
			});
			break;
		}
	}

	private void postMethodHandle(final Method method) {
		Post post = method.getAnnotation(Post.class);
		TemplateEngine engine = post.templateEngine();
		switch (engine) {
		case FREEMARKER:
			spark.Spark.post(new FreeMarkerRoute(this.url) {

				@Override
				public ModelAndView handle(Request req, Response res) {
					ModelAndView modelAndView = null;
					modelAndView = methodInvoke(method, ModelAndView.class,
							req, res);
					return modelAndView;
				}
			});
			break;
		case JINJAVA:
			spark.Spark.post(new JinJavaRoute(this.url) {

				@Override
				public ModelAndView handle(Request req, Response res) {
					ModelAndView modelAndView = null;
					modelAndView = methodInvoke(method, ModelAndView.class,
							req, res);
					return modelAndView;
				}
			});
			break;

		default:
			spark.Spark.post(new Route(this.url) {

				@Override
				public Object handle(Request req, Response res) {
					Object object = null;
					object = methodInvoke(method, Object.class, req, res);
					return object;
				}
			});
			break;
		}
	}

	private void putMethodHandle(final Method method) {
		Put put = method.getAnnotation(Put.class);
		TemplateEngine engine = put.templateEngine();
		switch (engine) {
		case FREEMARKER:
			spark.Spark.put(new FreeMarkerRoute(this.url) {

				@Override
				public ModelAndView handle(Request req, Response res) {
					ModelAndView modelAndView = null;
					modelAndView = methodInvoke(method, ModelAndView.class,
							req, res);
					return modelAndView;
				}
			});
			break;
		case JINJAVA:
			spark.Spark.put(new JinJavaRoute(this.url) {

				@Override
				public ModelAndView handle(Request req, Response res) {
					ModelAndView modelAndView = null;
					modelAndView = methodInvoke(method, ModelAndView.class,
							req, res);
					return modelAndView;
				}
			});
			break;

		default:
			spark.Spark.put(new Route(this.url) {

				@Override
				public Object handle(Request req, Response res) {
					Object object = null;
					object = methodInvoke(method, Object.class, req, res);
					return object;
				}
			});
			break;
		}
	}

	private void patchMethodHandle(final Method method) {
		Patch patch = method.getAnnotation(Patch.class);
		TemplateEngine engine = patch.templateEngine();
		switch (engine) {
		case FREEMARKER:
			spark.Spark.patch(new FreeMarkerRoute(this.url) {

				@Override
				public ModelAndView handle(Request req, Response res) {
					ModelAndView modelAndView = null;
					modelAndView = methodInvoke(method, ModelAndView.class,
							req, res);
					return modelAndView;
				}
			});
			break;
		case JINJAVA:
			spark.Spark.patch(new JinJavaRoute(this.url) {

				@Override
				public ModelAndView handle(Request req, Response res) {
					ModelAndView modelAndView = null;
					modelAndView = methodInvoke(method, ModelAndView.class,
							req, res);
					return modelAndView;
				}
			});
			break;

		default:
			spark.Spark.patch(new Route(this.url) {

				@Override
				public Object handle(Request req, Response res) {
					Object object = null;
					object = methodInvoke(method, Object.class, req, res);
					return object;
				}
			});
			break;
		}
	}

	private void deleteMethodHandle(final Method method) {
		Delete delete = method.getAnnotation(Delete.class);
		TemplateEngine engine = delete.templateEngine();
		switch (engine) {
		case FREEMARKER:
			spark.Spark.delete(new FreeMarkerRoute(this.url) {

				@Override
				public ModelAndView handle(Request req, Response res) {
					ModelAndView modelAndView = null;
					modelAndView = methodInvoke(method, ModelAndView.class,
							req, res);
					return modelAndView;
				}
			});
			break;
		case JINJAVA:
			spark.Spark.delete(new JinJavaRoute(this.url) {

				@Override
				public ModelAndView handle(Request req, Response res) {
					ModelAndView modelAndView = null;
					modelAndView = methodInvoke(method, ModelAndView.class,
							req, res);
					return modelAndView;
				}
			});
			break;

		default:
			spark.Spark.delete(new Route(this.url) {

				@Override
				public Object handle(Request req, Response res) {
					Object object = null;
					object = methodInvoke(method, Object.class, req, res);
					return object;
				}
			});
			break;
		}
	}

	private void headMethodHandle(final Method method) {
		Head head = method.getAnnotation(Head.class);
		TemplateEngine engine = head.templateEngine();
		switch (engine) {
		case FREEMARKER:
			spark.Spark.head(new FreeMarkerRoute(this.url) {

				@Override
				public ModelAndView handle(Request req, Response res) {
					ModelAndView modelAndView = null;
					modelAndView = methodInvoke(method, ModelAndView.class,
							req, res);
					return modelAndView;
				}
			});
			break;
		case JINJAVA:
			spark.Spark.head(new JinJavaRoute(this.url) {

				@Override
				public ModelAndView handle(Request req, Response res) {
					ModelAndView modelAndView = null;
					modelAndView = methodInvoke(method, ModelAndView.class,
							req, res);
					return modelAndView;
				}
			});
			break;

		default:
			spark.Spark.head(new Route(this.url) {

				@Override
				public Object handle(Request req, Response res) {
					Object object = null;
					object = methodInvoke(method, Object.class, req, res);
					return object;
				}
			});
			break;
		}
	}

	private void traceMethodHandle(final Method method) {
		Trace trace = method.getAnnotation(Trace.class);
		TemplateEngine engine = trace.templateEngine();
		switch (engine) {
		case FREEMARKER:
			spark.Spark.trace(new FreeMarkerRoute(this.url) {

				@Override
				public ModelAndView handle(Request req, Response res) {
					ModelAndView modelAndView = null;
					modelAndView = methodInvoke(method, ModelAndView.class,
							req, res);
					return modelAndView;
				}
			});
			break;
		case JINJAVA:
			spark.Spark.trace(new JinJavaRoute(this.url) {

				@Override
				public ModelAndView handle(Request req, Response res) {
					ModelAndView modelAndView = null;
					modelAndView = methodInvoke(method, ModelAndView.class,
							req, res);
					return modelAndView;
				}
			});
			break;

		default:
			spark.Spark.trace(new Route(this.url) {

				@Override
				public Object handle(Request req, Response res) {
					Object object = null;
					object = methodInvoke(method, Object.class, req, res);
					return object;
				}
			});
			break;
		}
	}

	private void connectMethodHandle(final Method method) {
		Connect connect = method.getAnnotation(Connect.class);
		TemplateEngine engine = connect.templateEngine();
		switch (engine) {
		case FREEMARKER:
			spark.Spark.connect(new FreeMarkerRoute(this.url) {

				@Override
				public ModelAndView handle(Request req, Response res) {
					ModelAndView modelAndView = null;
					modelAndView = methodInvoke(method, ModelAndView.class,
							req, res);
					return modelAndView;
				}
			});
			break;
		case JINJAVA:
			spark.Spark.connect(new JinJavaRoute(this.url) {

				@Override
				public ModelAndView handle(Request req, Response res) {
					ModelAndView modelAndView = null;
					modelAndView = methodInvoke(method, ModelAndView.class,
							req, res);
					return modelAndView;
				}
			});
			break;

		default:
			spark.Spark.connect(new Route(this.url) {

				@Override
				public Object handle(Request req, Response res) {
					Object object = null;
					object = methodInvoke(method, Object.class, req, res);
					return object;
				}
			});
			break;
		}
	}

	private void optionsMethodHandle(final Method method) {
		Options options = method.getAnnotation(Options.class);
		TemplateEngine engine = options.templateEngine();
		switch (engine) {
		case FREEMARKER:
			spark.Spark.options(new FreeMarkerRoute(this.url) {

				@Override
				public ModelAndView handle(Request req, Response res) {
					ModelAndView modelAndView = null;
					modelAndView = methodInvoke(method, ModelAndView.class,
							req, res);
					return modelAndView;
				}
			});
			break;
		case JINJAVA:
			spark.Spark.options(new JinJavaRoute(this.url) {

				@Override
				public ModelAndView handle(Request req, Response res) {
					ModelAndView modelAndView = null;
					modelAndView = methodInvoke(method, ModelAndView.class,
							req, res);
					return modelAndView;
				}
			});
			break;

		default:
			spark.Spark.options(new Route(this.url) {

				@Override
				public Object handle(Request req, Response res) {
					Object object = null;
					object = methodInvoke(method, Object.class, req, res);
					return object;
				}
			});
			break;
		}
	}

	@SuppressWarnings("unchecked")
	private <T> T methodInvoke(Method method, Class<T> clazz, Request req,
			Response res) {
		T t = null;
		try {
			Object obj = method.invoke(this, req, res);
			t = (T) obj;
		} catch (IllegalAccessException e) {
			logger.error("class is " + clazz + " method is " + method, e);
		} catch (IllegalArgumentException e) {
			logger.error("class is " + clazz + " method is " + method, e);
		} catch (InvocationTargetException e) {
			logger.error("class is " + clazz + " method is " + method, e);
		} catch (ClassCastException e) {
			logger.error("class is " + clazz + " method is " + method, e);
		}
		return t;
	}

	protected final Map<String, Object> getModel(Request req, Response res) {
		Map<String, Object> model = new HashMap<String, Object>();

		// init current_user
		model.put(WikiConstants.CURRENT_USER,
				req.session().attribute(WikiConstants.CURRENT_USER));

		// init current_url
		model.put(WikiConstants.CURRENT_URL, req.url());
		// init current_path
		model.put(WikiConstants.CURRENT_PATH, req.pathInfo());

		logger.debug(WikiConstants.CURRENT_USER + " is "
				+ req.session().attribute(WikiConstants.CURRENT_USER));
		logger.debug(WikiConstants.CURRENT_URL + " is " + req.url());
		logger.debug(WikiConstants.CURRENT_PATH + " is " + req.raw().getPathInfo());

		return model;

	}
}

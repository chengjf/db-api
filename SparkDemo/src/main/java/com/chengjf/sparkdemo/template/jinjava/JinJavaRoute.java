package com.chengjf.sparkdemo.template.jinjava;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import spark.ModelAndView;
import spark.TemplateViewRoute;

import com.chengjf.sparkdemo.util.Resources;
import com.google.common.io.Files;
import com.hubspot.jinjava.Jinjava;
import com.hubspot.jinjava.JinjavaConfig;
import com.hubspot.jinjava.lib.fn.ELFunctionDefinition;

/**
 * 
 * @author sharp
 * @date 2015-9-19
 * 
 */
public abstract class JinJavaRoute extends TemplateViewRoute {

	private static final Logger logger = LoggerFactory
			.getLogger(JinJavaRoute.class);

	private static JinjavaConfig config;

	private static Jinjava jinjava;

	protected JinJavaRoute(String path) {
		super(path);
		config = createDefaultConfiguration();
		jinjava = new Jinjava(config);
		initFunction();
	}

	@SuppressWarnings("unchecked")
	@Override
	public String render(ModelAndView modelAndView) {
		String renderedTemplate = null;
		try {
			File file = Resources.getResourceAsFile(modelAndView.getViewName());

			String template = Files.toString(file, Charset.forName("UTF-8"));
			Map<String, Object> context = (Map<String, Object>) modelAndView
					.getModel();

			renderedTemplate = jinjava.render(template, context);

		} catch (IOException e) {
			logger.error("JinJava模板渲染出错！", e);
		} catch (Exception e) {
			logger.error("JinJava模板渲染出错！", e);
		}
		return renderedTemplate;
	}

	private JinjavaConfig createDefaultConfiguration() {
		return new JinjavaConfig();
	}

	private void initFunction() {

		try {
			Method method = UrlForFunction.class.getDeclaredMethod("urlFor",
					String.class);
			jinjava.getGlobalContext().registerFunction(
					new ELFunctionDefinition("", "url_for", method));

			method = UrlForFunction.class.getDeclaredMethod("urlForStatic",
					String.class);
			jinjava.getGlobalContext().registerFunction(
					new ELFunctionDefinition("", "url_for_static", method));

			method = UrlForFunction.class.getDeclaredMethod("urlForThis",
					String.class, String.class);
			jinjava.getGlobalContext().registerFunction(
					new ELFunctionDefinition("", "url_for_this", method));

		} catch (NoSuchMethodException | SecurityException e) {
			logger.error("JinJava模板添加函数出错！", e);
		}

	}

}

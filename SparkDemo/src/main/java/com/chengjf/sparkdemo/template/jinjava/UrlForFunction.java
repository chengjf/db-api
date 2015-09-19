package com.chengjf.sparkdemo.template.jinjava;

import com.chengjf.sparkdemo.configuration.ConfigurationBean;
import com.chengjf.sparkdemo.context.MyContext;

/**
 * 
 * @author sharp
 * @date 2015-9-19
 * 
 */
public class UrlForFunction {

	public static String urlFor(String reqUrl) {
		StringBuffer url = new StringBuffer();
		ConfigurationBean bean = MyContext.context
				.getInstance(ConfigurationBean.class);
		url.append(bean.baseUrl);
		url.append("/");
		url.append(reqUrl);
		return url.toString();
	}

	public static String urlForStatic(String reqUrl) {

		StringBuffer url = new StringBuffer();
		ConfigurationBean bean = MyContext.context
				.getInstance(ConfigurationBean.class);
		url.append(bean.baseStaticFileUrl);
		url.append("/");
		url.append(reqUrl);
		return url.toString();
	}

	public static String urlForThis(String reqUrl, String pageUrl) {

		StringBuffer url = new StringBuffer();
		url.append(reqUrl);
		url.append("/");
		url.append(pageUrl);
		return url.toString();
	}
}

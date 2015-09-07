package com.chengjf.sparkdemo.filter;

import static spark.Spark.after;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import spark.Filter;

/**
 * 后置过滤器
 * 
 * @author sharp
 * @date 2015-9-3
 *
 */
public class MyAfterFilter implements MyFilter {

	private static final Logger logger = LoggerFactory
			.getLogger(MyAfterFilter.class);

	private List<Filter> filterList = new ArrayList<Filter>();

	public void setFilterList(List<Filter> filterList) {
		this.filterList = filterList;
	}

	public List<Filter> getFilterList() {
		return filterList;
	}

	public MyAfterFilter() {
		logger.debug("custructor init...");
	}

	@Override
	public void start() {
		for (Filter filter : this.filterList) {
			after(filter);
		}
	}

}

package com.chengjf.sparkdemo.filter;

import static spark.Spark.before;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import spark.Filter;

/**
 * 前置过滤器
 * 
 * @author sharp
 * @date 2015-9-3
 *
 */
public class MyBeforeFilter implements MyFilter {

	private static final Logger logger = LoggerFactory.getLogger(MyBeforeFilter.class);

	private List<Filter> filterList;

	public void setFilterList(List<Filter> filterList) {
		this.filterList = filterList;
	}

	public List<Filter> getFilterList() {
		return filterList;
	}

	public MyBeforeFilter() {
		logger.debug("custructor init...");
	}

	@Override
	public void start() {
		for (Filter filter : this.filterList) {
			before(filter);
		}
	}

}

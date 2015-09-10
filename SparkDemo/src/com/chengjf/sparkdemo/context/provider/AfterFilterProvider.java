package com.chengjf.sparkdemo.context.provider;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import spark.Filter;

import com.chengjf.sparkdemo.filter.impl.MyAfterFilterImpl;
import com.google.inject.Provider;

/**
 * 响应后过滤器Provider
 * 
 * @author CHENGJIANFENG100
 * @date 2015-09-10
 */
public class AfterFilterProvider implements Provider<List<Filter>> {

	@Override
	public List<Filter> get() {
		return Collections.unmodifiableList(Arrays
				.asList((Filter) (new MyAfterFilterImpl())));
	}

}

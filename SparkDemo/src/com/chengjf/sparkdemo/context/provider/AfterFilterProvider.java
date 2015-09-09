package com.chengjf.sparkdemo.context.provider;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import spark.Filter;

import com.chengjf.sparkdemo.filter.impl.MyAfterFilterImpl;
import com.google.inject.Provider;

public class AfterFilterProvider implements Provider<List<Filter>> {

	@Override
	public List<Filter> get() {
		return Collections.unmodifiableList(Arrays
				.asList((Filter) (new MyAfterFilterImpl())));
	}

}

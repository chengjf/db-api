package com.chengjf.sparkdemo.context;

import java.util.List;

import spark.Filter;

import com.chengjf.sparkdemo.constants.WebConstants;
import com.chengjf.sparkdemo.context.provider.AfterFilterProvider;
import com.chengjf.sparkdemo.context.provider.BeforeFilterProvider;
import com.chengjf.sparkdemo.filter.MyAfterFilter;
import com.chengjf.sparkdemo.filter.MyBeforeFilter;
import com.chengjf.sparkdemo.filter.MyFilter;
import com.chengjf.sparkdemo.resource.StaticResource;
import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import com.google.inject.TypeLiteral;
import com.google.inject.name.Names;

/**
 * Guice module
 * 
 * @author CHENGJIANFENG100
 * @date 2015-09-09
 */
public class ContextModule extends AbstractModule {

	@Override
	protected void configure() {

		// 配置管理
		install(new ConfigurationModule());

		// 静态资源管理
		bind(StaticResource.class).in(Scopes.SINGLETON);

		/*
		 * Filter绑定，所有的过滤器都需要绑定到MyFilter上
		 */
		bind(new TypeLiteral<List<Filter>>() {
		}).annotatedWith(Names.named(WebConstants.BEFORE_FILTER)).toProvider(
				BeforeFilterProvider.class);
		bind(new TypeLiteral<List<Filter>>() {
		}).annotatedWith(Names.named(WebConstants.AFTER_FILTER)).toProvider(
				AfterFilterProvider.class);
		bind(MyFilter.class).annotatedWith(Names.named("MyBeforeFilter"))
				.to(MyBeforeFilter.class).in(Scopes.SINGLETON);
		bind(MyFilter.class).annotatedWith(Names.named("MyAfterFilter"))
				.to(MyAfterFilter.class).in(Scopes.SINGLETON);

	}
}

package com.chengjf.sparkdemo.context;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import org.apache.ibatis.io.Resources;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import spark.Filter;

import com.chengjf.sparkdemo.Bootstrap;
import com.chengjf.sparkdemo.constants.WebConstants;
import com.chengjf.sparkdemo.context.provider.AfterFilterProvider;
import com.chengjf.sparkdemo.context.provider.BeforeFilterProvider;
import com.chengjf.sparkdemo.filter.MyAfterFilter;
import com.chengjf.sparkdemo.filter.MyBeforeFilter;
import com.chengjf.sparkdemo.module.todo.controller.TodoAddController;
import com.chengjf.sparkdemo.module.todo.controller.TodoController;
import com.chengjf.sparkdemo.module.todo.dao.TodoDao;
import com.chengjf.sparkdemo.module.todo.dao.impl.TodoMybatisDao;
import com.google.inject.AbstractModule;
import com.google.inject.Binder;
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

	private static final Logger logger = LoggerFactory
			.getLogger(ContextModule.class);

	@Override
	protected void configure() {
		final Binder binder = binder();

		Names.bindProperties(binder(), getProperties());

		binder.bind(Bootstrap.class).in(Scopes.SINGLETON);

		// Filter
		bind(new TypeLiteral<List<Filter>>() {
		}).annotatedWith(Names.named(WebConstants.BEFORE_FILTER)).toProvider(
				BeforeFilterProvider.class);
		bind(new TypeLiteral<List<Filter>>() {
		}).annotatedWith(Names.named(WebConstants.AFTER_FILTER)).toProvider(
				AfterFilterProvider.class);

		binder.bind(MyBeforeFilter.class).in(Scopes.SINGLETON);
		binder.bind(MyAfterFilter.class).in(Scopes.SINGLETON);

		// URL
		bind(String.class).annotatedWith(
				Names.named(WebConstants.TODO_INDEX_URL)).toInstance("/todo");
		bind(String.class).annotatedWith(
				Names.named(WebConstants.TODO_INDEX_TEMPLATE)).toInstance(
				"template/todo/todoList.ftl");
		binder.bind(TodoController.class).in(Scopes.SINGLETON);

		bind(String.class)
				.annotatedWith(Names.named(WebConstants.TODO_ADD_URL))
				.toInstance("/todo/add");
		bind(String.class).annotatedWith(
				Names.named(WebConstants.TODO_ADD_TEMPLATE)).toInstance(
				"template/todo/addTodo.ftl");
		binder.bind(TodoAddController.class).in(Scopes.SINGLETON);
		// DAO
		bind(TodoDao.class).to(TodoMybatisDao.class).in(Scopes.SINGLETON);
	}

	/**
	 * 获取配置
	 * 
	 * @return
	 */
	private Properties getProperties() {
		Properties properties = new Properties();
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream("config.properties");
			properties.load(inputStream);
		} catch (IOException e) {
			logger.error("config.properties配置文件读取出错！", e);
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					logger.error("config.properties文件流关闭出错！", e);
				}
			}
		}
		return properties;
	}

}

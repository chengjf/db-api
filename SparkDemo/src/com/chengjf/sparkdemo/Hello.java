package com.chengjf.sparkdemo;

import com.chengjf.sparkdemo.context.ContextModule;
import com.chengjf.sparkdemo.context.MybatisContextModule;
import com.chengjf.sparkdemo.filter.MyAfterFilter;
import com.chengjf.sparkdemo.filter.MyBeforeFilter;
import com.chengjf.sparkdemo.module.todo.controller.TodoAddController;
import com.chengjf.sparkdemo.module.todo.controller.TodoController;
import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * 系统入口
 * 
 * @author chengjf
 * @date 2015-08-27
 */
public class Hello {

	public static void main(String[] args) {

		// Bootstrap.boot();
		Injector injector = Guice.createInjector(new ContextModule(),
				new MybatisContextModule());
		Bootstrap bootstrap = injector.getInstance(Bootstrap.class);

		// start filter
		MyBeforeFilter beforeFilter = injector
				.getInstance(MyBeforeFilter.class);
		beforeFilter.start();

		MyAfterFilter afterFilter = injector.getInstance(MyAfterFilter.class);
		afterFilter.start();

		TodoController todoController = injector
				.getInstance(TodoController.class);
		todoController.start();

		TodoAddController todoAddController = injector
				.getInstance(TodoAddController.class);
		todoAddController.start();

	}
}
package com.chengjf.sparkdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chengjf.sparkdemo.context.ContextModule;
import com.chengjf.sparkdemo.context.MybatisContextModule;
import com.chengjf.sparkdemo.filter.MyAfterFilter;
import com.chengjf.sparkdemo.filter.MyBeforeFilter;
import com.chengjf.sparkdemo.module.todo.controller.TodoAddController;
import com.chengjf.sparkdemo.module.todo.controller.TodoController;
import com.chengjf.sparkdemo.resource.StaticResource;
import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * 系统启动初始化配置
 * 
 * @author sharp
 * @date 2015-9-3
 *
 */

public class Bootstrap {

	private static final Logger logger = LoggerFactory
			.getLogger(Bootstrap.class);

	private Injector injector;

	public Bootstrap() {
		logger.debug("init......");
		this.injector = Guice.createInjector(new ContextModule(),
				new MybatisContextModule());
	}

	public void boot() {
		logger.debug("boot start...");

		initResource();
		initFilter();
		initController();

		logger.debug("boot end...");
	}

	private void initResource() {
		StaticResource resource = this.injector
				.getInstance(StaticResource.class);
		resource.execute();
	}

	private void initFilter() {
		// start filter
		MyBeforeFilter beforeFilter = injector
				.getInstance(MyBeforeFilter.class);
		beforeFilter.start();

		MyAfterFilter afterFilter = injector.getInstance(MyAfterFilter.class);
		afterFilter.start();
	}

	private void initController() {
		TodoController todoController = injector
				.getInstance(TodoController.class);
		todoController.start();

		TodoAddController todoAddController = injector
				.getInstance(TodoAddController.class);
		todoAddController.start();

	}

}

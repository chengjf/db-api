package com.chengjf.sparkdemo.context;

import com.chengjf.sparkdemo.controller.IController;
import com.chengjf.sparkdemo.model.IModel;
import com.chengjf.sparkdemo.module.index.controller.IndexController;
import com.chengjf.sparkdemo.module.todo.controller.TodoAddController;
import com.chengjf.sparkdemo.module.todo.controller.TodoController;
import com.chengjf.sparkdemo.module.todo.dao.TodoDao;
import com.chengjf.sparkdemo.module.todo.dao.impl.TodoORMLiteDao;
import com.chengjf.sparkdemo.module.todo.model.Todo;
import com.chengjf.sparkdemo.module.todo.service.ITodoService;
import com.chengjf.sparkdemo.module.todo.service.impl.TodoService;
import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import com.google.inject.name.Names;

/**
 * Todo模块的配置
 * 
 * @author CHENGJIANFENG100
 * @date 2015-09-11
 */
public class TodoContextModule extends AbstractModule {

	@Override
	protected void configure() {

		// URL
		bind(IController.class).annotatedWith(Names.named("TodoController"))
				.to(TodoController.class).in(Scopes.SINGLETON);
		bind(IController.class).annotatedWith(Names.named("TodoAddController"))
				.to(TodoAddController.class).in(Scopes.SINGLETON);
		bind(IController.class).annotatedWith(Names.named("IndexController"))
				.to(IndexController.class).in(Scopes.SINGLETON);

		// DAO
		// bind(TodoDao.class).to(TodoMybatisDao.class).in(Scopes.SINGLETON);
		bind(TodoDao.class).to(TodoORMLiteDao.class).in(Scopes.SINGLETON);

		// Service
		bind(ITodoService.class).to(TodoService.class).in(Scopes.SINGLETON);

		// Model
		bind(IModel.class).annotatedWith(Names.named("Todo")).to(Todo.class)
				.in(Scopes.SINGLETON);

	}

}

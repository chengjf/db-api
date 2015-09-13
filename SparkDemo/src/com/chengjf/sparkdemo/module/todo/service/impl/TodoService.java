package com.chengjf.sparkdemo.module.todo.service.impl;

import java.util.List;

import com.chengjf.sparkdemo.context.MyContext;
import com.chengjf.sparkdemo.module.todo.dao.TodoDao;
import com.chengjf.sparkdemo.module.todo.model.Todo;
import com.chengjf.sparkdemo.module.todo.service.ITodoService;

/**
 * TodoService
 * 
 * @author sharp
 * @date 2015-9-12
 * 
 */
public class TodoService implements ITodoService {

	@Override
	public List<Todo> getAllTodos() {
		TodoDao todoDao = MyContext.context.getInstance(TodoDao.class);
		return todoDao.getAllTodos();
	}

	@Override
	public boolean addTodo(Todo todo) {
		TodoDao todoDao = MyContext.context.getInstance(TodoDao.class);
		return todoDao.addTodo(todo) > 0;
	}

}

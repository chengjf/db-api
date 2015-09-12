package com.chengjf.sparkdemo.module.todo.service;

import java.util.List;

import com.chengjf.sparkdemo.module.todo.model.Todo;

/**
 * Todo服务接口
 * 
 * @author CHENGJIANFENG100
 * @date 2015-09-11
 */
public interface ITodoService {

	public List<Todo> getAllTodos();

	public boolean addTodo(Todo todo);
}

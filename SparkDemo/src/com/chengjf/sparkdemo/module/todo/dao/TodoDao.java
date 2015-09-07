package com.chengjf.sparkdemo.module.todo.dao;

import java.util.List;

import com.chengjf.sparkdemo.module.todo.model.Todo;

/**
 * 代办事项DAO
 * 
 * @author sharp
 * @date 2015-08-29
 *
 */
public interface TodoDao {

	public List<Todo> getAllTodos();

	public Todo getTodoByID(String id);

	public int addTodo(Todo todo);

	public int deleteTodo(Todo todo);

	public int deleteTodoByID(String id);
}

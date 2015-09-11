package com.chengjf.sparkdemo.module.todo.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chengjf.sparkdemo.dao.impl.CommonORMLiteDao;
import com.chengjf.sparkdemo.module.todo.dao.TodoDao;
import com.chengjf.sparkdemo.module.todo.model.Todo;
import com.google.inject.Inject;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;

public class TodoORMLiteDao extends CommonORMLiteDao implements TodoDao {

	private static final Logger logger = LoggerFactory
			.getLogger(TodoORMLiteDao.class);

	private Dao<Todo, String> todoDao;

	@Inject
	public TodoORMLiteDao(ConnectionSource connectionSource) {
		super(connectionSource);
		try {
			this.todoDao = DaoManager.createDao(connectionSource, Todo.class);
		} catch (SQLException e) {
			logger.error("", e);
		}
	}

	@Override
	public List<Todo> getAllTodos() {
		List<Todo> todoList = new ArrayList<Todo>();
		try {
			todoList = this.todoDao.queryForAll();
			System.err.println(this.todoDao);
		} catch (SQLException e) {
			logger.error("", e);
		}
		return todoList;
	}

	@Override
	public Todo getTodoByID(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addTodo(Todo todo) {
		int result = 0;
		try {
			result = this.todoDao.create(todo);
		} catch (SQLException e) {
			logger.error("", e);
		}
		return result;
	}

	@Override
	public int deleteTodo(Todo todo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteTodoByID(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

}

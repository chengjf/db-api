package com.chengjf.sparkdemo.module.todo.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chengjf.sparkdemo.dao.impl.CommonMybatisDao;
import com.chengjf.sparkdemo.module.todo.dao.TodoDao;
import com.chengjf.sparkdemo.module.todo.model.Todo;

/**
 * TodoDao的Mybatis实现
 * 
 * @author sharp
 * @date 2015-08-29
 *
 */
public class TodoMybatisDao extends CommonMybatisDao implements TodoDao {

	private static final Logger logger = LoggerFactory
			.getLogger(TodoMybatisDao.class);

	public TodoMybatisDao() {
	}

	public void createTodoTable() {
		SqlSession session = this.factory.openSession();
		int result = session.update("createTodoTable");
		if (result < 0) {
			logger.debug("Todo table create failed!");
		} else if (result == 0) {
			logger.debug("Todo table already created!");
		} else {
			logger.debug("Todo table created succced");
		}
		session.commit();
		session.close();
	}

	@Override
	public List<Todo> getAllTodos() {
		SqlSession session = this.factory.openSession();
		List<Todo> result = session.selectList("selectAllTodo");
		session.close();
		return result;
	}

	@Override
	public Todo getTodoByID(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addTodo(Todo todo) {
		int result;
		SqlSession session = this.factory.openSession();
		result = session.insert("insertTodo", todo);
		session.commit();
		session.close();
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

package com.chengjf.sparkdemo.dao;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.chengjf.sparkdemo.dao.impl.TodoMybatisDao;

/**
 * DAO工厂
 * 
 * @author sharp
 * @date 2015-08-29
 *
 */
public class DaoFactory {

	private static DaoFactory instance;

	private static Map<String, Object> daos;

	private DaoFactory() {
		DaoFactory.daos = new ConcurrentHashMap<String, Object>();
	}

	public static DaoFactory getInstance() {
		if (instance == null) {
			synchronized (DaoFactory.class) {
				if (instance == null) {
					instance = new DaoFactory();
				}
			}
		}
		return instance;
	}

	public TodoDao getTodoDao() {
		if (DaoFactory.daos.containsKey(TodoDao.class.getName())) {
			return (TodoDao) DaoFactory.daos.get(TodoDao.class.getName());
		} else {
			TodoMybatisDao dao = new TodoMybatisDao();
			DaoFactory.daos.put(TodoDao.class.getName(), dao);
			return dao;
		}
	}
}

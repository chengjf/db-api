package com.chengjf.sparkdemo.module.wiki.dao.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chengjf.sparkdemo.dao.impl.CommonORMLiteDao;
import com.chengjf.sparkdemo.module.wiki.dao.NamespaceDao;
import com.chengjf.sparkdemo.module.wiki.model.Namespace;
import com.google.inject.Inject;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;

/**
 * TextDao的ORMLite实现
 * 
 * @author sharp
 * @date 2015-9-13
 * 
 */
public class NamespaceORMLiteDao extends CommonORMLiteDao implements
		NamespaceDao {
	private static final Logger logger = LoggerFactory
			.getLogger(NamespaceORMLiteDao.class);

	private Dao<Namespace, String> namespaceDao;

	@Inject
	public NamespaceORMLiteDao(ConnectionSource connectionSource) {
		super(connectionSource);
		try {
			this.namespaceDao = DaoManager.createDao(connectionSource,
					Namespace.class);
			namespaceDao.setObjectCache(true);
		} catch (SQLException e) {
			logger.error("", e);
		}
	}

	@Override
	public Map<String, String> getNamespaceList() {
		Map<String, String> namespaceList = new HashMap<String, String>();
		try {
			List<Namespace> namespaces = this.namespaceDao.queryForAll();
			if (namespaces != null) {
				for (Namespace namespace : namespaces) {
					namespaceList.put(namespace.getKey(), namespace.getValue());
				}
			}
		} catch (Exception e) {
			logger.error("", e);
		}

		return namespaceList;
	}
}

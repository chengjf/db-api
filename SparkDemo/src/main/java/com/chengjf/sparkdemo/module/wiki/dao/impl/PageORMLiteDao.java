package com.chengjf.sparkdemo.module.wiki.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chengjf.sparkdemo.dao.impl.CommonORMLiteDao;
import com.chengjf.sparkdemo.module.wiki.dao.PageDao;
import com.chengjf.sparkdemo.module.wiki.model.Page;
import com.google.inject.Inject;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;

/**
 * PageDao实现类
 * 
 * @author sharp
 * @date 2015-9-13
 * 
 */
public class PageORMLiteDao extends CommonORMLiteDao implements PageDao {

	private static final Logger logger = LoggerFactory
			.getLogger(PageORMLiteDao.class);

	private Dao<Page, String> pageDao;

	@Inject
	public PageORMLiteDao(ConnectionSource connectionSource) {
		super(connectionSource);
		try {
			this.pageDao = DaoManager.createDao(connectionSource, Page.class);
		} catch (SQLException e) {
			logger.error("", e);
		}

	}

	@Override
	public List<Page> getAllPages() {
		List<Page> pageList = new ArrayList<Page>();
		try {
			pageList = this.pageDao.queryForAll();
		} catch (SQLException e) {
			logger.error("", e);
		}
		return pageList;
	}

	@Override
	public Page getPageById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addPage(Page page) {
		int result = 0;
		try {
			result = this.pageDao.create(page);
		} catch (SQLException e) {
			logger.error("", e);
		}
		return result;
	}

	@Override
	public int updatePage(Page page) {
		int result = 0;
		try {
			result = this.pageDao.update(page);
		} catch (SQLException e) {
			logger.error("", e);
		}
		return result;
	}

	@Override
	public int deletePage(Page page) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deletePageById(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
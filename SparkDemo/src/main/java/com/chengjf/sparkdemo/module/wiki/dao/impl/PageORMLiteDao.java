package com.chengjf.sparkdemo.module.wiki.dao.impl;

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
			pageDao.setObjectCache(true);
		} catch (Exception e) {
			logger.error("", e);
		}

	}

	@Override
	public List<Page> getAllPages() {
		List<Page> pageList = new ArrayList<Page>();
		try {
			pageList = this.pageDao.queryForAll();
		} catch (Exception e) {
			logger.error("", e);
		}
		return pageList;
	}

	@Override
	public Page getPageById(String id) {
		Page page = null;
		try {
			page = this.pageDao.queryForId(id);
		} catch (Exception e) {
			logger.error("", e);
		}
		return page;
	}

	@Override
	public int addPage(Page page) {
		int result = 0;
		try {
			result = this.pageDao.create(page);
		} catch (Exception e) {
			logger.error("", e);
		}
		return result;
	}

	@Override
	public int updatePage(Page page) {
		int result = 0;
		try {
			result = this.pageDao.update(page);
		} catch (Exception e) {
			logger.error("", e);
		}
		return result;
	}

	@Override
	public int deletePage(Page page) {
		int result = 0;
		try {
			result = this.pageDao.delete(page);
		} catch (Exception e) {
			logger.error("", e);
		}
		return result;
	}

	@Override
	public int deletePageById(String id) {
		int result = 0;
		try {
			result = this.pageDao.deleteById(id);
		} catch (Exception e) {
			logger.error("", e);
		}
		return result;
	}

	@Override
	public Page getPageByName(String name) {
		Page page = null;
		try {
			page = this.pageDao.queryForEq("title", name).get(0);
		} catch (Exception e) {
			logger.error("", e);
		}
		return page;
	}

}

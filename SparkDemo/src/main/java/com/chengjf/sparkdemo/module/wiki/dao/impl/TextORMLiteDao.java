package com.chengjf.sparkdemo.module.wiki.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chengjf.sparkdemo.dao.impl.CommonORMLiteDao;
import com.chengjf.sparkdemo.module.wiki.dao.TextDao;
import com.chengjf.sparkdemo.module.wiki.model.Text;
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
public class TextORMLiteDao extends CommonORMLiteDao implements TextDao {

	private static final Logger logger = LoggerFactory
			.getLogger(TextORMLiteDao.class);

	private Dao<Text, String> textDao;

	@Inject
	public TextORMLiteDao(ConnectionSource connectionSource) {
		super(connectionSource);
		try {
			this.textDao = DaoManager.createDao(connectionSource, Text.class);
			textDao.setObjectCache(true);
		} catch (SQLException e) {
			logger.error("", e);
		}
	}

	@Override
	public List<Text> getAllTexts() {
		List<Text> textList = new ArrayList<Text>();
		try {
			textList = this.textDao.queryForAll();
		} catch (Exception e) {
			logger.error("", e);
		}
		return textList;
	}

	@Override
	public Text getTextById(String id) {
		Text text = null;
		try {
			text = this.textDao.queryForId(id);
		} catch (Exception e) {
			logger.error("", e);
		}
		return text;
	}

	@Override
	public int addText(Text text) {
		int result = 0;
		try {
			result = this.textDao.create(text);
		} catch (SQLException e) {
			logger.error("", e);
		}
		return result;
	}

	@Override
	public int updateText(Text text) {
		int result = 0;
		try {
			result = this.textDao.update(text);
		} catch (SQLException e) {
			logger.error("", e);
		}
		return result;
	}

	@Override
	public int deleteText(Text text) {
		int result = 0;
		try {
			result = this.textDao.delete(text);
		} catch (SQLException e) {
			logger.error("", e);
		}
		return result;
	}

	@Override
	public int deleteTextById(String id) {
		int result = 0;
		try {
			result = this.textDao.deleteById(id);
		} catch (SQLException e) {
			logger.error("", e);
		}
		return result;
	}

}

package com.chengjf.sparkdemo.module.wiki.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chengjf.sparkdemo.dao.impl.CommonORMLiteDao;
import com.chengjf.sparkdemo.module.wiki.dao.RevisionDao;
import com.chengjf.sparkdemo.module.wiki.model.Revision;
import com.google.inject.Inject;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;

/**
 * RevisionDao的ORMLite实现
 * 
 * @author sharp
 * @date 2015-9-13
 * 
 */
public class RevisionORMLiteDao extends CommonORMLiteDao implements RevisionDao {

	private static final Logger logger = LoggerFactory
			.getLogger(RevisionORMLiteDao.class);

	private Dao<Revision, String> revisionDao;

	@Inject
	public RevisionORMLiteDao(ConnectionSource connectionSource) {
		super(connectionSource);
		try {
			this.revisionDao = DaoManager.createDao(connectionSource,
					Revision.class);
			revisionDao.setObjectCache(true);
		} catch (SQLException e) {
			logger.error("", e);
		}
	}

	@Override
	public List<Revision> getAllRevisions() {
		List<Revision> revisionList = new ArrayList<Revision>();
		try {
			revisionList = this.revisionDao.queryForAll();
		} catch (SQLException e) {
			logger.error("", e);
		}
		return revisionList;
	}

	@Override
	public Revision getRevisionById(String id) {
		Revision revision = null;
		try {
			revision = this.revisionDao.queryForId(id);
		} catch (SQLException e) {
			logger.error("", e);
		}
		return revision;
	}

	@Override
	public int addRevision(Revision revision) {
		int result = 0;
		try {
			result = this.revisionDao.create(revision);
		} catch (SQLException e) {
			logger.error("", e);
		}
		return result;
	}

	@Override
	public int updateRevision(Revision revision) {
		int result = 0;
		try {
			result = this.revisionDao.update(revision);
		} catch (SQLException e) {
			logger.error("", e);
		}
		return result;
	}

	@Override
	public int deleteRevision(Revision revision) {
		int result = 0;
		try {
			result = this.revisionDao.delete(revision);
		} catch (SQLException e) {
			logger.error("", e);
		}
		return result;
	}

	@Override
	public int deleteRevisionById(String id) {
		int result = 0;
		try {
			result = this.revisionDao.deleteById(id);
		} catch (SQLException e) {
			logger.error("", e);
		}
		return result;
	}

	@Override
	public List<Revision> getRevisionsByPageId(String pageId) {
		List<Revision> revisions = new ArrayList<Revision>();
		try {
			revisions = this.revisionDao.queryForEq("page_id", pageId);
		} catch (SQLException e) {
			logger.error("", e);
		}

		return revisions;
	}

}

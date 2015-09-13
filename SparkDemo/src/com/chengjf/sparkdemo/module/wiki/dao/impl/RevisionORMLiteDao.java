package com.chengjf.sparkdemo.module.wiki.dao.impl;

import java.util.List;

import com.chengjf.sparkdemo.module.wiki.dao.RevisionDao;
import com.chengjf.sparkdemo.module.wiki.model.Revision;

/**
 * RevisionDao的ORMLite实现
 * 
 * @author sharp
 * @date 2015-9-13
 * 
 */
public class RevisionORMLiteDao implements RevisionDao {

	@Override
	public List<Revision> getAllRevisions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Revision getRevisionById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addRevision(Revision revision) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateRevision(Revision revision) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteRevision(Revision revision) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteRevisionById(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

}

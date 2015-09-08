package com.chengjf.sparkdemo.module.wiki.dao.impl;

import java.util.List;

import com.chengjf.sparkdemo.dao.impl.CommonMybatisDao;
import com.chengjf.sparkdemo.module.wiki.dao.RevisionDao;
import com.chengjf.sparkdemo.module.wiki.model.Revision;

/**
 * RevisionDao的mybatis实现类
 * 
 * @author CHENGJIANFENG100
 * @date 2015-09-08
 */
public class RevisionMybatisDao extends CommonMybatisDao implements RevisionDao {

	@Override
	public List<Revision> getAllRevisions() {
		List<Revision> list = this.getSqlSession()
				.selectList("getAllRevisions");
		return list;
	}

	@Override
	public Revision getRevisionById(String id) {
		Revision revision = this.getSqlSession().selectOne("getRevisionById",
				id);
		return revision;
	}

	@Override
	public int addRevision(Revision revision) {
		int result = this.getSqlSession().insert("addRevision", revision);
		return result;
	}

	@Override
	public int updateRevision(Revision revision) {
		int result = this.getSqlSession().update("updateRevision", revision);
		return result;
	}

	@Override
	public int deleteRevision(Revision revision) {
		int result = this.getSqlSession().delete("deleteRevision", revision);
		return result;
	}

	@Override
	public int deleteRevisionById(String id) {
		int result = this.getSqlSession().delete("deleteRevisionById", id);
		return result;
	}

}

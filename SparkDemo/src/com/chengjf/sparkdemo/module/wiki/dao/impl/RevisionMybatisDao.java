package com.chengjf.sparkdemo.module.wiki.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

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
		SqlSession sqlSession = this.factory.openSession();
		List<Revision> list = sqlSession.selectList("getAllRevisions");
		sqlSession.close();
		return list;
	}

	@Override
	public Revision getRevisionById(String id) {
		SqlSession sqlSession = this.factory.openSession();
		Revision revision = sqlSession.selectOne("getRevisionById", id);
		sqlSession.close();
		return revision;
	}

	@Override
	public int addRevision(Revision revision) {
		SqlSession sqlSession = this.factory.openSession();
		int result = sqlSession.insert("addRevision", revision);
		sqlSession.commit();
		sqlSession.close();
		return result;
	}

	@Override
	public int updateRevision(Revision revision) {
		SqlSession sqlSession = this.factory.openSession();
		int result = sqlSession.update("updateRevision", revision);
		sqlSession.commit();
		sqlSession.close();
		return result;
	}

	@Override
	public int deleteRevision(Revision revision) {
		SqlSession sqlSession = this.factory.openSession();
		int result = sqlSession.delete("deleteRevision", revision);
		sqlSession.commit();
		sqlSession.close();
		return result;
	}

	@Override
	public int deleteRevisionById(String id) {
		SqlSession sqlSession = this.factory.openSession();
		int result = sqlSession.delete("deleteRevisionById", id);
		sqlSession.commit();
		sqlSession.close();
		return result;
	}

}

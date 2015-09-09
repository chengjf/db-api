package com.chengjf.sparkdemo.module.wiki.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.chengjf.sparkdemo.dao.impl.CommonMybatisDao;
import com.chengjf.sparkdemo.module.wiki.dao.PageDao;
import com.chengjf.sparkdemo.module.wiki.model.Page;

/**
 * PageDao的mybatis实现类
 * 
 * @author CHENGJIANFENG100
 * @date 2015-09-08
 */
public class PageMybatisDao extends CommonMybatisDao implements PageDao {

	@Override
	public List<Page> getAllPages() {
		SqlSession sqlSession = this.factory.openSession();
		List<Page> list = sqlSession.selectList("getAllPages");
		sqlSession.close();
		return list;
	}

	@Override
	public Page getPageById(String id) {
		SqlSession sqlSession = this.factory.openSession();
		Page page = sqlSession.selectOne("getPageById", id);
		sqlSession.close();
		return page;
	}

	@Override
	public int addPage(Page page) {
		SqlSession sqlSession = this.factory.openSession();
		int result = sqlSession.insert("addPage", page);
		sqlSession.commit();
		sqlSession.close();
		return result;
	}

	@Override
	public int updatePage(Page page) {
		SqlSession sqlSession = this.factory.openSession();
		int result = sqlSession.update("updatePage", page);
		sqlSession.commit();
		sqlSession.close();
		return result;
	}

	@Override
	public int deletePage(Page page) {
		SqlSession sqlSession = this.factory.openSession();
		int result = sqlSession.delete("deletePage", page);
		sqlSession.commit();
		sqlSession.close();
		return result;
	}

	@Override
	public int deletePageById(String id) {
		SqlSession sqlSession = this.factory.openSession();
		int result = sqlSession.delete("deletePageById", id);
		sqlSession.commit();
		sqlSession.close();
		return result;
	}

}

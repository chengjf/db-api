package com.chengjf.sparkdemo.module.wiki.dao.impl;

import java.util.List;

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
		List<Page> list = this.getSqlSession().selectList("getAllPages");
		return list;
	}

	@Override
	public Page getPageById(String id) {
		Page page = this.getSqlSession().selectOne("getPageById", id);
		return page;
	}

	@Override
	public int addPage(Page page) {
		int result = this.getSqlSession().insert("addPage", page);
		return result;
	}

	@Override
	public int updatePage(Page page) {
		int result = this.getSqlSession().update("updatePage", page);
		return result;
	}

	@Override
	public int deletePage(Page page) {
		int result = this.getSqlSession().delete("deletePage", page);
		return result;
	}

	@Override
	public int deletePageById(String id) {
		int result = this.getSqlSession().delete("deletePageById", id);
		return result;
	}

}

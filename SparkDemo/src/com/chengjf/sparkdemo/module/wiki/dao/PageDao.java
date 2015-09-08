package com.chengjf.sparkdemo.module.wiki.dao;

import java.util.List;

import com.chengjf.sparkdemo.module.wiki.model.Page;

/**
 * 页面DAO接口
 * 
 * @author CHENGJIANFENG100
 * @date 2015-09-08
 */
public interface PageDao {

	public List<Page> getAllPages();

	public Page getPageById(String id);

	public int addPage(Page page);

	public int updatePage(Page page);

	public int deletePage(Page page);

	public int deletePageById(String id);
}

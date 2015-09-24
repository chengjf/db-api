package com.chengjf.sparkdemo.module.wiki.service;

import java.util.List;
import java.util.Map;

import com.chengjf.sparkdemo.module.wiki.model.Page;
import com.chengjf.sparkdemo.module.wiki.model.Page.PageAttr;
import com.chengjf.sparkdemo.module.wiki.model.Revision;

/**
 * Wiki服务类
 * 
 * @author CHENGJIANFENG100
 * @date 2015-09-08
 */
public interface IWikiService {

	public Page addNewWiki(Map<String, Object> parameters);

	public List<Revision> getAllWikis();

	public Map<String, Object> getWikiByRevisionId(String revisionId);

	public int addClickCount(String pageId);

	public Page getPageByName(String name);

	public List<Page> getAllPages();

	public Page getPageById(String id);

	public List<Page> getPagesByTag(String tag);

	public List<Page> searchPage(String term, List<PageAttr> attrs);

	public Page updatePage(Map<String, Object> parameters);

	public boolean deletePage(Page page);
	
	public List<Revision> getRevisionForPage(Page page);
	
	public List<Page> getPagesByNamespace(String namespace);
}

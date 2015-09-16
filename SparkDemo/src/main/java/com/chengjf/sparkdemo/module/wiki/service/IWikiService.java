package com.chengjf.sparkdemo.module.wiki.service;

import java.util.List;
import java.util.Map;

import com.chengjf.sparkdemo.module.wiki.model.Revision;

/**
 * Wiki服务类
 * 
 * @author CHENGJIANFENG100
 * @date 2015-09-08
 */
public interface IWikiService {

	public boolean addNewWiki(Map<String, Object> parameters);

	public List<Revision> getAllWikis();

	public Map<String, Object> getWikiByRevisionId(String revisionId);

	public int addClickCount(String revisionId);
}

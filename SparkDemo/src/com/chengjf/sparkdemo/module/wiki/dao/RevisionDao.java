package com.chengjf.sparkdemo.module.wiki.dao;

import java.util.List;

import com.chengjf.sparkdemo.module.wiki.model.Revision;

/**
 * 修订版本DAO接口
 * 
 * @author CHENGJIANFENG100
 * @date 2015-09-08
 */
public interface RevisionDao {

	public List<Revision> getAllRevisions();

	public Revision getRevisionById(String id);

	public int addRevision(Revision revision);

	public int updateRevision(Revision revision);

	public int deleteRevision(Revision revision);

	public int deleteRevisionById(String id);
}

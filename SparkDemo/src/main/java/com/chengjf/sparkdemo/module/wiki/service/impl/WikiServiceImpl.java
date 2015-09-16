package com.chengjf.sparkdemo.module.wiki.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Callable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chengjf.sparkdemo.context.MyContext;
import com.chengjf.sparkdemo.module.wiki.dao.PageDao;
import com.chengjf.sparkdemo.module.wiki.dao.RevisionDao;
import com.chengjf.sparkdemo.module.wiki.dao.TextDao;
import com.chengjf.sparkdemo.module.wiki.model.Page;
import com.chengjf.sparkdemo.module.wiki.model.Revision;
import com.chengjf.sparkdemo.module.wiki.model.Text;
import com.chengjf.sparkdemo.module.wiki.service.IWikiService;
import com.j256.ormlite.misc.TransactionManager;
import com.j256.ormlite.support.ConnectionSource;

/**
 * wiki服务实现类
 * 
 * @author CHENGJIANFENG100
 * @date 2015-09-10
 */
public class WikiServiceImpl implements IWikiService {

	private static final Logger logger = LoggerFactory
			.getLogger(WikiServiceImpl.class);

	@Override
	public boolean addNewWiki(Map<String, Object> parameters) {
		// STEP 1. 组装Text
		final Text text = new Text();
		String context = (String) parameters.get("content");
		String type = (String) parameters.get("type");
		String textId = UUID.randomUUID().toString();
		text.setTextId(textId);
		text.setText(context);
		text.setType(type);

		// STEP 2. 组装Page
		final Page page = new Page();
		String namespace = (String) parameters.get("namespace");
		String title = (String) parameters.get("title");
		String comment = (String) parameters.get("comment");
		String pageId = UUID.randomUUID().toString();
		page.setPageId(pageId);
		page.setCounter(0);
		page.setTitle(title);
		page.setNamespace(namespace);
		page.setComment(comment);
		page.setCreatedDate(new Date());

		// STEP 3. 组装Revision
		final Revision revision = new Revision();
		String revisionId = UUID.randomUUID().toString();
		String userId = (String) parameters.get("userId");
		revision.setRevisionId(revisionId);
		revision.setText(text);
		revision.setPage(page);
		revision.setDeleted(false);
		revision.setTimestamp(new Date());
		revision.setUserId(userId);
		revision.setParentId(null);
		revision.setLatest(true);

		try {
			TransactionManager.callInTransaction(
					MyContext.context.getInstance(ConnectionSource.class),
					new Callable<Void>() {

						@Override
						public Void call() throws Exception {
							TextDao textDao = MyContext.context
									.getInstance(TextDao.class);
							textDao.addText(text);

							PageDao pageDao = MyContext.context
									.getInstance(PageDao.class);
							pageDao.addPage(page);

							RevisionDao revisionDao = MyContext.context
									.getInstance(RevisionDao.class);
							revisionDao.addRevision(revision);

							return null;
						}
					});
		} catch (SQLException e) {
			logger.error("", e);
		}

		return true;
	}

	@Override
	public List<Revision> getAllWikis() {
		RevisionDao revisionDao = MyContext.context
				.getInstance(RevisionDao.class);
		List<Revision> pageList = revisionDao.getAllRevisions();

		if (pageList == null) {
			pageList = new ArrayList<Revision>();
		}
		return pageList;
	}

	@Override
	public Map<String, Object> getWikiByRevisionId(String revisionId) {

		Map<String, Object> wiki = new HashMap<String, Object>();
		RevisionDao revisionDao = MyContext.context
				.getInstance(RevisionDao.class);
		Revision revision = revisionDao.getRevisionById(revisionId);
		wiki.put("revision", revision);

		return wiki;
	}

	@Override
	public int addClickCount(String revisionId) {
		RevisionDao revisionDao = MyContext.context
				.getInstance(RevisionDao.class);
		Revision revision = revisionDao.getRevisionById(revisionId);
		Page page = revision.getPage();
		int counter = page.getCounter() + 1;
		page.setCounter(counter);

		PageDao pageDao = MyContext.context.getInstance(PageDao.class);
		pageDao.updatePage(page);
		return counter;
	}
}

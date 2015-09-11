package com.chengjf.sparkdemo.module.wiki.service.impl;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

import com.chengjf.sparkdemo.context.MyContext;
import com.chengjf.sparkdemo.module.wiki.dao.PageDao;
import com.chengjf.sparkdemo.module.wiki.dao.RevisionDao;
import com.chengjf.sparkdemo.module.wiki.dao.TextDao;
import com.chengjf.sparkdemo.module.wiki.model.Page;
import com.chengjf.sparkdemo.module.wiki.model.Revision;
import com.chengjf.sparkdemo.module.wiki.model.Text;
import com.chengjf.sparkdemo.module.wiki.service.IWikiService;

/**
 * wiki服务实现类
 * 
 * @author CHENGJIANFENG100
 * @date 2015-09-10
 */
public class WikiServiceImpl implements IWikiService {

	@Override
	public boolean addNewWiki(Map<String, Object> parameters) {
		// STEP 1. 组装Text
		Text text = new Text();
		String context = (String) parameters.get("content");
		String textId = UUID.randomUUID().toString();
		text.setId(textId);
		text.setText(context);
		text.setType("text");

		// STEP 2. 组装Revision
		Revision revision = new Revision();
		String revisionId = UUID.randomUUID().toString();
		revision.setId(revisionId);
		revision.setTextId(textId);
		revision.setDeleted(false);
		revision.setTimestamp(new Date());
		revision.setUserId("");
		revision.setParentId("");

		// STEP 3. 组装Page
		Page page = new Page();
		String namespace = (String) parameters.get("namespace");
		String title = (String) parameters.get("title");
		String pageId = UUID.randomUUID().toString();
		page.setId(pageId);
		page.setCounter(0);
		page.setTitle(title);
		page.setNamespace(namespace);
		page.setLatest(revisionId);

		int result = 0;
		try {
			TextDao textDao = MyContext.context.getInstance(TextDao.class);
			result = textDao.addText(text);
			if (result == 0) {
				throw new RuntimeException();
			}
			RevisionDao revisionDao = MyContext.context
					.getInstance(RevisionDao.class);
			result = revisionDao.addRevision(revision);
			if (result == 0) {
				textDao.deleteText(text);
				throw new RuntimeException();
			}
			PageDao pageDao = MyContext.context.getInstance(PageDao.class);
			result = pageDao.addPage(page);
			if (result == 0) {
				textDao.deleteText(text);
				revisionDao.deleteRevision(revision);
				throw new RuntimeException();
			}
		} catch (Exception e) {

		}

		return true;
	}

}

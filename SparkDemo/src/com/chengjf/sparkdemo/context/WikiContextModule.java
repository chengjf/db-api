package com.chengjf.sparkdemo.context;

import com.chengjf.sparkdemo.controller.IController;
import com.chengjf.sparkdemo.model.IModel;
import com.chengjf.sparkdemo.module.wiki.controller.WikiAddController;
import com.chengjf.sparkdemo.module.wiki.controller.WikiListController;
import com.chengjf.sparkdemo.module.wiki.controller.WikiShowController;
import com.chengjf.sparkdemo.module.wiki.dao.PageDao;
import com.chengjf.sparkdemo.module.wiki.dao.RevisionDao;
import com.chengjf.sparkdemo.module.wiki.dao.TextDao;
import com.chengjf.sparkdemo.module.wiki.dao.impl.PageORMLiteDao;
import com.chengjf.sparkdemo.module.wiki.dao.impl.RevisionORMLiteDao;
import com.chengjf.sparkdemo.module.wiki.dao.impl.TextORMLiteDao;
import com.chengjf.sparkdemo.module.wiki.model.Page;
import com.chengjf.sparkdemo.module.wiki.model.Revision;
import com.chengjf.sparkdemo.module.wiki.model.Text;
import com.chengjf.sparkdemo.module.wiki.service.IWikiService;
import com.chengjf.sparkdemo.module.wiki.service.impl.WikiServiceImpl;
import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import com.google.inject.name.Names;

/**
 * Wiki模块的配置
 * 
 * @author CHENGJIANFENG100
 * @date 2015-09-11
 */
public class WikiContextModule extends AbstractModule {

	@Override
	protected void configure() {
		// Model
		bind(IModel.class).annotatedWith(Names.named("Text")).to(Text.class)
				.in(Scopes.SINGLETON);
		bind(IModel.class).annotatedWith(Names.named("Page")).to(Page.class)
				.in(Scopes.SINGLETON);
		bind(IModel.class).annotatedWith(Names.named("Revision"))
				.to(Revision.class).in(Scopes.SINGLETON);

		// URL
		bind(IController.class)
				.annotatedWith(Names.named("WikiListController"))
				.to(WikiListController.class).in(Scopes.SINGLETON);
		bind(IController.class).annotatedWith(Names.named("WikiAddController"))
				.to(WikiAddController.class).in(Scopes.SINGLETON);
		bind(IController.class)
				.annotatedWith(Names.named("WikiShowControllerg"))
				.to(WikiShowController.class).in(Scopes.SINGLETON);

		// Service
		bind(IWikiService.class).to(WikiServiceImpl.class).in(Scopes.SINGLETON);

		// DAO
		bind(PageDao.class).to(PageORMLiteDao.class).in(Scopes.SINGLETON);
		bind(TextDao.class).to(TextORMLiteDao.class).in(Scopes.SINGLETON);
		bind(RevisionDao.class).to(RevisionORMLiteDao.class).in(
				Scopes.SINGLETON);
	}

}

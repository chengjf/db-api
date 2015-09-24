package com.chengjf.sparkdemo.context.biz;

import com.chengjf.sparkdemo.controller.IController;
import com.chengjf.sparkdemo.model.IModel;
import com.chengjf.sparkdemo.module.index.controller.IndexController;
import com.chengjf.sparkdemo.module.wiki.controller.WikiCreateController;
import com.chengjf.sparkdemo.module.wiki.controller.WikiDeleteController;
import com.chengjf.sparkdemo.module.wiki.controller.WikiDisplayController;
import com.chengjf.sparkdemo.module.wiki.controller.WikiEditController;
import com.chengjf.sparkdemo.module.wiki.controller.WikiHomeController;
import com.chengjf.sparkdemo.module.wiki.controller.WikiIndexController;
import com.chengjf.sparkdemo.module.wiki.controller.WikiNamespaceController;
import com.chengjf.sparkdemo.module.wiki.controller.WikiSearchController;
import com.chengjf.sparkdemo.module.wiki.controller.WikiTagController;
import com.chengjf.sparkdemo.module.wiki.controller.WikiTagsController;
import com.chengjf.sparkdemo.module.wiki.dao.NamespaceDao;
import com.chengjf.sparkdemo.module.wiki.dao.PageDao;
import com.chengjf.sparkdemo.module.wiki.dao.RevisionDao;
import com.chengjf.sparkdemo.module.wiki.dao.TextDao;
import com.chengjf.sparkdemo.module.wiki.dao.impl.NamespaceORMLiteDao;
import com.chengjf.sparkdemo.module.wiki.dao.impl.PageORMLiteDao;
import com.chengjf.sparkdemo.module.wiki.dao.impl.RevisionORMLiteDao;
import com.chengjf.sparkdemo.module.wiki.dao.impl.TextORMLiteDao;
import com.chengjf.sparkdemo.module.wiki.model.Namespace;
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
		bind(IModel.class).annotatedWith(Names.named("Namespace"))
				.to(Namespace.class).in(Scopes.SINGLETON);
		// URL
		// bind(IController.class)
		// .annotatedWith(Names.named("WikiListController"))
		// .to(WikiListController.class).in(Scopes.SINGLETON);
		// bind(IController.class).annotatedWith(Names.named("WikiAddController"))
		// .to(WikiAddController.class).in(Scopes.SINGLETON);
		// bind(IController.class)
		// .annotatedWith(Names.named("WikiShowControllerg"))
		// .to(WikiShowController.class).in(Scopes.SINGLETON);
		bind(IController.class).annotatedWith(Names.named("IndexController"))
				.to(IndexController.class).in(Scopes.SINGLETON);

		bind(IController.class)
				.annotatedWith(Names.named("WikiHomeController"))
				.to(WikiHomeController.class).in(Scopes.SINGLETON);
		bind(IController.class)
				.annotatedWith(Names.named("WikiIndexController"))
				.to(WikiIndexController.class).in(Scopes.SINGLETON);
		bind(IController.class)
				.annotatedWith(Names.named("WikiEditController"))
				.to(WikiEditController.class).in(Scopes.SINGLETON);
		bind(IController.class)
				.annotatedWith(Names.named("WikiCreateController"))
				.to(WikiCreateController.class).in(Scopes.SINGLETON);
		bind(IController.class)
				.annotatedWith(Names.named("WikiDisplayController"))
				.to(WikiDisplayController.class).in(Scopes.SINGLETON);
		bind(IController.class)
				.annotatedWith(Names.named("WikiTagsController"))
				.to(WikiTagsController.class).in(Scopes.SINGLETON);
		bind(IController.class).annotatedWith(Names.named("WikiTagController"))
				.to(WikiTagController.class).in(Scopes.SINGLETON);
		bind(IController.class)
				.annotatedWith(Names.named("WikiSearchController"))
				.to(WikiSearchController.class).in(Scopes.SINGLETON);
		bind(IController.class)
				.annotatedWith(Names.named("WikiDeleteController"))
				.to(WikiDeleteController.class).in(Scopes.SINGLETON);
		bind(IController.class)
				.annotatedWith(Names.named("WikiNamespaceController"))
				.to(WikiNamespaceController.class).in(Scopes.SINGLETON);
		// Service
		bind(IWikiService.class).to(WikiServiceImpl.class).in(Scopes.SINGLETON);

		// DAO
		bind(PageDao.class).to(PageORMLiteDao.class).in(Scopes.SINGLETON);
		bind(TextDao.class).to(TextORMLiteDao.class).in(Scopes.SINGLETON);
		bind(RevisionDao.class).to(RevisionORMLiteDao.class).in(
				Scopes.SINGLETON);
		bind(NamespaceDao.class).to(NamespaceORMLiteDao.class).in(
				Scopes.SINGLETON);

	}

}

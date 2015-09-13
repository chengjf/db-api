package com.chengjf.sparkdemo.context;

import com.chengjf.sparkdemo.model.IModel;
import com.chengjf.sparkdemo.module.wiki.model.Page;
import com.chengjf.sparkdemo.module.wiki.model.Revision;
import com.chengjf.sparkdemo.module.wiki.model.Text;
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
	}

}

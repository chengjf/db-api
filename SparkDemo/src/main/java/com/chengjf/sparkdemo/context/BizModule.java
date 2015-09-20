package com.chengjf.sparkdemo.context;

import com.google.inject.AbstractModule;

/**
 * 
 * 
 * @author CHENGJIANFENG100
 * @date 2015-09-17
 */
public class BizModule extends AbstractModule {

	@Override
	protected void configure() {
		install(new ORMLiteContextModule());
		// install(new TodoContextModule());
		install(new WikiContextModule());

	}

}

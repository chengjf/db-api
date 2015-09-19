package com.chengjf.sparkdemo.context;

import com.chengjf.sparkdemo.context.provider.ORMLiteProvider;
import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import com.j256.ormlite.support.ConnectionSource;

/**
 * ORMLite module
 * 
 * @author CHENGJIANFENG100
 * @date 2015-09-11
 */
public class ORMLiteContextModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(ConnectionSource.class).toProvider(ORMLiteProvider.class).in(
				Scopes.SINGLETON);
	}

}

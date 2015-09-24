package com.chengjf.sparkdemo.context.biz;

import com.chengjf.sparkdemo.controller.IController;
import com.chengjf.sparkdemo.module.admin.controller.AdminIndexController;
import com.chengjf.sparkdemo.module.admin.controller.AdminTableController;
import com.chengjf.sparkdemo.module.admin.service.IAdminService;
import com.chengjf.sparkdemo.module.admin.service.impl.AdminServiceImpl;
import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import com.google.inject.name.Names;

/**
 * Wiki模块的配置
 * 
 * @author CHENGJIANFENG100
 * @date 2015-09-11
 */
public class AdminContextModule extends AbstractModule {

	@Override
	protected void configure() {
		// Model

		// Controller
		bind(IController.class)
				.annotatedWith(Names.named("AdminIndexController"))
				.to(AdminIndexController.class).in(Scopes.SINGLETON);
		bind(IController.class)
				.annotatedWith(Names.named("AdminTableController"))
				.to(AdminTableController.class).in(Scopes.SINGLETON);
		// Service
		bind(IAdminService.class).to(AdminServiceImpl.class).in(
				Scopes.SINGLETON);

		// DAO

	}

}

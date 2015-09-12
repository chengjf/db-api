package com.chengjf.sparkdemo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chengjf.sparkdemo.context.ContextModule;
import com.chengjf.sparkdemo.context.MyContext;
import com.chengjf.sparkdemo.context.MybatisContextModule;
import com.chengjf.sparkdemo.context.ORMLiteContextModule;
import com.chengjf.sparkdemo.context.TodoContextModule;
import com.chengjf.sparkdemo.controller.IController;
import com.chengjf.sparkdemo.filter.MyFilter;
import com.chengjf.sparkdemo.resource.StaticResource;
import com.google.inject.Binding;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.TypeLiteral;

/**
 * 系统启动初始化配置
 * 
 * @author sharp
 * @date 2015-9-3
 * 
 */

public class Bootstrap {

	private static final Logger logger = LoggerFactory
			.getLogger(Bootstrap.class);

	private Injector injector;

	public Bootstrap() {
		logger.debug("init......");
		this.injector = Guice.createInjector(new ContextModule(),
				new MybatisContextModule(), new ORMLiteContextModule(),
				new TodoContextModule());
		MyContext.context = this.injector;
	}

	public void boot() {
		logger.debug("boot start...");

		initResource();
		initFilter();
		initController();

		logger.debug("boot end...");
	}

	/**
	 * 初始化资源
	 */
	private void initResource() {
		StaticResource resource = this.injector
				.getInstance(StaticResource.class);
		resource.execute();
	}

	/**
	 * 初始化Filter
	 */
	private void initFilter() {
		List<Binding<MyFilter>> list = injector
				.findBindingsByType(new TypeLiteral<MyFilter>() {
				});
		for (Binding<MyFilter> bind : list) {
			MyFilter filter = injector.getInstance(bind.getKey());
			filter.start();
		}
	}

	/**
	 * 初始化Controller
	 */
	private void initController() {
		List<Binding<IController>> list = injector
				.findBindingsByType(new TypeLiteral<IController>() {
				});
		for (Binding<IController> bind : list) {
			IController controller = injector.getInstance(bind.getKey());
			controller.start();
		}
	}

}

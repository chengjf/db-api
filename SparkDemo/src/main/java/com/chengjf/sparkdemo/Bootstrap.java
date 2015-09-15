package com.chengjf.sparkdemo;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chengjf.sparkdemo.context.ContextModule;
import com.chengjf.sparkdemo.context.MyContext;
import com.chengjf.sparkdemo.context.MybatisContextModule;
import com.chengjf.sparkdemo.context.ORMLiteContextModule;
import com.chengjf.sparkdemo.context.TodoContextModule;
import com.chengjf.sparkdemo.context.WikiContextModule;
import com.chengjf.sparkdemo.controller.IController;
import com.chengjf.sparkdemo.filter.MyFilter;
import com.chengjf.sparkdemo.model.IModel;
import com.chengjf.sparkdemo.resource.StaticResource;
import com.google.inject.Binding;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.TypeLiteral;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

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
				new TodoContextModule(), new WikiContextModule());
		MyContext.context = this.injector;
	}

	public void boot() {
		logger.debug("boot start...");

		initResource();

		initDatabase();

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

	/**
	 * 初始化数据库
	 */
	private void initDatabase() {
		List<Binding<IModel>> list = injector
				.findBindingsByType(new TypeLiteral<IModel>() {
				});
		for (Binding<IModel> bind : list) {
			IModel model = injector.getInstance(bind.getKey());
			createTable(model.getClass());
		}

	}

	/**
	 * 建表
	 * 
	 * @param t
	 */
	private <T> void createTable(Class<T> t) {
		try {
			ConnectionSource connectionSource = MyContext.context
					.getInstance(ConnectionSource.class);

			Dao<T, String> dao = DaoManager.createDao(connectionSource, t);
			if (!dao.isTableExists()) {
				TableUtils.createTable(connectionSource, t);
				logger.debug("成功创建表 " + t);
			} else {
				logger.debug("表已存在 " + t);
			}

		} catch (SQLException e) {
			logger.error("", e);
		}
	}
}

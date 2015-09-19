package com.chengjf.sparkdemo;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chengjf.sparkdemo.context.BizModule;
import com.chengjf.sparkdemo.context.ContextModule;
import com.chengjf.sparkdemo.context.MyContext;
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
		logger.debug("系统开始初始化......");
		this.injector = Guice.createInjector(new ContextModule(),
				new BizModule());
		MyContext.context = this.injector;
	}

	public void boot() {
		logger.debug("系统开始启动......");

		initDatabase();

		initFilter();

		initController();

		logger.debug("系统启动完毕......");
	}

	/**
	 * 初始化资源
	 */
	public void initResource() {
		logger.debug("Spark框架静态资源初始化开始......");
		StaticResource resource = this.injector
				.getInstance(StaticResource.class);
		resource.execute();
		logger.debug("Spark框架静态资源初始化结束......");
	}

	/**
	 * 初始化Filter
	 */
	private void initFilter() {
		logger.debug("Spark框架Filter初始化开始......");
		List<Binding<MyFilter>> list = injector
				.findBindingsByType(new TypeLiteral<MyFilter>() {
				});
		for (Binding<MyFilter> bind : list) {
			MyFilter filter = injector.getInstance(bind.getKey());
			filter.start();
			logger.debug("Spark框架Filter初始化结束......");
		}
	}

	/**
	 * 初始化Controller
	 */
	private void initController() {
		logger.debug("Controller初始化开始......");
		List<Binding<IController>> list = injector
				.findBindingsByType(new TypeLiteral<IController>() {
				});
		for (Binding<IController> bind : list) {
			IController controller = injector.getInstance(bind.getKey());
			controller.start();
		}
		logger.debug("Controller初始化结束......");
	}

	/**
	 * 初始化数据库
	 */
	private void initDatabase() {
		logger.debug("数据库开始初始化......");
		List<Binding<IModel>> list = injector
				.findBindingsByType(new TypeLiteral<IModel>() {
				});
		for (Binding<IModel> bind : list) {
			IModel model = injector.getInstance(bind.getKey());
			createTable(model.getClass());
		}
		logger.debug("数据库初始化完毕......");
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

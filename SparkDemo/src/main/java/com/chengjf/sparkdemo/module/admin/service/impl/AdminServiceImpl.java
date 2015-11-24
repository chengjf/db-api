package com.chengjf.sparkdemo.module.admin.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chengjf.sparkdemo.context.MyContext;
import com.chengjf.sparkdemo.model.IModel;
import com.chengjf.sparkdemo.module.admin.model.Table;
import com.chengjf.sparkdemo.module.admin.service.IAdminService;
import com.google.inject.Binding;
import com.google.inject.TypeLiteral;
import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableInfo;

/**
 * 后台服务实现类
 * 
 * @author sharp
 * @date 2015-9-30
 * 
 */
public class AdminServiceImpl implements IAdminService {

	private static final Logger logger = LoggerFactory
			.getLogger(AdminServiceImpl.class);

	@Override
	public List<Table> getAllTables() {
		List<Table> tables = new ArrayList<Table>();
		List<Binding<IModel>> list = MyContext.context
				.findBindingsByType(new TypeLiteral<IModel>() {
				});

		for (Binding<IModel> bind : list) {
			IModel model = MyContext.context.getInstance(bind.getKey());
			Table table = getTable(model);
			if (!"".equals(table.getTableName())) {
				tables.add(table);
			}
		}

		return tables;
	}

	@SuppressWarnings("unchecked")
	private Table getTable(IModel model) {
		Table table = new Table();
		try {
			ConnectionSource connectionSource = MyContext.context
					.getInstance(ConnectionSource.class);
			Dao<IModel, String> dao = DaoManager.createDao(connectionSource,
					model.getClass());
			if (dao.isTableExists()) {
				TableInfo<IModel, String> tableInfo = new TableInfo<IModel, String>(
						connectionSource, (BaseDaoImpl<IModel, String>) dao,
						(Class<IModel>) model.getClass());

				table.setTableName(tableInfo.getTableName());
				table.setRowNumber(dao.countOf());
				table.setFieldTypes(tableInfo.getFieldTypes());
				table.setDataClass(tableInfo.getDataClass());
			} else {
			}

		} catch (SQLException e) {
			logger.error("", e);
		}
		return table;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Table getTableByTableClassName(String tableClass) {
		Table table = new Table();
		Class t;
		try {
			t = Class.forName(tableClass);
			ConnectionSource connectionSource = MyContext.context
					.getInstance(ConnectionSource.class);
			Dao<?, String> dao = DaoManager.createDao(connectionSource, t);
			if (dao.isTableExists()) {
				TableInfo<IModel, String> tableInfo = new TableInfo<IModel, String>(
						connectionSource, (BaseDaoImpl<IModel, String>) dao, t);

				table.setTableName(tableInfo.getTableName());
				table.setRowNumber(dao.countOf());
				table.setFieldTypes(tableInfo.getFieldTypes());
				table.setDataClass((Class<IModel>) dao.getDataClass());
			} else {
				logger.error("下表未创建！" + tableClass);
			}
		} catch (ClassNotFoundException e) {
			logger.error("", e);
		} catch (SQLException e) {
			logger.error("", e);
		}
		return table;
	}

	@Override
	public List<IModel> getTableData(Table table) {

		List<IModel> rs = new ArrayList<IModel>();
		try {
			ConnectionSource connectionSource = MyContext.context
					.getInstance(ConnectionSource.class);
			Dao<IModel, String> dao = DaoManager.createDao(connectionSource,
					table.getDataClass());
			if (dao.isTableExists()) {
				rs = dao.queryForAll();
			} else {
				logger.error("下表未创建！" + table.getTableName());
			}
		} catch (SQLException e) {
			logger.error("", e);
		}
		return rs;
	}
}

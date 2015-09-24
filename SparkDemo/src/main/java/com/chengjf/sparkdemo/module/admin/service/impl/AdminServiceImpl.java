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

public class AdminServiceImpl implements IAdminService {

	private static final Logger logger = LoggerFactory
			.getLogger(AdminServiceImpl.class);

	@SuppressWarnings("rawtypes")
	@Override
	public List<Table> getAllTables() {
		List<Table> tables = new ArrayList<Table>();
		List<Binding<IModel>> list = MyContext.context
				.findBindingsByType(new TypeLiteral<IModel>() {
				});

		for (Binding<IModel> bind : list) {
			IModel model = MyContext.context.getInstance(bind.getKey());
			Table table = getTable(model.getClass());
			if (!"".equals(table.getTableName())) {
				tables.add(table);
			}
		}

		return tables;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private <T> Table getTable(Class<T> t) {
		Table table = new Table();
		try {
			ConnectionSource connectionSource = MyContext.context
					.getInstance(ConnectionSource.class);
			Dao<T, String> dao = DaoManager.createDao(connectionSource, t);
			if (dao.isTableExists()) {
				TableInfo<T, String> tableInfo = new TableInfo<T, String>(
						connectionSource, (BaseDaoImpl<T, String>) dao, t);

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
	public <T> Table getTableByTableClassName(String tableClass) {
		Table table = new Table();
		Class t;
		try {
			t = Class.forName(tableClass);
			ConnectionSource connectionSource = MyContext.context
					.getInstance(ConnectionSource.class);
			Dao<?, String> dao = DaoManager.createDao(connectionSource, t);
			if (dao.isTableExists()) {
				TableInfo<?, String> tableInfo = new TableInfo<T, String>(
						connectionSource, (BaseDaoImpl<T, String>) dao, t);

				table.setTableName(tableInfo.getTableName());
				table.setRowNumber(dao.countOf());
				table.setFieldTypes(tableInfo.getFieldTypes());
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
}

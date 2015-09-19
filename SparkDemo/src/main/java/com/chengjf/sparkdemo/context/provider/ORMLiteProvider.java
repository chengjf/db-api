package com.chengjf.sparkdemo.context.provider;

import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chengjf.sparkdemo.constants.DatabaseConstants;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.name.Named;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;

/**
 * ORMLite获取Provider
 * 
 * @author sharp
 * @date 2015-9-12
 * 
 */
public class ORMLiteProvider implements Provider<ConnectionSource> {

	private static final Logger logger = LoggerFactory
			.getLogger(ORMLiteProvider.class);

	private String databaseUrl;

	@Inject
	public ORMLiteProvider(
			@Named(DatabaseConstants.DATABASE_URL) String databaseUrl) {
		this.databaseUrl = databaseUrl;
	}

	@Override
	public ConnectionSource get() {
		ConnectionSource connectionSource = null;
		try {
			connectionSource = new JdbcConnectionSource(databaseUrl);
		} catch (SQLException e) {
			logger.error("ORMLite数据源初始化错误！", e);
		}
		return connectionSource;
	}

}

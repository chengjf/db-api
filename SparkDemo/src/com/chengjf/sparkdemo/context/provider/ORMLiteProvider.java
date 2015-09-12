package com.chengjf.sparkdemo.context.provider;

import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.Provider;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;

public class ORMLiteProvider implements Provider<ConnectionSource> {

	private static final Logger logger = LoggerFactory
			.getLogger(ORMLiteProvider.class);

	@Override
	public ConnectionSource get() {
		String databaseUrl = "jdbc:sqlite:./resource/app.db";
		// create a connection source to our database
		ConnectionSource connectionSource = null;
		try {
			connectionSource = new JdbcConnectionSource(databaseUrl);
		} catch (SQLException e) {
			logger.error("ORMLite数据源初始化错误！", e);
		}
		return connectionSource;
	}

}

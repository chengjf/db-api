package com.chengjf.sparkdemo.context;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

import org.apache.ibatis.io.Resources;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chengjf.sparkdemo.configuration.ConfigurationBean;
import com.github.joschi.jadconfig.JadConfig;
import com.github.joschi.jadconfig.RepositoryException;
import com.github.joschi.jadconfig.ValidationException;
import com.github.joschi.jadconfig.guice.NamedConfigParametersModule;
import com.github.joschi.jadconfig.repositories.EnvironmentRepository;
import com.github.joschi.jadconfig.repositories.PropertiesRepository;
import com.google.inject.AbstractModule;

public class ConfigurationModule extends AbstractModule {

	private static final Logger logger = LoggerFactory
			.getLogger(ConfigurationModule.class);

	private static String DEV_CONFIG_FILE = "dev-config.properties";
	private static String PRODUCTION_CONFIG_FILE = "production-config.properties";

	public static boolean isDev = true;

	@Override
	protected void configure() {

		ConfigurationBean configurationBean = new ConfigurationBean();

		try {
			File file = null;
			if (isDev) {
				logger.debug("将采用开发环境配置！");
				file = Resources.getResourceAsFile(DEV_CONFIG_FILE);
				new JadConfig(Arrays.asList(new EnvironmentRepository(),
						new PropertiesRepository(file)), configurationBean)
						.process();
			} else {
				logger.debug("将采用部署环境配置！");
				file = Resources.getResourceAsFile(PRODUCTION_CONFIG_FILE);
				new JadConfig(Arrays.asList(new EnvironmentRepository(),
						new PropertiesRepository(file)), configurationBean)
						.process();
			}

		} catch (RepositoryException e) {
			logger.error("配置模块加载出错！", e);
		} catch (ValidationException e) {
			logger.error("配置模块加载出错！", e);
		} catch (IOException e) {
			logger.error("配置模块加载出错！", e);
		}

		install(new NamedConfigParametersModule(
				Collections.singleton(configurationBean)));
		logger.debug("配置模块加载完毕！");

	}

}

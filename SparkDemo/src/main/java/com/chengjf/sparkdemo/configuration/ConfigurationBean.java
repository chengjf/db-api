package com.chengjf.sparkdemo.configuration;

import com.chengjf.sparkdemo.constants.DatabaseConstants;
import com.chengjf.sparkdemo.constants.WebConstants;
import com.github.joschi.jadconfig.Parameter;

/**
 * 
 * @author sharp
 * @date 2015-9-19
 * 
 */
public class ConfigurationBean {

	@Parameter(value = WebConstants.BASE_URL)
	public String baseUrl;

	@Parameter(value = WebConstants.BASE_STATIC_FILE_URL)
	public String baseStaticFileUrl;

	@Parameter(value = DatabaseConstants.DATABASE_URL)
	public String databaseUrl;

	@Parameter(value = DatabaseConstants.MYBATIS_CONFIG_FILE)
	public String mybatisConfigFile;

	@Parameter(value = WebConstants.STATIC_FILE_LOCATION)
	public String staticFileLocation;

	@Parameter(value = WebConstants.EXTERNAL_STATIC_FILE_LOCATION)
	public String externalStaticFileLocation;

	@Parameter(value = WebConstants.TEMPLATE_PATH)
	public String templatePath;
}

package org.common.com.constant;

import java.util.HashMap;
import java.util.Properties;

public class SystemConstant {

	public static ThreadLocal<HashMap> debugInfo = new ThreadLocal<HashMap>();
	private static Properties webProperties;

	public  Properties getWebProperties() {
		return webProperties;
	}

	public  void setWebProperties(Properties webProperties) {
		this.webProperties = webProperties;
	}

	public static String getESB_URL()
	{
		return webProperties.getProperty("ESB_URL").trim();
	}
	//高德KEY
	public static String getGAODE_KEY()
	{
		return webProperties.getProperty("GAODE_KEY").trim();
	}
	//腾讯KEY
	public static String getTENGCENT_KEY()
	{
		return webProperties.getProperty("TENGCENT_KEY").trim();
	}

	public static String getRedisHost()
	{
		return webProperties.getProperty("redisHost").trim();
	}
	
	public static String getRedisAuth()
	{
		try
		{
			return webProperties.getProperty("redisAuth").trim();
		}catch(Exception e)
		{
			return "-1";
		}
	}

}

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
	//获取SysCode
	public static String getESB_ReqSysCode(){
		return webProperties.getProperty("GIS_SYS_CODE").trim() ;
	}

	public static String getZhiYunOpenApi_Url(){
		return webProperties.getProperty("ZhiYunOpenApi_Url").trim() ;
	}

	public static String getZhiYunOpenApiClientId_1(){

		return webProperties.getProperty("ZhiYunOpenApiClientId_1").trim() ;
	}
	public static String getZhiYunOpenApiClientId_2(){

		return webProperties.getProperty("ZhiYunOpenApiClientId_2").trim() ;
	}
	public static String getZhiYunOpenApiClientId_3(){

		return webProperties.getProperty("ZhiYunOpenApiClientId_3").trim() ;
	}

	public static String getZhiYunOpenApi_User_1(){

		return webProperties.getProperty("ZhiYunOpenApi_User_1").trim() ;
	}

	public static String getZhiYunOpenApi_User_2(){

		return webProperties.getProperty("ZhiYunOpenApi_User_2").trim() ;
	}

	public static String getZhiYunOpenApi_User_3(){

		return webProperties.getProperty("ZhiYunOpenApi_User_3").trim() ;
	}

	public static String getZhiYunOpenApi_Pwd_1(){

		return webProperties.getProperty("ZhiYunOpenApi_Pwd_1").trim() ;
	}

	public static String getZhiYunOpenApi_Pwd_2(){

		return webProperties.getProperty("ZhiYunOpenApi_Pwd_2").trim() ;
	}

	public static String getZhiYunOpenApi_Pwd_3(){

		return webProperties.getProperty("ZhiYunOpenApi_Pwd_3").trim() ;
	}



}

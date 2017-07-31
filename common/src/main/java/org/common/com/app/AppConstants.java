package org.common.com.app;

import java.util.ResourceBundle;

/**
 * 系统常量定义
 * @author wanglei
 *
 */
public class AppConstants {

	private static ResourceBundle config = ResourceBundle.getBundle("system");


	public static boolean IS_AES(){
		try
		{
			String s = config.getString("IS_AES").trim();
			if(s.equals("true")||s.equals("1")){
				return true;
			}else
			{
				return false;
			}
		}catch(Exception e){
			return false;
		}
	}
	
	public static String app_pwd(){
		try
		{
			return config.getString("app_pwd");
		}catch(Exception e)
		{
			return null;
		}
	}
	
	public static String IV(){
		try
		{
			return config.getString("IV");
		}catch(Exception e)
		{
			return "";
		}
	}
	
	public static String KEY1(){
		try
		{
			return config.getString("KEY1");
		}catch(Exception e)
		{
			return "";
		}
	}
	
	
	public static String KEY2(){
		try
		{
			return config.getString("KEY2");
		}catch(Exception e)
		{
			return "";
		}
	}
	
	public static String SECURITY_KEY(){
		try
		{
			return config.getString("SECURITY_KEY");
		}catch(Exception e)
		{
			return "";
		}
	}
	
	
	
}

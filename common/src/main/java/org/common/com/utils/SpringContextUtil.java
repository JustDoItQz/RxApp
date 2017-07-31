package org.common.com.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpringContextUtil implements ApplicationContextAware {

	private static ApplicationContext applicationContext; // Spring应用上下文环境

	/**
	 * 实现ApplicationContextAware接口的回调方法，设置上下文环境
	 * 
	 * @param applicationContext
	 * @throws BeansException
	 */
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		SpringContextUtil.applicationContext = applicationContext;
	}

	/**
	 * @return ApplicationContext
	 */
	public static ApplicationContext getApplicationContext() {
		return SpringContextUtil.applicationContext;
	}

	/**
	 * 获取对象
	 * 
	 * @param name
	 * @return Object 一个以所给名字注册的bean的实例
	 * @throws BeansException
	 */
	public static <T> T getBean(String name)
	{
		try
		{
			return (T)applicationContext.getBean(name);
		}catch(Exception e)
		{
			return null;
		}
	}
	
	public static <T> T getBean(String name,String version)
	{
		try
		{
			if(version ==null||version.equals("") )
			{
				version ="v1.0";
			}
			name = name.trim()+"-"+version.trim();
			return (T)applicationContext.getBean(name);
		}catch(Exception e)
		{
			return null;
		}
	}
	
	
}

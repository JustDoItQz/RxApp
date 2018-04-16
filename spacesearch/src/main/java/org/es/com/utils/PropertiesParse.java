package org.es.com.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PropertiesParse {
	private static Log log = LogFactory.getLog(PropertiesParse.class);

	private final static String FILE = "config.properties";
	static Properties pro;
	static {
		try {
			pro = new Properties();
			InputStream in = PropertiesParse.class.getClassLoader().getResourceAsStream(FILE);
			pro.load(in);
		} catch (IOException e) {
			e.printStackTrace();
			log.error("初始化属性文件异常！", e);
		}
	}

	public static String getProperty(String... str) {
		if (StringUtil.isStringArrayEmpty(str)) {
			return null;
		}

		String key;
		String defaultValue;

		if (pro == null) {
			return null;
		}

		if (str.length == 2) {
			key = str[0];
			defaultValue = str[1];
			return pro.getProperty(key, defaultValue);
		}		
		if (str.length == 1) {
			key = str[0];
			return pro.getProperty(key);
		}
		return null;

	}

	public static boolean containsKey(String key) {
		if (pro == null) {
			return false;
		}

		return pro.containsKey(key);
	}
	
public static void main(String args[]){
	System.out.println(PropertiesParse.getProperty("sorting.rdb.protocol"));
}
}

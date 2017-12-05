package org.es.com.utils;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.lang.StringUtils;

public class GsonUtil {
	
	 public static <T> T strToObj(String json, TypeToken<T> token) {
			if (StringUtils.isEmpty(json)) {
				return null;
			}
			GsonBuilder builder = new GsonBuilder();
			Gson gson = builder.create();
			try {
				return (T) gson.fromJson(json, token.getType());
			} catch (Exception ex) {
			ex.printStackTrace();
			//log.error(json + " 无法转换为 " + token.getRawType().getName() + " 对象!", ex);
			return null;
			}
		} 
	 
	 
	 public static <T> String objToStr(T obj)
	 {
		 try
		 {
			 //Gson gson = new Gson();
			 Gson gson= new GsonBuilder().serializeNulls().create();
		     String str = gson.toJson(obj);
		     return str;
		 }catch(Exception e)
		 {
			 return null;
		 }
	 }
	 
	 public static <T> T strToObj(String json, Class<T> clazz){
	        T _T;
	        try{
	        	
	        	if (StringUtils.isEmpty(json)) {
					return null;
				}
	                Gson gson = new Gson();
	                _T = gson.fromJson(json, clazz);
	           
	        }catch (Exception e){
	            e.printStackTrace();
	            _T = null;
	        }
	        return _T;
	    }
}

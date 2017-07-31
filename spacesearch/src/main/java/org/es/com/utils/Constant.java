package org.es.com.utils;

import java.util.Properties;

/**
 * Created by on 2017/6/27.
 * Author Aaron.Wang
 */
public class Constant {
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

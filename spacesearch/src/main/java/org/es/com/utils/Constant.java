package org.es.com.utils;

import org.es.com.vo.IpsPortBean;

import java.util.ArrayList;
import java.util.List;
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
    public static List<IpsPortBean> getES_IPS()
    {
        List<IpsPortBean> ipsPortBeans = new ArrayList<IpsPortBean>() ;
        String esIp = webProperties.getProperty("ES_IPS").trim() ;
        String [] ips = esIp.split(";") ;
        if (ips!=null&&ips.length>0){
            for (String ip:ips){
                IpsPortBean portBean = new IpsPortBean() ;
                String[] ipp = ip.split(":");
                if (ipp[0].equals("127.0.0.1")){
                    String localIp = SystemTool.getLocalIPEth0() ;
                    portBean.setIp(localIp);
                }else{
                    portBean.setIp(ipp[0]);
                }
                portBean.setPort(Integer.valueOf(ipp[1]));
                ipsPortBeans.add(portBean) ;
            }
        }
        System.out.println("ES启动对应的IP地址："+esIp);
        return ipsPortBeans ;
    }
    public static String getES_CLUSTERNAME()
    {
        return webProperties.getProperty("ES_CLUSTERNAME").trim();
    }
    public static String getNUMBER_OF_REPLICAS()
    {
        return webProperties.getProperty("NUMBER_OF_REPLICAS").trim();
    }

    public static String getNUMBER_OF_SHARDS()
    {
        return webProperties.getProperty("NUMBER_OF_SHARDS").trim();
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

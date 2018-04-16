package org.es.com.utils;


import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public final class Constant {
	
	private static Properties webProperties;
	
	public static Properties getWebProperties() {
		return webProperties;
	}

	public static void setWebProperties(Properties webProperties) {
		Constant.webProperties = webProperties;
	}

	public static enum Result {

		SERVER_EXCEPTION(-1001, "服务器端错误"),
		
		PARAM_JSONEXCEPTION(-1003, "参数不符合JSON格式"),
		
		ADDRESSGEO_EXCEPTION(-1004, "地址转换经纬度错误"),
		
		LOCATION_EXCEPTION(-1005, "找不到当前车辆位置"),
		
		DATEFORMAT_EXCEPTION(-1002, "时间格式不正确");

		private Result(int code, String message) {
			this.code = code;
			this.message = message;
		}

		private int code;

		private String message;

		public int getCode() {
			return code;
		}

		public String getMessage() {
			return message;
		}
	}

	public static String getAPP_SYSTEM()
	{
		//return "http://192.168.1.176:9090/gisapp/";
		return webProperties.getProperty("APP_SYSTEM").trim();
	}
	
	public static List<IpsPortBean> getES_IP()
	{
		List<IpsPortBean> ipsPortBeans = new ArrayList<IpsPortBean>();
		String esIp = webProperties.getProperty("ES_IPS").trim();
		String[] ips = esIp.split(";");
		if(ips!=null&&ips.length>0){
			for (String ip : ips) {
				IpsPortBean portBean = new IpsPortBean();
				String[] ipp = ip.split(":");
				if(ipp[0].equals("127.0.0.1")){
					String localIp = SystemTool.getLocalIPEth0();
					portBean.setIp(localIp);
				}else{
					portBean.setIp(ipp[0]);
				}
				portBean.setPort(Integer.valueOf(ipp[1]));
				ipsPortBeans.add(portBean);
			}
		}
		System.out.println("ES启动对应的IP地址"+esIp);
		return ipsPortBeans;
	}
	
	public static String getAMAP_KEY()
	{
		return webProperties.getProperty("AMAP_KEY").trim();
	}
	
	public static String getES_CLUSTERNAME()
	{
		return webProperties.getProperty("ES_CLUSTERNAME").trim();
	}
	/**
	 * 副本
	 * @return
	 */
	public static String getNUMBER_OF_REPLICAS()
	{
		return webProperties.getProperty("NUMBER_OF_REPLICAS").trim();
	}
	/**
	 * 分片
	 * @return
	 */
	public static String getNUMBER_OF_SHARDS()
	{
		return webProperties.getProperty("NUMBER_OF_SHARDS").trim();
	}
	
	public static void main(String[] args) {
		String esIp = "192.168.2.18:9200;192.168.3.18:9200";
		String[] ips = esIp.split(";");
		if(ips!=null&&ips.length>0){
			for (String ip : ips) {
				System.out.println(ip);
			}
		}
	}
}

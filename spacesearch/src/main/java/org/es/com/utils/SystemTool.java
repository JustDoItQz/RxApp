package org.es.com.utils;

import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class SystemTool {
	private SystemTool() {
		
	}
	
	public static void main(String[] args) {
		/*List<String> list = getLocalIPS();
		for (String str : list) {
			System.out.println(str);
		}*/
		
		System.out.println(getLocalIPEth0());
	}

	/**
	 * 此方法描述的是：获得服务器的IP地址
	 * 
	 * @author: 
	 * @version: 2014年9月5日 下午4:57:15
	 */
	public static String getLocalIP() {
		String sIP = "";
		InetAddress ip = null;
		try {
			boolean bFindIP = false;
			Enumeration<NetworkInterface> netInterfaces = (Enumeration<NetworkInterface>) NetworkInterface.getNetworkInterfaces();
			while (netInterfaces.hasMoreElements()) {
				if (bFindIP) {
					break;
				}
				NetworkInterface ni = (NetworkInterface) netInterfaces.nextElement();
				Enumeration<InetAddress> ips = ni.getInetAddresses();
				while (ips.hasMoreElements()) {
					ip = (InetAddress) ips.nextElement();
					if (!ip.isLoopbackAddress() //非127.0.0.1
							&& ip.getHostAddress().matches("(\\d{1,3}\\.){3}\\d{1,3}")) {
						bFindIP = true;
						break;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (null != ip) {
			sIP = ip.getHostAddress();
		}
		return sIP;
	}

	/**
	 * 此方法描述的是：获得服务器的IP地址(多网卡)
	 * 
	 * @author: 
	 * @version: 2014年9月5日 下午4:57:15
	 */
	public static List<String> getLocalIPS() {
		InetAddress ip = null;
		List<String> ipList = new ArrayList<String>();
		try {
			Enumeration<NetworkInterface> netInterfaces = (Enumeration<NetworkInterface>) NetworkInterface.getNetworkInterfaces();
			while (netInterfaces.hasMoreElements()) {
				NetworkInterface ni = (NetworkInterface) netInterfaces.nextElement();
				Enumeration<InetAddress> ips = ni.getInetAddresses();
				while (ips.hasMoreElements()) {
					ip = (InetAddress) ips.nextElement();
					if (!ip.isLoopbackAddress() //非127.0.0.1
							&& ip.getHostAddress().matches("(\\d{1,3}\\.){3}\\d{1,3}")) {
						ipList.add(ip.getHostAddress());
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ipList;
	}

	/**
	 * 此方法描述的是：获得服务器的MAC地址
	 * 
	 * @author: 
	 * @version: 2014年9月5日 下午1:27:25
	 */
	public static String getMacId() {
		String macId = "";
		InetAddress ip = null;
		NetworkInterface ni = null;
		try {
			boolean bFindIP = false;
			Enumeration<NetworkInterface> netInterfaces = (Enumeration<NetworkInterface>) NetworkInterface.getNetworkInterfaces();
			while (netInterfaces.hasMoreElements()) {
				if (bFindIP) {
					break;
				}
				ni = (NetworkInterface) netInterfaces.nextElement();
				// ----------特定情况，可以考虑用ni.getName判断
				// 遍历所有ip
				Enumeration<InetAddress> ips = ni.getInetAddresses();
				while (ips.hasMoreElements()) {
					ip = (InetAddress) ips.nextElement();
					if (!ip.isLoopbackAddress() // 非127.0.0.1
							&& ip.getHostAddress().matches("(\\d{1,3}\\.){3}\\d{1,3}")) {
						bFindIP = true;
						break;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (null != ip) {
			try {
				macId = getMacFromBytes(ni.getHardwareAddress());
			} catch (SocketException e) {
				e.printStackTrace();
			}
		}
		return macId;
	}

	/**
	 * 此方法描述的是：获得服务器的MAC地址(多网卡)
	 * 
	 * @author: 
	 * @version: 2014年9月5日 下午1:27:25
	 */
	public static List<String> getMacIds() {
		InetAddress ip = null;
		NetworkInterface ni = null;
		List<String> macList = new ArrayList<String>();
		try {
			Enumeration<NetworkInterface> netInterfaces = (Enumeration<NetworkInterface>) NetworkInterface
					.getNetworkInterfaces();
			while (netInterfaces.hasMoreElements()) {
				ni = (NetworkInterface) netInterfaces.nextElement();
				// ----------特定情况，可以考虑用ni.getName判断
				// 遍历所有ip
				Enumeration<InetAddress> ips = ni.getInetAddresses();
				while (ips.hasMoreElements()) {
					ip = (InetAddress) ips.nextElement();
					if (!ip.isLoopbackAddress() // 非127.0.0.1
							&& ip.getHostAddress().matches("(\\d{1,3}\\.){3}\\d{1,3}")) {
						macList.add(getMacFromBytes(ni.getHardwareAddress()));
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return macList;
	}

	private static String getMacFromBytes(byte[] bytes) {
		StringBuffer mac = new StringBuffer();
		byte currentByte;
		boolean first = false;
		for (byte b : bytes) {
			if (first) {
				mac.append("-");
			}
			currentByte = (byte) ((b & 240) >> 4);
			mac.append(Integer.toHexString(currentByte));
			currentByte = (byte) (b & 15);
			mac.append(Integer.toHexString(currentByte));
			first = true;
		}
		return mac.toString().toUpperCase();
	}
	
	//读取 eth0地址
	/**
	 * 此方法描述的是：获得服务器的IP地址
	 * 
	 * @author: 
	 * @version: 2014年9月5日 下午4:57:15
	 */
	public static String getLocalIPEth0() {
		String sIP = "";
		try {
			if(!isWindowsOS()){
				Enumeration<NetworkInterface> netInterfaces = (Enumeration<NetworkInterface>) NetworkInterface.getNetworkInterfaces();
				while (netInterfaces.hasMoreElements()) {
					NetworkInterface ni = (NetworkInterface) netInterfaces.nextElement();
					if(!ni.getName().equals("eth0")){
						continue;
					}else{
						Enumeration<InetAddress> ips = ni.getInetAddresses();
						while (ips.hasMoreElements()) {
							InetAddress inetAddress = (InetAddress) ips.nextElement();
							if(inetAddress instanceof Inet6Address){
								continue;
							}else{
								sIP = inetAddress.getHostAddress().toString();
							}
						}
						break;
					}
				}
			}else{
				sIP = InetAddress.getLocalHost().getHostAddress().toString();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sIP;
	}
	
	public static boolean isWindowsOS(){
		boolean isWindoesOS = false;
		String osName = System.getProperty("os.name");
		if(osName.toLowerCase().indexOf("windows")>-1){
			isWindoesOS = true;
		}
		return isWindoesOS;
	}
}
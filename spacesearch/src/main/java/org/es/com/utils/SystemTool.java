package org.es.com.utils;

import com.sun.org.apache.xpath.internal.operations.Neg;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * class: SystemTool
 * description: 
 * autour: Aaron Wang
 * date: 2017/11/20 10:32 
 * update: 2017/11/20
 * version: 1.0
 */
public class SystemTool {


    /**
     * method: getLocalIp()
     * description: 获取服务器的IP地址
     * date: 2017/11/20 10:34
     * param:
     */
    private static String getLocalIp(){
        String sIp = "" ;
        InetAddress ip = null ;
        try{
            boolean bFindIp = false ;
            Enumeration<NetworkInterface> netInterfaces = (Enumeration<NetworkInterface>) NetworkInterface.getNetworkInterfaces() ;
            while (netInterfaces.hasMoreElements()){
                if (bFindIp){
                    break;
                }
                NetworkInterface ni = (NetworkInterface) netInterfaces.nextElement() ;
                Enumeration<InetAddress> ips = ni.getInetAddresses() ;
                while (ips.hasMoreElements()){
                    ip = (InetAddress) ips.nextElement() ;
                    if (!ip.isLoopbackAddress()&&ip.getHostAddress().matches("(\\d{1,3}\\.){3}\\d{1,3}")){
                        bFindIp = true ;
                        break;
                    }
                }
            }
        }catch (Exception  e){
            e.printStackTrace();
        }
        if (null!=ip){
            sIp = ip.getHostAddress() ;
        }
        return sIp ;
    }
    /**
     * method: getLocalIPS()
     * description: 获取服务器的IP地址（多网卡）
     * date: 2017/11/20 10:38
     * param:
     */
    public static List<String> getLocalIPS(){
        InetAddress ip = null ;
        List<String> ipList = new ArrayList<String>() ;
        try{
            Enumeration<NetworkInterface> netInterfaces = (Enumeration<NetworkInterface>) NetworkInterface.getNetworkInterfaces() ;
            while (netInterfaces.hasMoreElements()){
                NetworkInterface ni = (NetworkInterface) netInterfaces.nextElement() ;
                Enumeration<InetAddress> ips = ni.getInetAddresses() ;
                while (ips.hasMoreElements()){
                    ip = (InetAddress) ips.nextElement() ;
                    if (!ip.isLoopbackAddress()
                            &&ip.getHostAddress().matches("(\\d{1,3}\\.){3}\\d{1,3}")) {
                        ipList.add(ip.getHostAddress()) ;
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return ipList ;
    }
    /**
     * method: getMacId()
     * description: 获取服务器的MAC地址
     * date: 2017/11/20 10:43
     * param:
     */
    public static String getMacId(){
        String macId="" ;
        InetAddress ip = null ;
        NetworkInterface ni = null ;
        try{
           boolean bFindIp = false ;
           Enumeration<NetworkInterface> netInterfaces = (Enumeration<NetworkInterface>) NetworkInterface.getNetworkInterfaces() ;
           while (netInterfaces.hasMoreElements()){
               if (bFindIp){
                   break;
               }
               ni = (NetworkInterface) netInterfaces.nextElement() ;
               //遍历所有的IP
               Enumeration<InetAddress> ips = ni.getInetAddresses() ;
               while (ips.hasMoreElements()){
                   ip = (InetAddress) ips.nextElement() ;
                   if (!ip.isLoopbackAddress()
                           &&ip.getHostAddress().matches("(\\d{1,3}\\.){3}\\d{1,3}")){
                       bFindIp = true ;
                       break;
                   }
               }
           }
        }catch (Exception e){
            e.printStackTrace();
        }
        if (null!=ip){
            try {
                macId = getMacFromBytes(ni.getHardwareAddress()) ;
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return macId ;
    }
    /**
     * method: getMacIds()
     * description: 获取服务器的MAC地址（多网卡）
     * date: 2017/11/20 10:57
     * param:
     */
    public static List<String> getMacIds(){
        InetAddress ip = null ;
        NetworkInterface ni = null ;
        List<String> macList = new ArrayList<String>() ;
        try{
            Enumeration<NetworkInterface> netInterfaces = (Enumeration<NetworkInterface>) NetworkInterface.getNetworkInterfaces() ;
            while (netInterfaces.hasMoreElements()){
                ni = (NetworkInterface) netInterfaces.nextElement() ;
                //遍历所有的IP
                Enumeration<InetAddress> ips = ni.getInetAddresses() ;
                while (ips.hasMoreElements()){
                    ip = (InetAddress) ips.nextElement() ;
                    if (!ip.isLoopbackAddress()
                            &&ip.getHostAddress().matches("(\\d{1,3}\\.){3}\\d{1,3}")){
                        macList.add(getMacFromBytes(ni.getHardwareAddress())) ;
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return macList ;
    }

    /**
     * method: getLocalIPEth0()
     * description: 获取服务器的IP地址
     * date: 2017/11/20 11:04
     * param:
     */
    public static String getLocalIPEth0(){
        String sip = "" ;
        try {
            if (!isWindowsOS()){
                Enumeration<NetworkInterface> netInterfaces = (Enumeration<NetworkInterface>) NetworkInterface.getNetworkInterfaces() ;
                while (netInterfaces.hasMoreElements()){
                    NetworkInterface ni = (NetworkInterface) netInterfaces.nextElement() ;
                    if (!ni.getName().equals("eth0")){
                        continue;
                    }else {
                        Enumeration<InetAddress> ips = ni.getInetAddresses() ;
                        while (ips.hasMoreElements()){
                            InetAddress inetAddress = (InetAddress) ips.nextElement() ;
                            if (inetAddress instanceof InetAddress){
                                continue;
                            }else {
                                sip = inetAddress.getHostAddress().toString() ;
                            }
                        }
                        break;
                    }
                }
            }else{
                sip = InetAddress.getLocalHost().getHostAddress().toString() ;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return sip ;
    }

    public static String getMacFromBytes(byte[] bytes){
        StringBuffer mac = new StringBuffer() ;
        byte currentByte ;
        boolean first = false ;
        for (byte b:bytes){
            if (first){
                mac.append("-") ;
            }
            currentByte = (byte)((b & 240)>>4) ;
            mac.append(Integer.toHexString(currentByte)) ;
            currentByte = (byte)(b & 15) ;
            mac.append(Integer.toHexString(currentByte)) ;
            first = true ;
        }
        return mac.toString().toUpperCase() ;
    }
    public static boolean isWindowsOS(){
        boolean iswindowsOS = false ;
        String osName = System.getProperty("os.name") ;
        if (osName.toLowerCase().indexOf("windows")>-1){
            iswindowsOS = true ;
        }
        return iswindowsOS ;
    }
}

package org.common.com.utils;

import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class PostEsbUtil {

    public static String post(String strUrl,String params){
        try{
            URL url = new URL(strUrl) ;
            HttpURLConnection connection = (HttpURLConnection) url.openConnection() ;
            connection.setDoOutput(true);
            connection.setConnectTimeout(15000);
            connection.setDoInput(true);
            connection.setUseCaches(false);
            connection.setInstanceFollowRedirects(true);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Accept","application/json");
            connection.setRequestProperty("Content-Type","application/json");
            connection.connect();
            OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream(),"utf-8") ;
            out.append(params) ;
            out.flush();
            out.close();
            //读取响应
            int length = (int)connection.getContentLength() ;//获取长度
            InputStream is = connection.getInputStream() ;
            if (length!=-1){
                byte[] data = new byte[length] ;
                ;byte[] temp = new byte[512] ;
                int readLen = 0 ;
                int destPos = 0 ;
                while ((readLen=is.read(temp))>0){
                    System.arraycopy(temp,0,data,destPos,readLen);
                    destPos+=readLen ;
                }
                String result = new String(data,"UTF-8") ;
                return result ;
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return "error" ;
    }
}

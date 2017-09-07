package org.common.com.utils;

public class ESBCoderOper {
    public static int checkCode(String returnCode){
        try{
            String indexStr = returnCode.substring(0,1) ;
            if (indexStr.equals("2")){
                return 1;//成功
            }
            else if (indexStr.equals("5")){
                return 2;//异常
            }
            else if (indexStr.equals("6")){
                return 0 ;//调用失败
            }else{
                return 2 ;//调用失败
            }
        }catch (Exception e){
            return 0 ;//调用失败
        }
    }
}

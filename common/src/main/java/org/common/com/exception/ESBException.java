package org.common.com.exception;

import org.common.com.utils.EsbCode;

public class ESBException extends RuntimeException {

    public ESBException(EsbCode esbCode,String errorCode,String errMsg){
        super(getMsg(esbCode,errorCode,errMsg));
    }
    public ESBException(EsbCode esbCode,String errorCode){
        super(getMsg(esbCode,errorCode,""));
    }
    private static String getMsg(EsbCode esbCode,String errorCode,String errMsg){
        String code = "" ;
        String msg = "" ;
        if (esbCode==null){
            esbCode = getNullEsbCode() ;
        }
        code = "2"+esbCode.getSysCode()+errorCode ;
        msg = getErrMsg(esbCode,errorCode,errMsg) ;
        return code+"@"+msg ;

    }
    private static String getErrMsg(EsbCode esbCode,String errorCode,String errMsg){
        String  res = "【"+esbCode.getSysName()+"】" ;
        res+="【"+esbCode.getServiceCode()+"】:" ;
        if (errorCode.equals("01")){
            res+="访问超时" ;
        }else if (errorCode.equals("02")){
            res+="未找到esb服务";//60000
        }else if (errorCode.equals("03")){
            res+="ESB请求异常-"+errMsg ;//50000
        }else if (errorCode.equals("04")){
            res+="ESB-json格式错误" ;//
        }else {
            res+="ESB异常" ;
        }

        return res ;

    }

    private static EsbCode getNullEsbCode(){
        EsbCode esbCode = new EsbCode() ;
        esbCode.setServiceCode("");
        esbCode.setServiceName("");
        esbCode.setSysCode("00");
        esbCode.setSysName("");
        return esbCode ;
    }
}

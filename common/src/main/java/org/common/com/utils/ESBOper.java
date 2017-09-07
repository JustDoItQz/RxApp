package org.common.com.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.common.com.constant.SystemConstant;
import org.common.com.exception.ESBException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class ESBOper {

    private static Logger logger = LoggerFactory.getLogger(ESBOper.class) ;

    private final static int DEFAULT_SUCCESS_CODE=2000000 ;
    private final static int DEFAULT_ERROR_CODE = 5000000 ;
    private final static String RETURNMSG_SUCCESS = "success" ;
    private final static String RETURNMSG_ERROR = "error" ;
    private final static String EXP_CODE = "5000000" ;
    private final static String EXP_MSG = "系统异常" ;



    private static <T> RequetESB<T> setRequest(String serviceCode,String reqSysCode,T body){
        RequetESB<T> requetESB = new RequetESB<T>() ;
        RequestHeader header = new RequestHeader() ;
        header.setServiceCode(serviceCode);

        requetESB.setHeader(header);
        requetESB.setBody(body);
        return requetESB ;
    }
    public static String beanToJson(Object obj){
        JSONObject json = JSONObject.fromObject(obj) ;
        return json.toString() ;
    }
    public static <T> T fromJson(String json, TypeToken<T> token){
        if (StringUtils.isBlank(json)){
            return null ;
        }
        GsonBuilder builder = new GsonBuilder() ;
        Gson gson = builder.create() ;
        try{
            return (T)gson.fromJson(json,token.getType()) ;
        }catch (Exception e){
            e.printStackTrace();
            return null ;
        }
    }
    public static JSON_TYPE getJSONType(String str){
        if (StringUtils.isBlank(str)){
            return JSON_TYPE.JSON_TYPE_ERROR ;
        }
        final char [] strChar = str.substring(0,1).toCharArray() ;
        final char firstChar = strChar[0] ;

        if (firstChar=='{'){
            return JSON_TYPE.JSON_TYPE_OBJECT ;
        }else if(firstChar=='['){
            return JSON_TYPE.JSON_TYPE_ARRAY;
        }else{
            return JSON_TYPE.JSON_TYPE_ERROR ;
        }
    }
    public static JSONObject toJson(String data){
        JSONObject json = JSONObject.fromObject(data) ;
        return json ;
    }
    private static <T> ResponseESB setResponse(String serviceCode, String reqSyscode, int returnCode, String serialNumber, String returnMessage,
                                               HashMap<String,Object> exceptionInfo, T body){

        ResponseESB<T> responseESB = new ResponseESB<T>() ;
        ResponseHeader header = new ResponseHeader() ;
        header.setReqSysCode(reqSyscode);
        header.setServiceCode(serviceCode);
        header.setExceptionInfo(exceptionInfo);

        header.setReturnCode(returnCode);
        header.setSerialNumber(serialNumber);
        header.setReturnMessage(returnMessage);

        responseESB.setBody(body);
        responseESB.setHeader(header);

        return responseESB ;
    }
    private static <T> String returnResponseString(String serviceCode,String reqSysCode,int returnCode,String serialNumber,String returnMessage,
                                                   HashMap<String,Object> exceptionInfo,T body){
        ResponseESB<T> responseESB = setResponse(serviceCode,reqSysCode,returnCode,serialNumber,returnMessage,exceptionInfo,body) ;
        String res = beanToJson(responseESB) ;

        return res ;
    }
    private static <T> String returnResponseString(String serviceCode,String reqSysCode,int returnCode,String returnMessage,HashMap<String,Object> exceptionInfo,T body){
        return returnResponseString(serviceCode,reqSysCode,returnCode,"",returnMessage,exceptionInfo,body) ;
    }
    //成功返回Response
    public static <T> String returnResponseSuccess(String serviceCode,String reqSysCode,T body){
        return returnResponseString(serviceCode,reqSysCode,DEFAULT_SUCCESS_CODE,RETURNMSG_SUCCESS,null,body) ;
    }
    //成功返回Response
    public static <T> String returnResponseSuccess(String serviceCode,T body){
        String reqSysCode = SystemConstant.getESB_ReqSysCode() ;//SystemConstant.getESB_ReqSysCode
        return returnResponseString(serviceCode,reqSysCode,DEFAULT_SUCCESS_CODE,RETURNMSG_SUCCESS,null,body) ;
    }
    private static <T> String returnResponseSuccess(T body){
        String reqSysCode = SystemConstant.getESB_ReqSysCode() ;//改成SystemConstant.getESB_ReqSysCode
        return returnResponseString("",reqSysCode,DEFAULT_SUCCESS_CODE,RETURNMSG_SUCCESS,null,body) ;
    }
    private static HashMap<String,Object> getExceptionMap(String errorMsg,String errorCode){
        HashMap<String,Object> map = new HashMap<String, Object>() ;
        map.put("errMsg",errorMsg) ;
        map.put("errCode",errorCode) ;
        return map ;
    }
    private static String returnResponseErr(String serviceCode,String errMsg,String errCode){
        String reqSysCode = SystemConstant.getESB_ReqSysCode() ;//改成SystemConstant.getESB_ReqSysCode
        HashMap<String,Object>  map_exp = getExceptionMap(errMsg,errCode) ;
        return returnResponseString(serviceCode,reqSysCode,DEFAULT_ERROR_CODE,RETURNMSG_ERROR,map_exp,null) ;
    }
    public static String returnResponseErr(String serviceCode,String reqSysCode,String errMsg,String errCode){
        HashMap<String,Object>  map_exp = getExceptionMap(errMsg,errCode) ;
        return returnResponseString(serviceCode,reqSysCode,DEFAULT_ERROR_CODE,RETURNMSG_ERROR,map_exp,null) ;
    }
    public static String returnResponseErr(String serviceCode,String errMsg){
        String reqSysCode = SystemConstant.getESB_ReqSysCode() ;////改成SystemConstant.getESB_ReqSysCode
        String errCode = EXP_CODE ;
        HashMap<String,Object> map_exp = getExceptionMap(errMsg,errCode) ;
        return returnResponseString(serviceCode,reqSysCode,DEFAULT_ERROR_CODE,RETURNMSG_ERROR,map_exp,null) ;
    }
    public static String returnResponseErr(String serviceCode){
        String reqSysCode = SystemConstant.getESB_ReqSysCode() ;////改成SystemConstant.getESB_ReqSysCode
        String errCode = EXP_CODE ;
        String errMsg = EXP_MSG ;
        HashMap<String,Object> map_exp = getExceptionMap(errMsg,errCode) ;
        return returnResponseString(serviceCode,reqSysCode,DEFAULT_ERROR_CODE,RETURNMSG_ERROR,map_exp,null) ;
    }
    public static String returnResponseErrMsg(String errMsgInfo){
        String reqSysCode = SystemConstant.getESB_ReqSysCode() ;////改成SystemConstant.getESB_ReqSysCode
        String errCode = EXP_CODE ;
        String errMsg = errMsgInfo ;
        String serviceCode = null ;
        HashMap<String,Object> map_exp = getExceptionMap(errMsg,errCode)  ;
        return returnResponseString(serviceCode,reqSysCode,DEFAULT_ERROR_CODE,RETURNMSG_ERROR,map_exp,null) ;
    }
    public static Object parserToObj(JSONObject json,Class<?> clazz){
        Object object = new Object() ;
        try{
            HashMap<String,Class> map = BeanOper.getBeanListClass(clazz) ;
            object = JSONObject.toBean(json,clazz,map) ;
            return object ;

        }catch (Exception e){
            return null ;
        }
    }
    public static ResponseHeader getResponseHeader(String response){
        JSONObject json = toJson(response) ;
        JSONObject json_header = json.getJSONObject("header") ;
        ResponseHeader header = (ResponseHeader) parserToObj(json_header,ResponseHeader.class) ;

        return header ;
    }
    public static <T> RequetESB<T> getRequest(String request,TypeToken<T> typeToken){
        logger.info("=============esb请求参数=========");
        logger.info(request);
        logger.info("=============esb请求参数end===========");

        RequetESB<T> requestT =  new RequetESB<T>() ;
        JSONObject json = toJson(request) ;
        String str_header = "" ;

        try{
            str_header = json.getString("header") ;
        }catch (Exception e){
            str_header="{}" ;
        }

        JSON_TYPE strType = getJSONType(str_header) ;
        switch (strType){
            case JSON_TYPE_ARRAY:
                JSONArray jarr = new JSONArray().fromObject(str_header) ;
                if (jarr.size()>0){
                    str_header = jarr.get(0).toString() ;
                }else {
                    str_header="{}" ;
                }
                break;
            case JSON_TYPE_OBJECT:
                break;
            case JSON_TYPE_ERROR:
                str_header="{}" ;
                break;
                default:
                    str_header="{}" ;
                    break;
        }
        String json_body = json.getString("body") ;
        TypeToken<RequestHeader> typeToken_header = new TypeToken<RequestHeader>(){} ;
        RequestHeader header = fromJson(str_header,typeToken_header) ;
        requestT.setHeader(header);
        T body = fromJson(json_body,typeToken) ;
        requestT.setBody(body);
        return requestT ;

    }

    public static <T> RequetESB<T> getRequest2(HttpServletRequest request,TypeToken<T> typeToken){
        RequetESB<T> requesT = new RequetESB<T>() ;
        String str_data = "" ;
        try{
            str_data = request.getParameter("data") ;
            requesT = getRequest(str_data,typeToken) ;
        }catch (Exception e){
            str_data="{}" ;
        }
        return requesT ;
    }
    public static <T> ResponseESB<T> getResponseESB3(String request,TypeToken<T> typeToken){
        ResponseESB<T> requestT = new ResponseESB<T>() ;
        JSONObject json = toJson(request) ;
        String str_header = json.getString("header") ;
        JSON_TYPE strType = getJSONType(str_header) ;
        switch (strType){
            case JSON_TYPE_ARRAY:
                JSONArray jarr = new JSONArray().fromObject(str_header) ;
                if (jarr.size()>0){
                    str_header = jarr.get(0).toString() ;
                }else {
                    str_header = "{}" ;
                }
            case JSON_TYPE_OBJECT:
                str_header = "{}"  ;
                break;
            case JSON_TYPE_ERROR:
                str_header = "{}" ;
                break;
                default:
                    str_header = "{}" ;
                    break;
        }
        String json_body = json.getString("body") ;
        JSON_TYPE bodyType = getJSONType(json_body) ;
        switch (bodyType){
            case JSON_TYPE_OBJECT:
                JSONObject Jbody = JSONObject.fromObject(json_body) ;
                if (Jbody.containsKey("data")){
                    json_body = Jbody.getString("data") ;
                    if (Jbody.containsKey("records")){
                        Jbody = JSONObject.fromObject(json_body) ;
                        json_body = Jbody.getString("records") ;
                    }
                }
                break;
                default:
                    break;
        }
        TypeToken<ResponseHeader> typeToken_header = new TypeToken<ResponseHeader>(){} ;
        ResponseHeader header = fromJson(str_header,typeToken_header) ;
        requestT.setHeader(header);
        T body = fromJson(json_body,typeToken) ;
        requestT.setBody(body);

        return requestT ;

    }

    public static <T> ResponseESB<T> getResponseESB(String request,TypeToken<T> typeToken){
        ResponseESB<T> requestT = new ResponseESB<T>() ;
        JSONObject json = toJson(request) ;
        String str_header = json.getString("header") ;
        JSON_TYPE strType = getJSONType(str_header) ;
        switch (strType){
            case JSON_TYPE_ARRAY:
                JSONArray jarr = new JSONArray().fromObject(str_header) ;
                if (jarr.size()>0){
                    str_header = jarr.get(0).toString() ;
                }else{
                    str_header = "{}" ;
                }
                break;
            case JSON_TYPE_OBJECT:
                str_header = "{}" ;
                break;
            case JSON_TYPE_ERROR:
                str_header = "{}" ;
                break;
                default:
                    str_header = "{}" ;
                    break;
        }
        String json_body = json.getString("body") ;
        JSON_TYPE bodyType = getJSONType(json_body) ;
        switch (bodyType){
            case JSON_TYPE_OBJECT:
                JSONObject Jbody = JSONObject.fromObject(json_body) ;
                if (Jbody.containsKey("data")){
                    json_body = Jbody.getString("data") ;
                }
                break;
                default:
                    break;
        }

        TypeToken<ResponseHeader> typeToken_header = new TypeToken<ResponseHeader>(){} ;
        ResponseHeader header = fromJson(str_header,typeToken_header) ;
        requestT.setHeader(header);
        T body = fromJson(json_body,typeToken) ;
        requestT.setBody(body);

        return requestT ;
    }

    public static <T> ResponseESB<T> getResponseESB2(String request,TypeToken<T> typeToken){
        ResponseESB<T> requestT = new ResponseESB<T>() ;
        JSONObject json = toJson(request) ;
        String str_header = json.getString("header") ;
        JSON_TYPE strType = getJSONType(str_header) ;
        switch (strType){
            case JSON_TYPE_ARRAY:
                JSONArray jarr = new JSONArray().fromObject(str_header) ;
                if (jarr.size()>0){
                    str_header = jarr.get(0).toString() ;
                }else {
                    str_header = "{}" ;
                }
                break;
            case JSON_TYPE_OBJECT:
                break;
            case JSON_TYPE_ERROR:
                str_header = "{}" ;
                break;
                default:
                    break;

        }
        String json_body = json.getString("body") ;
        TypeToken<ResponseHeader> typeToken_header = new TypeToken<ResponseHeader>(){} ;
        ResponseHeader header = fromJson(str_header,typeToken_header) ;
        requestT.setHeader(header);
        T body = fromJson(json_body,typeToken) ;
        requestT.setBody(body);

        return requestT ;
    }

    public static ESBCheck esbIsSuccess(ResponseHeader header){
        ESBCheck esbCheck = new ESBCheck() ;
        try{
            int checkRes = ESBCoderOper.checkCode(String.valueOf(header.getReturnCode())) ;
            if (checkRes==1){
                esbCheck.setSuccess(true);
            }else if (checkRes==0){
                esbCheck.setSuccess(false);
                esbCheck.setReturnCode(60000);
                esbCheck.setMsg("esb接口未注册");
            }
            else if (checkRes==2){
                esbCheck.setSuccess(false);
                esbCheck.setReturnCode(header.getReturnCode());
                esbCheck.setMsg("esb返回异常");
            }else {
                esbCheck.setSuccess(false);
                esbCheck.setReturnCode(header.getReturnCode());
                esbCheck.setMsg("esb返回异常");
            }
        }catch (Exception e){
            esbCheck.setSuccess(false);
            esbCheck.setReturnCode(10001);
            esbCheck.setMsg("系统异常");
        }
        return esbCheck ;
    }
    private static EsbCode getEsbCode(String serviceCode){
        EsbCode code = new EsbCode() ;
        code.setServiceCode(serviceCode);
        code.setServiceName("*");
        code.setSysName("*");
        return code ;
    }
    private static void throwException(String serviceCode,String res){
        EsbCode esbCode = getEsbCode(serviceCode) ;
        if (res.equals("error")){
            throw new ESBException(esbCode,"01") ;//访问超时
        }else{
            JSONObject json = null ;
            String returnCode = null ;
            try{
                json = JSONObject.fromObject(res) ;
                returnCode = json.getJSONObject("header").getString("returnCode").trim() ;
            }catch (Exception e){
                throw new ESBException(esbCode,"04");//json格式错误
            }
            int checkCode = ESBCoderOper.checkCode(returnCode) ;
            if (checkCode!=1){
                if (checkCode==2){
                    String returnMsg = json.getJSONObject("header").getString("returnMessage").trim() ;
                    throw new ESBException(esbCode,"03",returnMsg);//ESB服务业务异常
                }else if (checkCode==0){
                    throw new ESBException(esbCode,"02");//未找到ESB服务
                }else {
                    throw new ESBException(esbCode,"00");//未知异常
                }
            }

        }

    }

    //调用ESB  serviceCode 接口编码
    public static <T> String callESB(String serviceCode,String reqSysCode,T body){
        Map<String,String> logMap = new HashMap<String, String>() ;
        RequetESB<T> requetESB = setRequest(serviceCode,reqSysCode,body) ;
        String para = beanToJson(requetESB) ;
        logMap.put("ESB请求数据",para) ;
        String url = SystemConstant.getESB_URL() ;
        String res = PostEsbUtil.post(url,para) ;
        logMap.put("ESB返回数据",res) ;
        logger.info("ESB请求结果：{}",logMap);
        throwException(serviceCode,res);
        return res ;
    }
    public static <T> String callEsb(String serviceCode,T body){
        String reqSysCode = SystemConstant.getESB_ReqSysCode() ;
        return callESB(serviceCode,reqSysCode,body) ;
    }


}

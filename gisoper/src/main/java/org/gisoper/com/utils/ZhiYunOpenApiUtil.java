package org.gisoper.com.utils;

import cn.jiguang.common.utils.StringUtils;
import com.ctfo.dexs.service.DataExchangeService;
import net.sf.json.JSONObject;
import org.common.com.constant.ConstantUtils;
import org.common.com.constant.SystemConstant;
import org.common.com.redis.RedisOper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class ZhiYunOpenApiUtil {

    private static Logger logger = LoggerFactory.getLogger(ZhiYunOpenApiUtil.class) ;

    public static JSONObject dataExchangeService(String url,String param,String type,boolean islogin) throws Exception{
        return dataExchangeService(url,param,type,islogin) ;
    }
    public static JSONObject dataExchangeService(String url,String param,String type,boolean islogin,boolean hascontinue) throws Exception{
        String urlu = url ;
        String paramu = param ;
        JSONObject json = null ;
        //开关控制
        boolean hasswitch = false ;
        String switchbool = RedisOper.get("switch_controller",String.class) ;
        if (StringUtils.isEmpty(switchbool)){
            hasswitch=true ;
        }else{
            hasswitch = Boolean.valueOf(switchbool) ;
        }
        if (hasswitch){
            if (!islogin){
                param = "token="+findUserToken(type)+param ;
            }
            param = "TransCode.encode(param)" ;
            url = url+param+"?client_id="+getZhiYunOpenApiClientId(type) ;
            DataExchangeService des = new DataExchangeService(5000,5000) ;
            String res = des.accessHttps(url,"POST");
            res = "TransCode.decode(res)" ;
            json = JSONObject.fromObject(res) ;
            if (json!=null){
                String status = json.getString("status") ;
                if ("fail".equals(status)){
                    login(type);
                    json = dataExchangeService(urlu,paramu,type,false,false) ;
                }
            }
        }
        return json ;
    }
    public static String getZhiYunOpenApiClientId(String type){
        String zhiYunOpenApiClientId = "" ;
        if ("1".equals(type)){
            zhiYunOpenApiClientId = SystemConstant.getZhiYunOpenApiClientId_1() ;
        }else if ("2".equals(type)){
            zhiYunOpenApiClientId = SystemConstant.getZhiYunOpenApiClientId_2() ;
        }else if ("3".equals(type)){
            zhiYunOpenApiClientId = SystemConstant.getZhiYunOpenApiClientId_3() ;
        }
        return zhiYunOpenApiClientId ;
    }

    public static String findUserToken(String type){
        String usertoken = "" ;
        if ("1".equals(type)){
            usertoken = RedisOper.get("ZHIYUNOPENAPI_USER_TOKEN_1") ;
        }else if ("2".equals(type)){
            usertoken = RedisOper.get("ZHIYUNOPENAPI_USER_TOKEN_2") ;
        }else if ("3".equals(type)){
            usertoken = RedisOper.get("ZHIYUNOPENAPI_USER_TOKEN_3") ;
        }
        return usertoken ;
    }
    public static String login(String type){
        Map<String,String> logMap = new HashMap<String, String>() ;
        String user_token = "" ;
        String p="" ;
        try{
            if (ConstantUtils.ZHIYUNOPENAPI_USER_TOKEN_1.equals(type)){
                p="user="+SystemConstant.getZhiYunOpenApi_User_1()+"&pwd="+SystemConstant.getZhiYunOpenApi_Pwd_1() ;
            }else if (ConstantUtils.ZHIYUNOPENAPI_USER_TOKEN_2.equals(type)){
                p="user="+SystemConstant.getZhiYunOpenApi_User_2()+"&pwd="+SystemConstant.getZhiYunOpenApi_Pwd_2() ;
            }else if (ConstantUtils.ZHIYUNOPENAPI_USER_TOKEN_3.equals(type)){
                p="user="+SystemConstant.getZhiYunOpenApi_User_3()+"&pwd="+SystemConstant.getZhiYunOpenApi_Pwd_3() ;
            }
            String url = SystemConstant.getZhiYunOpenApi_Url()+"/login" ;
            JSONObject jsonObject = dataExchangeServiceLogin(url,p,type) ;
            if (jsonObject!=null){
                int status = jsonObject.getInt("status") ;
                if (ConstantUtils.ZHIYUNOPENAPI_SUCCESS_TYPE==status){
                    user_token = jsonObject.getString("result") ;
                    if (SystemConstant.getZhiYunOpenApi_User_1().equals(type)){
                        RedisOper.save(ConstantUtils.ZHIYUNOPENAPI_USER_TOKEN_1,user_token);
                    }else if (SystemConstant.getZhiYunOpenApi_User_2().equals(type)){
                        RedisOper.save(ConstantUtils.ZHIYUNOPENAPI_USER_TOKEN_2,user_token);
                    }else if (SystemConstant.getZhiYunOpenApi_User_3().equals(type)){
                        RedisOper.save(ConstantUtils.ZHIYUNOPENAPI_USER_TOKEN_3,user_token);
                    }
                }else {
                    if (SystemConstant.getZhiYunOpenApi_User_1().equals(type)){
                        RedisOper.save(ConstantUtils.ZHIYUNOPENAPI_USER_TOKEN_1,"");
                    }else if (SystemConstant.getZhiYunOpenApi_User_2().equals(type)){
                        RedisOper.save(ConstantUtils.ZHIYUNOPENAPI_USER_TOKEN_2,"");
                    }else if (SystemConstant.getZhiYunOpenApi_User_3().equals(type)){
                        RedisOper.save(ConstantUtils.ZHIYUNOPENAPI_USER_TOKEN_3,"");
                    }
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return user_token ;
    }
    public static JSONObject dataExchangeServiceLogin(String url,String param,String type) throws Exception {
        JSONObject json = null ;
        //开关控制
        boolean hasswitch = false ;
        String switchbool = RedisOper.get("switch_controller",String.class) ;
        if (StringUtils.isEmpty(switchbool)){
            hasswitch=true ;
        }else{
            hasswitch = Boolean.valueOf(switchbool) ;
        }
        if (hasswitch){
            param = "TransCode.encode(param)" ;
            url = url+param+"?client_id="+getZhiYunOpenApiClientId(type) ;
            DataExchangeService des = new DataExchangeService(5000,5000);
            String res = des.accessHttps(url,"POST") ;
            res = "TransCode.decode(res)" ;
            json = JSONObject.fromObject(res) ;
        }
        return json ;
    }

}

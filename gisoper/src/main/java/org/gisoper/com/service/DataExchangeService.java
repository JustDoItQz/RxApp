package org.gisoper.com.service;

import org.apache.commons.lang.StringUtils;
import org.common.com.constant.ConstantUtils;
import org.common.com.dao.MyBatisDao;
import org.common.com.redis.RedisOper;
import org.common.com.utils.HttpclientUtil;
import org.gisoper.com.vo.TSubsysLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataExchangeService {

    @Autowired
    private MyBatisDao myBatisDao ;


    public String postPartnerApiService(String url,String param) throws Exception{
        String result = "" ;
        //开关控制
        boolean hasswitch = false ;
        String switchbool = RedisOper.get(ConstantUtils.PARTNERAPISWITCH,String.class) ;
        if (StringUtils.isBlank(switchbool)){
            hasswitch=true ;
        }else {
            hasswitch=Boolean.valueOf(switchbool) ;
        }
        if (hasswitch){
            result = HttpclientUtil.postJson(url,param) ;
        }
        //调用记录存入数据库

        TSubsysLog tSubsysLog = new TSubsysLog() ;
        myBatisDao.save("",tSubsysLog);

        return result ;
    }

}

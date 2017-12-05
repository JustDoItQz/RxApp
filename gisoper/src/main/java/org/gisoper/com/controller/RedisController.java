package org.gisoper.com.controller;

import net.sf.json.JSONObject;
import org.common.com.constant.ConstantUtils;
import org.common.com.redis.RedisOper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/redis")
public class RedisController {

    public static Logger logger = LoggerFactory.getLogger(RedisController.class) ;

    @ResponseBody
    @RequestMapping("/saveTimeDistance")
    public String saveTimeDistance(HttpServletRequest request, HttpServletResponse response){
        Map<String,Object> map = new HashMap<String, Object>() ;
        HttpHeaders headers = new HttpHeaders() ;
        headers.set("Content-Type","application/json;charset=utf-8");
        try{
            String timeDistance = request.getParameter("timedistance").trim() ;
            int time = Integer.parseInt(timeDistance) ;
            RedisOper.save(ConstantUtils.TIME_DISTANCES,time);
            map.put("success","true") ;
            map.put("msg","执行成功,找车时间设置为"+time) ;
        }catch (Exception e){
            e.printStackTrace();
            logger.error("保存市内配改时间内车辆失败：{}，{}",e,map);
        }
        String result = JSONObject.fromObject(map).toString() ;
        return result ;
    }

    @ResponseBody
    @RequestMapping("/searchRedisInitData")
    public String searchRedisInitData(@RequestBody(required = false)String request){
        HashMap<String,Object> resultMap = new HashMap<String, Object>() ;
        try{
            //市内配 获取该时间内的车
            if (RedisOper.get(ConstantUtils.TIME_DISTANCES)!=null){
                int distanceTime = RedisOper.get(ConstantUtils.TIME_DISTANCES,Integer.class) ;
                if (distanceTime==0){
                    resultMap.put("distancetime",0) ;
                }else{
                    resultMap.put("distancetime",distanceTime) ;
                }
            }else {
                resultMap.put("distancetime",0) ;
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        String result = JSONObject.fromObject(resultMap).toString() ;
        return result ;
    }
}

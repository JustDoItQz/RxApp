package org.gisoper.com.controller;

import net.sf.json.JSONObject;
import org.common.com.redis.RedisOper;
import org.gisoper.com.service.GisOpertService;
import org.gisoper.com.vo.BasLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by on 2017/7/4.
 * Author Aaron.Wang
 */
@Controller
@RequestMapping("/gisoper")
public class GisOpertController {

    private static Logger logger = LoggerFactory.getLogger(GisOpertController.class) ;

    @Autowired
    private GisOpertService gisOpertService ;
    @Autowired
    private RabbitTemplate rabbitTemplate ;

    /**
     *  初始化省市区数据
     * @param
     * @return
     */
    @RequestMapping(value = "/initBaseLocalPCDCode.do",method = RequestMethod.GET)
    public String initBaseLocalPCDCode(){

        JSONObject result = new JSONObject() ;
        try {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        gisOpertService.initBaseLocalCode();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
            logger.info("初始化省市区数据成功！");
            result.put("success",true) ;
            result.put("msg","初始化省市区成功！") ;

        }catch (Exception e){
            e.printStackTrace();
            result.put("success",false) ;
            result.put("msg","初始化省市区失败！"+e.getMessage()) ;
            logger.error("初始化省市区数据失败！");
        }

        return JSONObject.fromObject(result).toString() ;
    }

    /**
     *  初始化街道数据到数据库
     * @param
     * @return
     */
    @RequestMapping(value = "/initBasLocalAreaCode.do",method = RequestMethod.GET)
    public String initBasLocalAreaCode(){
        JSONObject result = new JSONObject() ;
        try {

            new Thread(new Runnable() {
                @Override
                public void run() {
                    gisOpertService.insertLocalAreaCode();

                }
            }).start();
            result.put("success",true) ;
            result.put("msg","初始化街道数据到数据库成功") ;
            logger.info("初始化街道数据到数据库成功！");
        }catch (Exception e){
            e.printStackTrace();
            result.put("success",false) ;
            result.put("msg","初始化地址库数据失败"+e.getMessage());
            logger.error("初始化街道数据到数据库失败！");
        }
        return JSONObject.fromObject(result).toString() ;
    }
    /**
     *  初始化街道数据到redis
     * @param
     * @return
     */

    @RequestMapping(value = "/initBasLocalAreaCodeToRedis.do",method = RequestMethod.GET)
    public String initBasLocalAreaCodeToRedis(){

        JSONObject result = new JSONObject() ;
        try {
            RedisOper.save("123456","1234555");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    gisOpertService.insertLocalAreaCodeToRedis();
                }
            }).start();
            result.put("success",true) ;
            result.put("msg","初始化街道数据到redis成功") ;
            logger.info("初始化街道数据到redis成功！");
        }catch (Exception e){
            e.printStackTrace();
            result.put("success",false) ;
            result.put("msg","初始化地址库数据失败"+e.getMessage());
            logger.error("初始化街道数据到redis失败");
        }
        return JSONObject.fromObject(result).toString() ;
    }

    @ResponseBody
    @RequestMapping(value = "/getRedisData.do",method = RequestMethod.GET)
    public ResponseEntity<String> getRedisData(HttpServletRequest request, HttpServletResponse response){

        HttpHeaders headers = new HttpHeaders() ;
        headers.set("Content-Type","application/json;charset=utf-8");
        BasLocation basLocation = new BasLocation() ;
        Map<String,Object> result = new HashMap<String, Object>() ;

        try {
            request.setCharacterEncoding("utf-8");
            response.setContentType("text/html;charset=utf-8");
            String requestParam = request.getParameter("locationId") ;
            logger.info("请求参数：{}",requestParam);
            basLocation = gisOpertService.getRedisDataByLocationId(requestParam) ;
            logger.info("响应参数：{}",JSONObject.fromObject(basLocation).toString());
            result.put("data",basLocation) ;

        }catch (Exception e){
            e.printStackTrace();
            logger.error("查询异常，请输入正确的locationId");
        }

        return new ResponseEntity<String>(JSONObject.fromObject(result).toString(),headers, HttpStatus.OK) ;
    }

    @ResponseBody
    @RequestMapping(value = "/rabbitmqReceive.do",method = RequestMethod.GET)
    public void rabbitmqReceive(){

        rabbitTemplate.convertAndSend("GIS_data_out","","哈哈哈哈哈哈");
    }


}

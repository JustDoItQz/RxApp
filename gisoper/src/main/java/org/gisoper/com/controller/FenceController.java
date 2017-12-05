package org.gisoper.com.controller;

import org.common.com.utils.ESBOper;
import org.gisoper.com.service.FenceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/fence")
public class FenceController {

    public static Logger logger = LoggerFactory.getLogger(FenceController.class) ;

    @Autowired
    private FenceService fenceService ;

    //电子围栏定时任务
    @ResponseBody
    @RequestMapping("/fenceTimer")
    public String fence(@RequestBody(required = false)String request){

        String serviceCode = "" ;
        try{
            fenceService.triggerFence();
            return ESBOper.returnResponseSuccess(serviceCode,"true") ;
        }catch (Exception e){
            e.printStackTrace();
            return ESBOper.returnResponseErr(serviceCode,e.getMessage()) ;

        }

    }

    //电子围栏补偿机制
    @ResponseBody
    @RequestMapping("/fenceCompensate")
    public String fenceCompensate(@RequestBody(required = false)String request){

        String serviceCode="" ;
        try{
            fenceService.fenceCompensate() ;
            return ESBOper.returnResponseSuccess(serviceCode,"true") ;
        }catch (Exception e){
            e.printStackTrace();
            return ESBOper.returnResponseErr(serviceCode,"false") ;
        }
    }

    //创建电子围栏
    @ResponseBody
    @RequestMapping(value = "/createFence",method = RequestMethod.POST)
    public String createFence(@RequestBody(required = false)String request){
        String result = null ;
        try{
            logger.info("请求参数：{}",request);
            result = fenceService.createFence(request) ;
            logger.info("返回参数：{}",result);
        }catch (Exception e){
            e.printStackTrace();
            logger.error("创建电子围栏异常:{}",e.getMessage());
        }
        return result ;
    }

    //查询电子围栏
    @ResponseBody
    @RequestMapping(value = "/queryFence",method = RequestMethod.GET)
    public String queryFence(HttpServletRequest request, HttpServletResponse response){
        String result = null ;
        try{
            result = fenceService.queryFence(request) ;
        }catch (Exception e){
            e.printStackTrace();
            logger.error("查询电子围栏出错：{}",e.getMessage());
        }
        return result ;
    }

    //更新电子围栏
    @ResponseBody
    @RequestMapping(value = "/updateFence",method = RequestMethod.POST)
    public String updateFence(@RequestBody(required = false)String request){
        String result = null ;
        try{
            logger.info("请求参数：{}",request);
            result = fenceService.updateFence(request) ;
            logger.info("返回参数：{}",result);
        }catch (Exception e){
            e.printStackTrace();
            logger.error("请求数据异常：{}",e.getMessage());
        }
        return result ;
    }



}

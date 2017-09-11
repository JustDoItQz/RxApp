package org.gisoper.com.controller;

import org.common.com.utils.ESBOper;
import org.gisoper.com.service.FenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/fence")
public class FenceController {

    @Autowired
    private FenceService fenceService ;

    //电子围栏定时任务
    @ResponseBody
    @RequestMapping("/fence")
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

}

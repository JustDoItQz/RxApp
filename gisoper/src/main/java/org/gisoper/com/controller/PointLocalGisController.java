package org.gisoper.com.controller;

import org.gisoper.com.service.PointLocalService;
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

/*地址库操作界面展示*/
@RequestMapping("/pointLocalGis")
@Controller
public class PointLocalGisController {

    public static Logger logger = LoggerFactory.getLogger(PointLocalGisController.class) ;

    @Autowired
    private PointLocalService pointLocalService ;


    //查询所有省数据
    @ResponseBody
    @RequestMapping("/searchAddressByKey")
    public String searchAddressByKey(HttpServletRequest request, HttpServletResponse response){
        String result = null ;
        try {
            String locationLevel = request.getParameter("locationLevel") ;
            String locationId = request.getParameter("locationId") ;
            String page = request.getParameter("page") ;
            String pageSize = request.getParameter("pageSize") ;
            StringBuffer sb = new StringBuffer() ;
            sb.append("locationLevel="+locationLevel+"  locationId="+locationId) ;
            logger.info("请求参数：{}",sb);
            result =  pointLocalService.searchAddressByKey(locationLevel,locationId,page,pageSize) ;
            logger.info("返回参数：{}",result) ;

        }catch (Exception e){
            e.printStackTrace();
            logger.error("请求数据出现异常:{}",e.getMessage());
        }

        return result ;
    }

    //根据经纬度查询位置（高德）
    @ResponseBody
    @RequestMapping(value = "/searchAddressByLatLng",method = RequestMethod.POST)
    public String searchAddressByLatLng(@RequestBody(required = false)String request){
        String result = null ;
        try {
            logger.info("请求参数:{}",request);
            result = pointLocalService.searchAddressByLatLng(request) ;
            logger.info("返回参数：{}",result);
        }catch (Exception e){
            e.printStackTrace();
            logger.error("请求数据出现异常:{}",e.getMessage());
        }
        return result ;
    }
    //根据地址查询经纬度
    @ResponseBody
    @RequestMapping(value = "/searchLatLngByAddress",method = RequestMethod.POST)
    public String searchLatLngByAddress(@RequestBody(required = false)String request){
        String result = null ;
        try{
            logger.info("请求参数:{}",request);
            result = pointLocalService.searchLatLngByAddress(request) ;
            logger.info("返回参数:{}",result);
        }catch (Exception e){
            e.printStackTrace();
            logger.error("请求数据出现异常:{}",e.getMessage());
        }
        return result ;
    }
    //根据起始点和结束点规划路径
    @ResponseBody
    @RequestMapping(value = "/drivingPlan",method = RequestMethod.POST)
    public String drivingPlan(@RequestBody(required = false)String request){
        String result = null ;
        try{
            logger.info("请求参数：{}",request);
            result = pointLocalService.drivingPlan(request) ;
            logger.info("返回参数：{}",result);
        }catch (Exception e){
            e.printStackTrace();
            logger.error("请求数据异常:{}",e.getMessage());
        }
        return result ;
    }
    //根据起始点和结束点查询两点间的距离
    @ResponseBody
    @RequestMapping(value = "/searchDistanceByStartAndEndAddress",method = RequestMethod.POST)
    public String searchDistanceByStartAndEndAddress(@RequestBody(required = false)String request){
        String result = null ;
        try {
            logger.info("请求参数：{}",request);
            result = pointLocalService.searchDistanceByStartAndEndAddress(request) ;
            logger.info("返回参数：{}",result);
        }catch (Exception e){
            e.printStackTrace();
            logger.error("请求数据出错：{}",e.getMessage());
        }
        return result ;
    }
    //根据ip定位
    @ResponseBody
    @RequestMapping(value = "/locationByIp",method = RequestMethod.POST)
    public String locationByIp(@RequestBody(required = false)String request){

        String result = null ;
        try {
            logger.info("请求参数：{}",request);
            result = pointLocalService.locationByIp(request) ;
            logger.info("返回参数：{}",result);
        }catch (Exception e){
            e.printStackTrace();
            logger.error("数据请求出现异常:{}",e.getMessage());
        }
        return result ;
    }

    //批量地址转经纬度
    @ResponseBody
    @RequestMapping(value = "/searchLatLngByAddressBatch",method = RequestMethod.POST)
    public String searchLatLngByAddressBatch(@RequestBody(required = false)String request){
        String result = "" ;
        try{
            result = pointLocalService.searchLatLngByAddressBatch(request) ;
        }catch (Exception e){
            e.printStackTrace();
            logger.error("请求数据出现异常：{}",e.getMessage());
        }
        return result ;
    }
    


}

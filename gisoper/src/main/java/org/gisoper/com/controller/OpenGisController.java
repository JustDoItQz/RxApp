package org.gisoper.com.controller;

import com.google.gson.reflect.TypeToken;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.common.com.utils.*;
import org.gisoper.com.service.GisOperService;
import org.gisoper.com.service.OpenGisService;
import org.gisoper.com.vo.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Controller
@RequestMapping("/openGis")
public class OpenGisController {

    private static Logger logger = LoggerFactory.getLogger(OpenGisController.class) ;

    @Autowired
    private OpenGisService openGisService ;
    @Autowired
    private GisOperService gisOperService ;

    @ResponseBody
    @RequestMapping(value = "/insertVehicleDeviceESB",method = RequestMethod.POST)
    public String insertVehicleDevice(HttpServletRequest request){
        String data = null ;
        boolean isAes = false ;
        try{
            if (EncryptionUtil.isAes(request.getParameter("data"))){
                isAes=true ;
                data = request.getParameter("data") ;
            }else {
                isAes=false ;
                data = EncryptionUtil.getEncryption(request.getParameter("data")) ;
            }
        }catch (Exception e){
            JSONObject object = new JSONObject() ;
            object.put("success","false") ;
            object.put("msg","数据格式校验错误") ;
            if (isAes){
                return  object.toString() ;
            }else{
                return EncryptionUtil.setEncryption(request.toString()) ;
            }
        }
        TVehicleDevice vehicleDevice = (TVehicleDevice)parseToObj(data,TVehicleDevice.class) ;
        if (isAes){
            return openGisService.insertVehicleDevice(vehicleDevice) ;
        }else {
            return EncryptionUtil.setEncryption(openGisService.insertVehicleDevice(vehicleDevice)) ;
        }


    }

    @ResponseBody
    @RequestMapping(value = "/deleteVehicleDeviceByIdESB",method = RequestMethod.POST)
    public String deleteVehicleDeviceById(HttpServletRequest request){
        try{
            String vehicleDeviceId = request.getParameter("deviceId") ;
            return openGisService.deleteVehicleDeviceById(vehicleDeviceId) ;
        }catch (Exception e){
            e.printStackTrace();
            JSONObject result = new JSONObject() ;
            result.put("success","false") ;
            result.put("msg","数据格式校验失败") ;
            logger.error("删除数据失败:{},{}",e.getMessage(),result);
            return result.toString() ;
        }
    }
    //根据起始点和结束点查询两点间的距离
    @ResponseBody
    @RequestMapping(value = "/searchStartEndDistanceESB",method = RequestMethod.POST)
    public String searchStartEndDistanceESB(@RequestBody(required = false)String request){

        OpenAPIResultVo result = new OpenAPIResultVo(); ;
        TypeToken<StartEndDistance.Request> typeToken = new TypeToken<StartEndDistance.Request>(){} ;
        RequestHeader header = new RequestHeader() ;
        RequetESB<StartEndDistance.Request> requetESB = new RequetESB<StartEndDistance.Request>() ;
        try{
            requetESB = ESBOper.getRequest(request,typeToken) ;
            header = requetESB.getHeader() ;
            StartEndDistance.Request body = requetESB.getBody() ;
            String startAddress = body.getOrigin() ;
            String endAddress = body.getDestination() ;
            if (StringUtils.isBlank(startAddress)){
                result.setSuccess("false");
                result.setMsg(startAddress+":起始地址有误!");
                return ESBOper.returnResponseSuccess(header.getServiceCode(),header.getReqSysCode(),JSONObject.fromObject(result).toString()) ;
            }
            if (StringUtils.isBlank(endAddress)){
                result.setSuccess("false");
                result.setMsg(endAddress+":结束地址有误！");
                return ESBOper.returnResponseSuccess(header.getServiceCode(),header.getReqSysCode(),JSONObject.fromObject(result).toString()) ;
            }
            result = openGisService.searchStartEndDistance(startAddress,endAddress) ;
            return ESBOper.returnResponseSuccess(header.getServiceCode(),header.getReqSysCode(),JSONObject.fromObject(result).toString()) ;

        }catch (Exception e){
            e.printStackTrace();
            result.setSuccess("false");
            result.setMsg("获取两点间距离失败,"+e.getMessage());
            return ESBOper.returnResponseSuccess(header.getServiceCode(),header.getReqSysCode(),JSONObject.fromObject(result).toString()) ;
        }

    }

    //根据经纬度转地址(批量接口,目前高德只支持20个经纬度)
    @ResponseBody
    @RequestMapping(value = "/lngLatConvertAddressBatchESB",method = RequestMethod.POST)
    public String lngLatConvertAddressBatchESB(@RequestBody(required = false)String request){

        Map<String,Object> resultMap = new HashMap<String, Object>() ;
        TypeToken<LngLatVo.ListRequest> typeToken = new TypeToken<LngLatVo.ListRequest>(){} ;
        RequetESB<LngLatVo.ListRequest> requetESB = new RequetESB<LngLatVo.ListRequest>() ;
        LngLatVo.ListRequest listVo = new LngLatVo.ListRequest() ;
        RequestHeader header = new RequestHeader() ;
        try{
            requetESB = ESBOper.getRequest(request,typeToken) ;
            header = requetESB.getHeader() ;
            listVo = requetESB.getBody() ;
            List<LngLatVo.ListResponse> result =  openGisService.lngLatConvertAddressBatchESB(listVo) ;
            resultMap.put("data",JSONObject.fromObject(result).toString()) ;
            resultMap.put("success","true") ;
        }catch (Exception e){
            e.printStackTrace();
            resultMap.put("success","false") ;
            resultMap.put("msg","查询异常："+e.getMessage()) ;
            logger.error("查询异常：{}",e.getMessage());
        }
        return ESBOper.returnResponseSuccess(header.getServiceCode(),header.getReqSysCode(),JSONObject.fromObject(resultMap).toString()) ;

    }

    //根据地址转经纬度
    @ResponseBody
    @RequestMapping(value = "/addressConvertLnglatBatchESB",method = RequestMethod.POST)
    public String addressConvertLnglatBatchESB(@RequestBody(required = false)String request){

        Map<String,Object> resultMap = new HashMap<String, Object>() ;
        TypeToken<LngLatVo.ListAddress> typeToken = new TypeToken<LngLatVo.ListAddress>(){} ;
        RequetESB<LngLatVo.ListAddress> requetESB = new RequetESB<LngLatVo.ListAddress>() ;
        LngLatVo.ListAddress listVo = new LngLatVo.ListAddress() ;
        RequestHeader header = new RequestHeader() ;
        try{
            requetESB = ESBOper.getRequest(request,typeToken) ;
            header=requetESB.getHeader() ;
            listVo = requetESB.getBody() ;
            Map<String,List<AddressInfoVo>> map= gisOperService.addressInfoBatch(listVo.getList()) ;
            List<AddressInfoVo> listAddressVo= map.get("listAddressVo") ;
            List<AddressInfoVo> errorList = map.get("errorList") ;
            resultMap.put("success","true") ;
            resultMap.put("listData",listAddressVo) ;
            resultMap.put("errorListData",errorList) ;
        }catch (Exception e){
            e.printStackTrace();
            resultMap.put("success","false") ;
            resultMap.put("msg","查询异常:"+e.getMessage()) ;
        }
        return ESBOper.returnResponseSuccess(header.getServiceCode(),header.getReqSysCode(),JSONObject.fromObject(resultMap).toString()) ;
    }

    //车辆发车
    @ResponseBody
    @RequestMapping(value = "/leaveWebsiteVehicle",method = RequestMethod.POST)
    public String leaveWebsiteVehicle(HttpServletRequest request){

        Map<String,String> logMap = new HashMap<String, String>() ;
        boolean isAes = false ;
        String data = null ;
        try{
            if (EncryptionUtil.isAes(request.getParameter("data"))){

                isAes = true ;
                data = request.getParameter("data") ;
            }else {
                isAes = false ;
                data = EncryptionUtil.getEncryption(request.getParameter("data")) ;
            }
            logger.info("车辆发车{}",data);
        }catch (Exception e){
            e.printStackTrace();
            JSONObject result = new JSONObject() ;
            result.put("success","false") ;
            result.put("msg","数据格式校验出错") ;
            logger.error("车辆发车失败 :{},{}",e,result);

            if (isAes){
                return result.toString() ;
            }else{
                return EncryptionUtil.setEncryption(result.toString()) ;
            }
        }
        JSONObject json = JSONObject.fromObject(data) ;
        String vehicleNo = json.getString("vehiclenum") ;
        String leavePointId = json.getString("id") ;
        logMap.put("vehicleNo","车辆对应车牌号为："+vehicleNo) ;
        logMap.put("leavePointId","网点id为："+leavePointId) ;
        logger.info("车辆网点发车成功：{}",logMap);
        if (isAes){
            return openGisService.leaveWebsiteVehicle(leavePointId,vehicleNo) ;
        }else{
            return EncryptionUtil.setEncryption(openGisService.leaveWebsiteVehicle(leavePointId,vehicleNo)) ;
        }

    }

    //车辆签到
    @ResponseBody
    @RequestMapping(value = "/signInVehicle",method = RequestMethod.POST)
    public String signInVehicle(HttpServletRequest request){
        Map<String,Object> logMap = new HashMap<String, Object>() ;
        logMap.put("start","车辆网点签到开始！") ;
        String data = null ;
        boolean isAes = false ;

        try{
            if (EncryptionUtil.isAes(request.getParameter("data"))){
                isAes = true ;
                data = request.getParameter("data") ;
            }else {
                data = EncryptionUtil.setEncryption(request.getParameter("data")) ;
            }
            logger.info("车辆网点签到");
        }catch (Exception e){
            e.printStackTrace();
            JSONObject result = new JSONObject() ;
            result.put("msg","数据校验错误！");
            result.put("suceess","false") ;
            logger.error("网点签到失败:{},{}",e.getMessage(),result);
        }
        JSONObject object = JSONObject.fromObject(request.getParameter("data")) ;
        String vehicleNo = object.getString("vehiclenum") ;
        logMap.put("vehicleNo","车牌号为："+vehicleNo) ;
        String id = object.getString("id") ;
        logMap.put("arrivePointId","对应网点ID为："+id) ;
        if (isAes){
            return openGisService.signInVehicle(id,vehicleNo) ;
        }else {
            return EncryptionUtil.setEncryption(openGisService.signInVehicle(id,vehicleNo)) ;
        }

    }

    //通过id删除车辆网点
    @ResponseBody
    @RequestMapping(value = "/deleteVehicleWebsiteESB",method = RequestMethod.POST)
    public String deleteVehicleWebsiteESB(@RequestBody(required = false)String request){
        String result = null ;
        Map<String,Object> resultMap = new HashMap<String, Object>() ;
        TypeToken<IDVo> typeToken = new TypeToken<IDVo>(){} ;
        RequetESB<IDVo> requetESB = new RequetESB<IDVo>() ;
        IDVo requestVo = new IDVo() ;
        RequestHeader header = new RequestHeader() ;
        try{
            requetESB = ESBOper.getRequest(request,typeToken) ;
            header = requetESB.getHeader() ;
            requestVo = requetESB.getBody() ;
            if (StringUtils.isNotBlank(requestVo.getId())){
                result = openGisService.deleteVehicleWebsiteById(requestVo.getId()) ;
            }else {
                JSONObject jsonObject = new JSONObject() ;
                jsonObject.put("success","false") ;
                jsonObject.put("msg","网点ID不能为空！") ;
                result = jsonObject.toString() ;
                return ESBOper.returnResponseErr(header.getServiceCode(),header.getReqSysCode(),result,"") ;
            }
            return ESBOper.returnResponseSuccess(header.getServiceCode(),header.getReqSysCode(),result) ;
        }catch (Exception e){
            e.printStackTrace();
            logger.error("{}删除网点失败,{}",requestVo.getId(),e.getMessage());
            return ESBOper.returnResponseErr(header.getServiceCode(),e.getMessage()) ;
        }
    }

    //电子围栏
    @ResponseBody
    @RequestMapping(value = "/insertVehicleWebsiteESB",method = RequestMethod.POST)
    public String insertVehicleWebsiteESB(@RequestBody(required = false)String request){

        String result = null ;
        JSONObject object = new JSONObject() ;
        TypeToken<TVehicleWebsite> typeToken = new TypeToken<TVehicleWebsite>(){} ;
        RequetESB<TVehicleWebsite> requetESB = new RequetESB<TVehicleWebsite>() ;
        TVehicleWebsite requestVo = new TVehicleWebsite() ;
        RequestHeader header = new RequestHeader() ;
        try{
            requetESB = ESBOper.getRequest(request,typeToken) ;
            header = requetESB.getHeader() ;
            requestVo = requetESB.getBody() ;
            if (StringUtils.isNotBlank(requestVo.getId())){
                result = openGisService.insertVehicleWebsite(requestVo) ;
            }else {
                object.put("success","网点ID不能为空") ;
                object.put("msg","网点ID不能为空") ;
                result = object.toString() ;
                return ESBOper.returnResponseErr(header.getServiceCode(),header.getReqSysCode(),result,"") ;
            }
            return ESBOper.returnResponseSuccess(header.getServiceCode(),header.getReqSysCode(),result) ;
        }catch (Exception e){
            e.printStackTrace();
            logger.error("增加电子围栏失败,{}",e.getMessage());
            return ESBOper.returnResponseErr(header.getServiceCode(),header.getReqSysCode(),result,"") ;
        }
    }

    //网点初始化
    @ResponseBody
    @RequestMapping(value = "/initWebsiteESB")
    public String initWebsiteESB(@RequestBody(required = false)String request){
        String result = "" ;
        String serviceCode = ""
 ;        try{
            synchronized (this){
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        openGisService.initWebsite();
                    }
                }).start();
            }
            return ESBOper.returnResponseSuccess(serviceCode,"true") ;
        }catch (Exception e){
            e.printStackTrace();
            return ESBOper.returnResponseErr(serviceCode,e.getMessage()) ;
        }
    }

    protected Object parseToObj(String data,Class<?> clazz){
        Object obj = new Object() ;
        if (null!=data){
            JSONObject json = JSONObject.fromObject(data) ;

            obj = JSONObject.toBean(json,clazz) ;
        }
        return obj ;
    }

   /* @RequestMapping("/redisMethod")
    @ResponseBody
    private void executeRedis(){

        controllerTime("time");

    }
    public  void controllerTime(String time){
        String key = RedisOper.get(time) ;
        if (key.equals(null)){
            RedisOper.setExpires(time,10);
            executeMethod() ;
            System.out.println("----------------方法执行----------------"+ DateUtils.convert(new Date(),"yyyy年MM月dd日 HH时mm分ss秒"));
        }
    }*/

    public void executeMethod(){
        ExecutorService pool = Executors.newFixedThreadPool(3) ;
        Runnable t1 = new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<50;i++){
                    System.out.println("t1--i="+i);
                }

            }
        } ;
        pool.execute(t1);
        try {
            pool.awaitTermination(Long.MAX_VALUE, TimeUnit.MINUTES) ;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Runnable t2 = new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<100;i++){
                    System.out.println("t2-----i="+i);

                }
            }
        } ;
        pool.execute(t2);
        pool.shutdown();
    }






}
